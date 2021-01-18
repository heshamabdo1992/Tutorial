package TestNG_Factory;

import org.testng.annotations.Factory;


 
public class SimpleTestFactory
{
    @Factory
    public Object[] factoryMethod() {
        return new Object[] { new SimpleTest(0), new SimpleTest(1) };
    }
}