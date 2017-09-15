package fr.aberwag.family.exception;

import java.util.ArrayList;
import java.util.List;

import fr.aberwag.family.exception.error.ErrorUtil;
import fr.aberwag.family.exception.local.CurrentLocale;

public class FamilyException extends RuntimeException {

	private static final long serialVersionUID = 2386107358562784240L;

	private String errorCode;

	private String errorMessage;

	private List<String> fields;

	public FamilyException() {
	}

	public FamilyException(String errorCode) {
		this(errorCode, (Object) null);
	}

	public FamilyException(String errorCode, Object... arguments) {
		this(null, errorCode, arguments);
	}

	public FamilyException(Throwable cause, String errorCode) {
		this(cause, errorCode, (Object) null);
	}

	public FamilyException(Throwable cause, String errorCode, Object... arguments) {
		super(ErrorUtil.getErrorMessage(CurrentLocale.getCurrentLocale(), errorCode, arguments), cause);
		this.fields = new ArrayList<String>();
		for (Object o : arguments) {
			if (o != null) {
				this.fields.add(o.toString());
			}
		}
		this.errorCode = errorCode;
		this.errorMessage = ErrorUtil.getErrorMessage(CurrentLocale.getCurrentLocale(), errorCode, arguments);
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String message) {
		this.errorMessage = message;
	}

	public List<String> getFields() {
		return fields;
	}

	public void setFields(List<String> fields) {
		this.fields = fields;
	}

}
