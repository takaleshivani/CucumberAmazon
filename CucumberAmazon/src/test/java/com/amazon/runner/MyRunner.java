package com.amazon.runner;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"src/test/resources/"},
		glue= {"com.amazon.stepdefinition","com.amazon.hooks"},
		
		monochrome=true
		
		)
public class MyRunner{
	
}  
