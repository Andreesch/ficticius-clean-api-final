package br.ficticius.clean.response.error;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ErrorObject implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private final String field;
	private final String message;
	private final Object parameter;
}
