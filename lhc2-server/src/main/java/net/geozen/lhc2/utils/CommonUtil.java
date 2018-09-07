package net.geozen.lhc2.utils;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Future;

import org.slf4j.MDC;

public class CommonUtil {
	public static String getTraceId() {
		String traceId = MDC.get("X-B3-TraceId");
		if (traceId == null) {
			traceId = new Random().nextInt(999999) + "";
			MDC.put("X-B3-TraceId", traceId);
		}
		return traceId;
	}

	public static <T> void wait(List<Future<T>> futures) {
		while (true) {
			int count = 0;
			for (Future<T> f : futures) {
				if (f.isDone()) {
					count++;
				}
			}
			if (count == futures.size()) {
				break;
			}
			try {
				Thread.sleep(1000l);
			} catch (InterruptedException e) {
			}
		}
	}

}
