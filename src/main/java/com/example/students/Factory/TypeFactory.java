package com.example.students.Factory;

import org.springframework.stereotype.Component;

@Component
public class TypeFactory {
	
    
   public Type getShape(String type){
	   
      if(type == null){
         return null;
      }		
      if("assignment".equalsIgnoreCase(type)){
         return new Assignment();
      } else if("credit".equalsIgnoreCase(type)){
         return new Credit();
         
      } else if("exam".equalsIgnoreCase(type)){
         return new Exam();
      }
      
      return null;
   }
}
