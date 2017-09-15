package fr.aberwag.family.exception;

public class FamilyBusinessException extends FamilyException {

	public FamilyBusinessException() {
		super();
	}

	/**
	 * @param errorCode
	 * @param arguments
	 */
	public FamilyBusinessException(String errorCode, Object... arguments) {
		super(errorCode, arguments);
	}

	/**
	 * @param errorCode
	 */
	public FamilyBusinessException(String errorCode) {
		super(errorCode);
	}

	/**
	 * @param cause
	 * @param errorCode
	 * @param arguments
	 */
	public FamilyBusinessException(Throwable cause, String errorCode, Object... arguments) {
		super(cause, errorCode, arguments);
	}

	/**
	 * @param cause
	 * @param errorCode
	 */
	public FamilyBusinessException(Throwable cause, String errorCode) {
		super(cause, errorCode);
	}

}
