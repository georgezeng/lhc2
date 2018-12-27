package net.geozen.lhc2.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Future;
import java.util.function.Consumer;

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

	public static <T> List<T> waitForResult(List<Future<T>> futures) throws Exception {
		List<T> list = new ArrayList<>();
		while (true) {
			int count = 0;
			for (Future<T> f : futures) {
				if (f.isDone()) {
					list.add(f.get());
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
		return list;
	}

	public static void waitWithException(List<Future<Exception>> futures) throws Exception {
		while (true) {
			int count = 0;
			for (Future<Exception> f : futures) {
				if (f.isDone()) {
					if (f.get() != null) {
						throw new RuntimeException(f.get().getMessage(), f.get());
					}
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

	public static void waitWithException(List<Future<Exception>> futures, Consumer<Exception> c) throws Exception {
		while (true) {
			int count = 0;
			for (Future<Exception> f : futures) {
				if (f.isDone()) {
					if (f.get() != null) {
						c.accept(f.get());
					}
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
