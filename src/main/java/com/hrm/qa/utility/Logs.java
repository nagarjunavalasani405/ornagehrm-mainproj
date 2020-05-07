package com.hrm.qa.utility;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Logs {
	
  static Logger log = LogManager.getLogger(Logs.class.getName());

	public static void main(String[] args) {
		
		System.out.println("hi hello this is log 4j logs");
		
		log .debug("My Debug Log");
		log.info("My Info Log");
		log.warn("My Warn Log");
		log.error("My error log");
		log.fatal("My fatal log");
		
		System.out.println("generating logs");
		
	}

}
