package com.jbm.spring_boot_crud_mysql.exception;


import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

//This annotation makes this class a GLOBAL exception handler
//It handles exceptions thrown from any controller
@RestControllerAdvice
public class MyApplicationExceptionHandler {
	  // This method handles all RuntimeException in the application
	  @ExceptionHandler(value = RuntimeException.class)
	    public ResponseEntity<?> RuntimeException( RuntimeException exception){
	    	HashMap<String, Object> response=new HashMap<String,Object>();
	    	exception.printStackTrace();
	    	response.put("message", exception.getMessage());
	    	return ResponseEntity.ok(response);
	    }
	  
	  // This method handles validation errors when using @Valid with @RequestBody
	  @ExceptionHandler(MethodArgumentNotValidException.class)
	  public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException exception) {
		  
		

	      HashMap<String, Object> response = new HashMap<>();
	      
//	      List<FieldError> errors=exception.getFieldErrors();
//	      
//		  for(FieldError fieldError:errors) {
//			  String fieldName=fieldError.getField();
//			  String message=fieldError.getDefaultMessage();
//			  response.put(fieldName, message);
//		  }
	      exception.getFieldErrors().forEach(e->{
	    	  String fieldName=e.getField();
	    	  String message=e.getDefaultMessage();
	    	  response.put(fieldName,message);
	      });
	  return ResponseEntity.ok(response);
	  }
	  
	  // This method handles validation errors for
	    // @RequestParam, @PathVariable, etc.
	  @ExceptionHandler(HandlerMethodValidationException.class)
	  public ResponseEntity<?> handleValidationException(HandlerMethodValidationException exception) {

	      HashMap<String, String> response = new HashMap<>();

	      exception.getAllErrors().forEach(error -> {
	          String fieldName = ((FieldError) error).getField();
	          String message = error.getDefaultMessage();
	          response.put(fieldName, message);
	      });

	      return ResponseEntity.ok(response);
	  }

}