package com.employeeapp.exceptionhandler;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
public class ErrorResponse {
	private HttpStatus status;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timeStamp;
	private String message;
	private List<String> errors;
	private String path;
	public List<String> getErrors() {
		return errors;
	}
	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	public ErrorResponse(HttpStatus status, LocalDateTime timeStamp, String message, List<String> errors,
			String path) {
		super();
		this.status = status;
		this.timeStamp = timeStamp;
		this.message = message;
		this.errors = errors;
		this.path = path;
	}
	public ErrorResponse() {
		
	}
}