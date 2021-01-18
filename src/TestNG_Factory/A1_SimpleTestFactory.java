package TestNG_Factory;


import org.testng.annotations.Factory;

public class A1_SimpleTestFactory {
	
//	::To Run it:: Right click the package and do "Run as TestNG Test"
	
	@Factory
	public Object[] A1_factoryMethod() {
		return new Object[] { new A1_SimpleTest(0), new A1_SimpleTest(1) };
	}
	
// Reference: https://howtodoinjava.com/testng/testng-factory-annotation-tutorial/#using_with_dataprovider
//=========================================================================================================	
/*Let’s learn about the @Factory annotation provided by TestNG. 
 * @Factory allows tests to be created at runtime depending on certain data-sets or conditions.

Sometimes we may need to run a set of tests with different data values. 
To achieve this we may define a separate set of tests inside a suite in the testng XML and test the required scenario. 
The problem with this approach is that, if you get an extra set of data, you will need to redefine the test. 

TestNG solves this problem by providing the @Factory annotation feature. Factory in TestNG defines and creates tests dynamically at runtime.
 *
 * 
 * Different between @Factor and @data provider
 * =============================================
 * https://howtodoinjava.com/testng/testng-difference-between-factory-and-dataprovider/
 *
 *@data Provider
 *===============
 * As you can see in previous link example,
 * the (data Provider sample) test results the class (beforeClass) is executed only ONE TIME irrespective of how many times the test method is executed.
 *
 *
 * But @Factory:
 * =============
 * The (beforeClass) method is executed BEFORE EACH execution of testMethod.
 * This shows that factory implementation executes the test method for each individual instance of the test class.
 * 
 * As we saw earlier DataProvider executes the test method (testMethod) for a single instance of the test class. 
 * 
 * */
}