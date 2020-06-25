package com.employeeapp.exceptionhandler;
public class EmployerNotFoundException extends RuntimeException{
   private static final long serialVersionUID = 1L;
   public EmployerNotFoundException(Long employerId)
   {
       super("Employer id not found : " + employerId);
   }
   public EmployerNotFoundException(String employerName)
   {
       super("Employer name not found : " + employerName);
   }
}
