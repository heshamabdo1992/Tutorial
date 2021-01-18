package TestNG_Factory;

import org.testng.annotations.Test;

public class A1_SimpleTest
{
    private int param;
 
    public A1_SimpleTest(int param) {
        this.param = param;
    }
 
    @Test
    public void A1_testMethodOne() {
        int opValue = param + 1;
        System.out.println("A1_Test method one output: " + opValue);
    }
 
    @Test
    public void A1_testMethodTwo() {
        int opValue = param + 2;
        System.out.println("A1_Test method two output: " + opValue);
    }
}