package executionScript;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import executionAction.MainPage_Action;

public class TestCase003_MainPageElements {
	
	@Test
	public void testCase003_MainPageElements() throws InterruptedException {
		MainPage_Action mpa = new MainPage_Action();
		WebDriver driver = mpa.driver;
		mpa.get();
		System.out.println("TestCase003_MainPageElements:" + "\n" + "-----------------------------------------------------");
		
		mpa.assertMainPageNavBarElements();
		
		mpa.testSlideShowFunction();
		
		driver.close();
		System.out.println("-----------------------------------------------------" + "\n\n");
	}
}
