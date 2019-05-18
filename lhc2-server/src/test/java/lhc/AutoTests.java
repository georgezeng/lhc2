package lhc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AutoTests {
	@SuppressWarnings("unchecked")
	@Test
	public void test() throws Exception {
		int timeout = 1000000;
		Response response = Jsoup.connect("https://93977aa.com/Mobile/Login").timeout(timeout).execute();
		Elements els = response.parse().getElementsByAttributeValue("name", "__RequestVerificationToken");
		String token = els.get(0).val();
		RestTemplate client = new RestTemplate();
		String cookies = "";
		for (Map.Entry<String, String> cookie : response.cookies().entrySet()) {
			cookies += cookie.getKey() + "=" + cookie.getValue() + "; ";
		}
		StringBuilder payload = new StringBuilder();
		payload.append("LoginName=feleio").append("&");
		payload.append("LoginPass=831213").append("&");
		payload.append("IsH5=1");
		RequestEntity<String> request = RequestEntity.post(null).accept(MediaType.APPLICATION_JSON_UTF8).header("X-Requested-With", "XMLHttpRequest")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED).header("Cookie", cookies).header("RequestVerificationToken", token)
				.body(payload.toString());
		ResponseEntity<String> res = client.postForEntity("https://93977aa.com/Common/Login", request, String.class);
		Map<String, String> loginInfo = new ObjectMapper().readValue(res.getBody(), Map.class);
		String uid = loginInfo.get("uid");
		res = client.getForEntity("https://93977aa.com/Mobile/GotoGame?GameType=LOTTERY&GameId=1&uid="+uid, String.class);
//		List<String> cks = res.getHeaders().get(HttpHeaders.COOKIE);
//		Map<String, String> ckMap = new HashMap<>();
//		for(String ck : cks) {
//			String[] ckarr = ck.split("=");
//			ckMap.put(ckarr[0], ckarr[1]);
//		}
		response = Jsoup.connect("https://xlwap.playgamings.com/Public/Games/1").timeout(timeout).execute();
		System.out.println(response.body());
		
	}
}
