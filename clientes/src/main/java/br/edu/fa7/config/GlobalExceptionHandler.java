package br.edu.fa7.config;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.NotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.edu.fa7.model.ErrorInfo;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NotFoundException.class)
	@ResponseBody
	public ErrorInfo erro1(HttpServletRequest req, Exception ex) {
		return new ErrorInfo(req.getRequestURI(), ex);
	}
}
