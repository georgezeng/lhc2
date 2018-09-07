package net.geozen.lhc2.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsUtils;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.util.NestedServletException;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.geozen.lhc2.dto.Result;
import net.geozen.lhc2.exception.BusinessException;
import net.geozen.lhc2.utils.CommonUtil;

@Component
public class ErrorHandlerFilter extends GenericFilterBean {
	@Value("${access.control.allow.origin}")
	private String origin;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		try {
			HttpServletRequest req = (HttpServletRequest) request;
			if (CorsUtils.isPreFlightRequest(req)) {
				HttpServletResponse res = (HttpServletResponse) response;
				res.addHeader("Access-Control-Allow-Origin", origin);
				res.addHeader("Access-Control-Allow-Methods", req.getHeader("Access-Control-Allow-Methods"));
				res.addHeader("Access-Control-Allow-Credentials", "true");
				res.addHeader("Access-Control-Allow-Headers", "Access-Control-Request-Method, Access-Control-Allow-Origin, Content-Type");
			}
			chain.doFilter(request, response);
		} catch (Exception e) {
			String traceId = CommonUtil.getTraceId();
			if (!(IOException.class.isAssignableFrom(e.getClass()) && e.getMessage().toLowerCase().contains("reset by peer"))) {
				logger.error("[" + traceId + "]" + e.getMessage(), e);
			}
			String msg = null;
			HttpServletResponse res = (HttpServletResponse) response;
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			if (!response.isCommitted()) {
				if (BusinessException.class.isAssignableFrom(e.getClass())) {
					BusinessException ex = (BusinessException) e;
					msg = ex.getMessage();
				} else if (ValidationException.class.isAssignableFrom(e.getClass())) {
					if (ConstraintViolationException.class.isAssignableFrom(e.getClass())) {
						msg = "";
						ConstraintViolationException cve = (ConstraintViolationException) e;
						for (ConstraintViolation<?> cv : cve.getConstraintViolations()) {
							msg += cv.getMessage() + "\n";
						}
					}
				} else if (NestedServletException.class.isAssignableFrom(e.getClass())) {
					Throwable cause = ((NestedServletException) e).getRootCause();
					if (BusinessException.class.isAssignableFrom(cause.getClass())) {
						BusinessException ex = (BusinessException) cause;
						msg = ex.getMessage();
					} else if (ValidationException.class.isAssignableFrom(cause.getClass())) {
						if (ConstraintViolationException.class.isAssignableFrom(cause.getClass())) {
							msg = "";
							ConstraintViolationException cve = (ConstraintViolationException) cause;
							for (ConstraintViolation<?> cv : cve.getConstraintViolations()) {
								msg += cv.getMessage() + "\n";
							}
						}
					}
				}
				if (msg == null) {
					msg = "系统错误";
					res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
				}
				ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
				String result = mapper.writeValueAsString(Result.genFailResult(null, traceId, msg));
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().print(result);
				response.getWriter().flush();
				response.getWriter().close();
			}
		}
	}

}
