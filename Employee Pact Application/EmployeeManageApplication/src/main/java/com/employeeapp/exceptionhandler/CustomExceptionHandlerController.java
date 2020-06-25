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
public class CustomExceptionHandlerController {
	
    @ExceptionHandler(EmployeeNotFoundException.class) 
    public ResponseEntity<ErrorResponse> handleEmployeeNotFoundException(EmployeeNotFoundException ex,WebRequest request){ 
	     List<String> errors = new ArrayList<>();
	     errors.add(ex.getLocalizedMessage());
	     ErrorResponse response=new ErrorResponse(HttpStatus.NOT_FOUND,LocalDateTime.now(),"record not found",errors,request.getDescription(false));
	     return new ResponseEntity<ErrorResponse>(response,HttpStatus.NOT_FOUND);
	}
    
    @ExceptionHandler(EmployerNotFoundException.class) 
    public ResponseEntity<ErrorResponse> handleEmployerNotFoundException(EmployerNotFoundException ex,WebRequest request){ 
             List<String> errors = new ArrayList<>();
	     errors.add(ex.getLocalizedMessage());
	     ErrorResponse response=new ErrorResponse(HttpStatus.NOT_FOUND,LocalDateTime.now(),"record not found",errors,request.getDescription(false));
	     return new ResponseEntity<ErrorResponse>(response,HttpStatus.NOT_FOUND);
	}
}
