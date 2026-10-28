package Test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Annotations {
	
@BeforeSuite
public void begoreSuite() {
	System.out.println("Executing before suite");
}


@Test (groups= {"Smoke"},dependsOnMethods= {"testMethod2"})
public void testMethod1()
{
	System.out.println("Executing method 1");
}
@Test (enabled=true)
public void testMethod2()
{
	System.out.println("Executing method 2");
}


}
