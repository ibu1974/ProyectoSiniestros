package mx.com.gnp.plus.consultasinies.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * The Class Utils.
 */
public final class Utils {

	
	/** The Constant MAX_BUFFER. */
	private static final int MAX_BUFFER = 1000;

	/**
	 * Instantiates a new utils.
	 */
	private Utils() {

	}

	/**
	 * Gets the stack trace.
	 *
	 * @param ex the ex
	 * @return the stack trace
	 */
	public static String getStackTrace(final Exception ex) {
		StringBuilder sb = new StringBuilder(MAX_BUFFER);
		StackTraceElement[] st = ex.getStackTrace();
		sb.append(ex.getClass().getName() + ": " + ex.getMessage() + "\n");
		for (int i = 0; i < st.length; i++) {
			sb.append("\t at " + st[i].toString() + "\n");
		}
		return sb.toString();
	}

	/**
	 * Gets the cause.
	 *
	 * @param ex the ex
	 * @return the cause
	 */
	public static String getCause(final Exception ex) {
		String trace = getStackTrace(ex);
		trace = trace.substring(0, trace.indexOf('\n'));
		return trace;
	}
	


}
