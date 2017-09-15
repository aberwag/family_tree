package fr.aberwag.family.exception.error;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;

public final class ErrorUtil {

	private ErrorUtil() {

	}

	/**
	 * messageSource is initialized throw Spring
	 */
	private static MessageSource messages;

	public static void setMessages(MessageSource messages) {
		ErrorUtil.messages = messages;
	}

	private static final String ERROR_BASE = "errorMessage.";
	private static final String DEFAULT_ERROR_MESSAGE = "Default error message";

	/**
	 * Get an error message from the error code and a list of Object to
	 * substitute in the predefined message
	 *
	 * @param errorCode
	 *            code defined in the errors message bundle
	 * @param arguments
	 *            variable arguments of the base message or <code>null</code> if
	 *            the base message does not contain variables
	 * @return formatted error message based on <code>errorCode</code> and
	 *         <code>arguments</code>
	 */
	public static String getErrorMessage(Locale locale, String errorCode, Object... arguments) {
		String msg = null;
		if (errorCode != null) {
			if (messages != null) {
				try {
					msg = messages.getMessage(ERROR_BASE + errorCode, arguments == null ? null : arguments.clone(),
							locale);
				} catch (NoSuchMessageException e) {
					if (Locale.ENGLISH.equals(locale)) {
						throw e;
					}
					msg = messages.getMessage(ERROR_BASE + errorCode, arguments == null ? null : arguments.clone(),
							Locale.ENGLISH);
				}
			} else {
				// default mechanism when the message source is not found
				return DEFAULT_ERROR_MESSAGE;
			}
		} else {
			return null;
		}
		return msg;
	}

	/**
	 * Get an error message from an error code.
	 *
	 * @param errorCode
	 *            code defined in the errors message bundle
	 * @return formatted error message based on <code>errorCode</code>
	 */
	public static String getErrorMessage(String errorCode) {
		return getErrorMessage(Locale.ENGLISH, errorCode, (Object[]) null);
	}
}