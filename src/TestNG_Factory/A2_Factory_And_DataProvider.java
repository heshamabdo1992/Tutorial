package TestNG_Factory;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class A2_Factory_And_DataProvider {

	    private int param;
	 
	    @Factory(dataProvider = "dataMethod")				//2- Constructor get data from DataProvider
	    public A2_Factory_And_DataProvider(int param) {
	        this.param = param;
	    
	    }
	 
	    @DataProvider										//1- DataProvider contain data array
	    public static Object[][] dataMethod() {
	        return new Object[][] { { 0 }, { 1 } };
	    }
	 
	    @Test
	    public void A2_testMethodOne() {					//3- Method get data from constructor
	    	int opValue = param + 1;
	        System.out.println("A2_Test method one output: " + opValue);
	    }
	 
	    @Test
	    public void A2_testMethodTwo() {					//3- Method get data from constructor
	        int opValue = param + 2;
	        System.out.println("A2_Test method two output: " + opValue);

	    }
	  
	}

