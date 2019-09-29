package br.ficticius.clean.response.error;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ErrorResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private final String message;
	
	private final int code;
	
	private final String status;
	
	private final String objectName;
	
	private final List<ErrorObject> errors;
}
