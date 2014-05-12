package br.com.corsini.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

public final class Log {

	private final Logger logger;

	public Log(@SuppressWarnings("rawtypes") Class clazz) {
		logger = Logger.getLogger(clazz);
	}

	public Log(String clazz) {
		logger = Logger.getLogger(clazz);
	}

	public void info(String msg, Object... objects) {
		if (objects.length == 0) {
			logger.info(msg);
		} else {
			logger.info(String.format(msg, objects));
		}
	}

	public void warn(String msg, Object... objects) {
		if (objects.length == 0) {
			logger.warn(msg);
		} else {
			logger.warn(String.format(msg, objects));
		}
	}

	public void error(String msg, Object... objects) {
		if (objects.length == 0) {
			logger.error(msg);
		} else {
			logger.error(String.format(msg, objects));
		}
	}

	public void error(String msg, Throwable e, Object... objects) {
		if (objects.length == 0) {
			logger.error(msg, e);
		} else {
			logger.error(String.format(msg, objects), e);
		}
	}

	public void fatal(String msg, Object... objects) {
		if (objects.length == 0) {
			logger.fatal(msg);
		} else {
			logger.fatal(String.format(msg, objects));
		}
	}

	public void fatal(String msg, Throwable e, Object... objects) {
		if (objects.length == 0) {
			logger.fatal(msg, e);
		} else {
			logger.fatal(String.format(msg, objects), e);
		}
	}

	public void debug(String msg, Object... objects) {
		if (!logger.isDebugEnabled()) {
			return;
		}

		if (objects.length == 0) {
			logger.debug(msg);
		} else {
			logger.debug(String.format(msg, objects));
		}
	}

	public boolean isDebugEnabled() {
		return logger.isDebugEnabled();
	}

	public static String format(Date date) {
		if (date == null) {
			return null;
		}

		return (new SimpleDateFormat("yyyy-MM-dd")).format(date);
	}

}