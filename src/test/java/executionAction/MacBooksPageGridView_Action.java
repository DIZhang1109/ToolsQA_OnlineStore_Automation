package executionAction;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

import pageObjectRepository.MacBooksPage;
import utility.PublicFunctions;

import config._Constants;

public class MacBooksPageGridView_Action extends LoadableComponent<MacBooksPageGridView_Action> {
	PublicFunctions pf = new PublicFunctions();
	MacBooksPage mbp = new MacBooksPage();
	public WebDriver driver;
	
	public MacBooksPageGridView_Action() {
		// TODO Auto-generated constructor stub
		driver = new FirefoxDriver();
		PageFactory.initElements(driver, mbp);
	}
	
	@Override
	protected void load() {
		// TODO Auto-generated method stub
		driver.navigate().to(_Constants.URLMacBooksPageGrid);
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
		pf.captureScreenShot(driver, "TC009_TS1_MacBooksPageGridView");
	}
	
	/**
	 * Assert the product's content in List View
	 * @throws Exception 
	 */
	public void assertProductContentsGridView(String sheetname) throws Exception {
		// Assert the number of products
		List<WebElement> products = driver.findElements(By.className("product_grid_item"));
		Assert.assertEquals(products.size(), 2);
		
		// Assert the product name of products
		List<String> expectedProdcutNames = null;
		List<String> actualProdcutNames = null;
		List<WebElement> productNames = null;
		pf.assertProdcutContents(sheetname, expectedProdcutNames, actualProdcutNames, 1, driver, productNames, "prodtitle");

		// Assert the product prices of products
		List<String> expectedProdcutPrices = null;
		List<String> actualProdcutPrices = null;
		List<WebElement> productPrices = null;
		pf.assertProdcutContents(sheetname, expectedProdcutPrices, actualProdcutPrices, 2, driver, productPrices, "currentprice");
	}
}
