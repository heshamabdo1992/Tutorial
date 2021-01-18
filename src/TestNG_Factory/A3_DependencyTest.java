package TestNG_Factory;

import org.testng.annotations.Test;

public class A3_DependencyTest {


	    private int param;
	 
	    public A3_DependencyTest(int param) {
	        this.param = param;
	    }
	 
	    @Test(dependsOnMethods = { "A3_testMethodTwo" })
	    public void A3_testMethodOne() {
	        System.out.println("A3_Test method one with param values: " + param);
	    }
	 
	    @Test
	    public void A3_testMethodTwo() {
	        System.out.println("A3_Test method two with param values: " + param);
	    }
	}


