package executionAction;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import pageObjectRepository.MacBooksPage;
import utility.PublicFunctions;

import config._Constants;

public class MacBooksPageListView_Action extends LoadableComponent<MacBooksPageListView_Action> {
	PublicFunctions pf = new PublicFunctions();
	MacBooksPage mbp = new MacBooksPage();
	public WebDriver driver;
	
	public MacBooksPageListView_Action() {
		// TODO Auto-generated constructor stub
		driver = new FirefoxDriver();
		PageFactory.initElements(driver, mbp);
	}
	
	@Override
	protected void load() {
		// TODO Auto-generated method stub
		driver.navigate().to(_Constants.URLMacBooksPageList);
		driver.manage().window().maximize();
	}
	
	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub
		Assert.assertTrue(driver.getTitle().equals(_Constants.MacBooksPage_Title));
	}

	/**
	 * Assert the accessories's page text
	 */
	public void assertPageText() {
		Assert.assertEquals(mbp.txtHeader.getText(), "MacBooks");
		pf.captureScreenShot(driver, "TC009_TS1_MacBooksPageListView");
	}
	
	/**
	 * Assert the product's content in List View
	 * @throws Exception 
	 */
	public void assertProductContentsListView(String sheetname) throws Exception {
		// Assert the number of products
		List<WebElement> products = driver.findElements(By.className("default_product_display"));
		Assert.assertEquals(products.size(), 2);
		
		// Assert the product name of products
		List<String> expectedProdcutNames = null;
		List<String> actualProdcutNames = null;
		List<WebElement> productNames = null;
		pf.assertProdcutContents(sheetname, expectedProdcutNames, actualProdcutNames, 1, driver, productNames, "wpsc_product_title");

		// Assert the product prices of products
		List<String> expectedProdcutPrices = null;
		List<String> actualProdcutPrices = null;
		List<WebElement> productPrices = null;
		pf.assertProdcutContents(sheetname, expectedProdcutPrices, actualProdcutPrices, 2, driver, productPrices,"currentprice");
	}
	
	/**
	 * View product image
	 * @throws InterruptedException 
	 */
	public void viewProductImage() throws InterruptedException {
		List<WebElement> productImages = driver.findElements(By.className("product_image"));
		for (WebElement productImage : productImages) {
			productImage.click();
			Thread.sleep(3000);
			
			// Conditional wait for the visible of one element
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(mbp.linkPrevious));
			
			mbp.linkPrevious.click();
			Thread.sleep(1000);
			mbp.linkNext.click();
			Thread.sleep(1000);
		
			mbp.linkClose.click();
			Thread.sleep(3000);
		}
	}
}
