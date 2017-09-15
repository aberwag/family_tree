package fr.aberwag.family.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ExceptionMessage {

	private String message;
	private String className;
	private String path;
	private String date;
}