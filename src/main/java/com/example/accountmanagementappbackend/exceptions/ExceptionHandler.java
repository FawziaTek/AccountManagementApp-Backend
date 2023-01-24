package com.example.accountmanagementappbackend.exceptions;
/**
 * @author Fawzia Tekaya in 24/01/2023
 * <p>
 * ExceptionHandler class
 ***/
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExceptionHandler {

	private Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

	public  void dataExceptions(Exception exceptioninput){
		String exception= exceptioninput.toString();
		logger.error(exception);
			
		String showerror = "Erreur  " ;
         if (exception.contains("InvalidInput")){			
			showerror = showerror + "Must be different from Null and empty";
			 logger.error(showerror);
			throw new InvalidInput();
		}else if(exception.contains("NoSuchElementException")){
			
			showerror = showerror + "No results could be found for the data entered";
			 logger.error(showerror);
			throw new NoSuchElementException();
		}else if(exception.contains("HttpMessageNotReadableException")){
			
			showerror = showerror + "Malformed JSON request";
			 logger.error(showerror);
			throw new HttpMsgNotReadableException();
		}
      
	}
	
	public void restExceptions(String exception, String method) {
		logger.error(exception);
		logger.info("restExceptions run in");
		String showerror = "Erreur Method " + method;
        if (exception.contains("NoSuchElementException")){
        	showerror = showerror + " : No results could be found for the data entered .";
			logger.error(showerror);
			throw new NoSuchElementException();
		}
		logger.info("restExceptions run out");
		
	}
	
}
