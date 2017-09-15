package fr.aberwag.family.exception;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import fr.aberwag.family.domain.ExceptionMessage;

@RestControllerAdvice
public class FamilyExceptionHandlerControllerAdvice {

	public static final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

	@ExceptionHandler(FamilyBusinessException.class)
	public ExceptionMessage familyBusinessException(FamilyBusinessException exception) {
		ExceptionMessage message = ExceptionMessage.builder().date(LocalDateTime.now().format(formatter))
				.className(exception.getClass().getName()).message("message d'erreur geré par @ExceptionHandler")
				.build();

		return message;
	}

	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<ExceptionMessage> nullPointerExceptionHandler(HttpServletRequest request,
			NullPointerException exception) {
		ExceptionMessage message = ExceptionMessage.builder().date(LocalDateTime.now().format(formatter))
				.path(request.getRequestURI().toString() + "?" + request.getQueryString())
				.className(exception.getClass().getName())
				.message(
						"Tu veux éviter les null ? N'hésite pas à lire cet article: https://www.developpez.net/forums/blogs/473169-gugelhupf/b2944/java-astuces-eviter-nullpointerexception/")
				.build();
		return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}