package com.employeeapp.exceptionhandler;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@RestController
public class InvalidExceptionHandler {
	
	@ExceptionHandler(Exception.class) 
	public ResponseEntity<ErrorResponse>handleOtherExceptions(Exception ex,WebRequest request){
		  List<String> errors = new ArrayList<>();
		  errors.add("bad request exception for method validation");
		  ErrorResponse response=new ErrorResponse(HttpStatus.BAD_REQUEST,LocalDateTime.now() ,"You are Entring rong details in url",errors,request.getDescription(false)); 
		  return new ResponseEntity<ErrorResponse>(response,HttpStatus.BAD_REQUEST);
	}
}