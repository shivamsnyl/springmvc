package com.aspect;

import org.slf4j.LoggerFactory;

public class AspectService {
	
	
	private final org.slf4j.Logger logger = LoggerFactory.getLogger(AspectService.class);
	
	public void myadvice()
    {  
        logger.info("Advice Given........."); 
        System.out.println("Advice Given.........");
    }  

}
