package TestNG_Factory;

import org.testng.annotations.Factory;

public class A3_DependencyTestFactory {
	
//	::To Run it:: Right click the package and do "Run as TestNG Test"
	
	    @Factory
	    public Object[] A3_factoryMethod()
	    {
	        return new Object[] { new A3_DependencyTest(1), new A3_DependencyTest(2) };
	    
	}
}
