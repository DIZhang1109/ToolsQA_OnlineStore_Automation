package utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class PublicFunctions {
	
	/**
	 * Navigate to specified URL
	 * @param driver
	 * @param URL
	 */
	public void navigateToURL(WebDriver driver, String URL) {
		driver.navigate().to(URL);
	}
	
	/**
	 * Capture the screen shot
	 * @param driver
	 * @param pageName
	 */
	public void captureScreenShot(WebDriver driver, String pageName) {
		try {
			File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile, new File("D:\\Documents\\workspace\\selenium\\ToolsQA_OnlineStore_Automation\\screenshot\\" + pageName + "-" + System.currentTimeMillis() + ".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Move the mouse to one specific element
	 * @param driver
	 * @param element
	 */
	public void mouseHoverToElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}
	
	/**
	 * Assert the product contents including product name, price and others
	 * @param sheetname
	 * @param expectedContents
	 * @param actualContents
	 * @param column
	 * @param driver
	 * @param contents
	 * @param className
	 * @throws Exception
	 */
	public void assertProdcutContents(String sheetname, List<String> expectedContents, List<String> actualContents, int column, WebDriver driver, List<WebElement> contents, String className) throws Exception {
		// Assert the product name of products
		ExcelUtils dd = new ExcelUtils(
				"D:\\Documents\\workspace\\selenium\\ToolsQA_OnlineStore_Automation\\src\\test\\java\\dataEngine\\DataEngine.xlsx",
				sheetname);
		expectedContents = new ArrayList<String>();
		actualContents = new ArrayList<String>();

		// Get expected product names from the excel
		for (int i = 1; i < dd.excel_get_rows(); i++) {
			expectedContents.add(dd.getCellDataasstring(i, column));
		}

		// Get actual product names from the web element
		contents = driver.findElements(By.className(className));
		for (WebElement content : contents) {
			actualContents.add(content.getText());
		}
		Assert.assertEquals(actualContents.toArray(), expectedContents.toArray());
	}
}
