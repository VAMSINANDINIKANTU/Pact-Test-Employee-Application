package com.employeeapp.exceptionhandler;
public class EmployeeNotFoundException extends RuntimeException{
   private static final long serialVersionUID = 1L;
   public EmployeeNotFoundException(Long id)
   {
	   super("Employee id not found : " + id);
   }
   public EmployeeNotFoundException(String name)
   {
	   super("Employee name not found : " + name);
	   
   }
}