package executionAction;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

import config._Constants;

import pageObjectRepository.AccessoriesPage;
import pageObjectRepository.MacBooksPage;
import pageObjectRepository.iMacsPage;
import pageObjectRepository.iPadsPage;
import pageObjectRepository.iPhonesPage;
import pageObjectRepository.iPodsPage;
import utility.PublicFunctions;

public class AddToCart_Action extends LoadableComponent<AddToCart_Action> {
	PublicFunctions pf = new PublicFunctions();
	AccessoriesPage ap = new AccessoriesPage();
	iMacsPage imp = new iMacsPage();
	iPadsPage ipdp = new iPadsPage();
	iPhonesPage iphp = new iPhonesPage();
	iPodsPage ipop = new iPodsPage();
	MacBooksPage mbp = new MacBooksPage();
	public WebDriver driver;
	
	public AddToCart_Action() {
		// TODO Auto-generated constructor stub
		driver = new FirefoxDriver();
		PageFactory.initElements(driver, ap);
	}
	
	@Override
	protected void load() {
		// TODO Auto-generated method stub
		driver.navigate().to(_Constants.URLAccessoriesPageList);
		driver.manage().window().maximize();
	}
	
	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub
		Assert.assertTrue(driver.getTitle().equals(_Constants.AccessoriesPage_Title));
	}
	
	/**
	 * Randomly choose one item and click "Add to Cart"
	 * @throws InterruptedException 
	 */
	public void addtoCartOnce() throws InterruptedException {
		List<WebElement> btnAddtoCarts = driver.findElements(By.className("wpsc_buy_button"));

		// Select a random button and click it
		Random random = new Random();
		WebElement btnAddtoCart = btnAddtoCarts.get(random.nextInt(btnAddtoCarts.size()));
		btnAddtoCart.click();
		continueShopping();
		Assert.assertEquals(driver.findElement(By.className("count")).getText(), "1");
	}
	
	/**
	 * Randomly choose one item and click "Add to Cart"
	 * @throws InterruptedException 
	 */
	public void addtoCartSeveralTime(int times) throws InterruptedException {
		List<WebElement> btnAddtoCarts = driver.findElements(By.className("wpsc_buy_button"));

		for (int i = 0; i < times; i++) {
			// Select a random button and click it
			Random random = new Random();
			WebElement btnAddtoCart = btnAddtoCarts.get(random.nextInt(btnAddtoCarts.size()));
			btnAddtoCart.click();
			continueShopping();
		}
		Assert.assertEquals(driver.findElement(By.className("count")).getText(), Integer.toString(times));
	}
	
	/**
	 * Add all items into the shopping cart
	 * @throws InterruptedException
	 */
	public void addtoCartAll() throws InterruptedException {
		List<WebElement> btnAddtoCarts = driver.findElements(By.className("wpsc_buy_button"));

		// Add all products into the shopping cart
		for (WebElement btnAddtoCart : btnAddtoCarts) {
			btnAddtoCart.click();
			continueShopping();
		}
		Assert.assertEquals(driver.findElement(By.className("count")).getText(), Integer.toString(btnAddtoCarts.size()));
	}
	
	/**
	 * Click "Continue Shopping"
	 * @throws InterruptedException 
	 */
	public void continueShopping() throws InterruptedException {
		driver.switchTo().activeElement();
		Thread.sleep(3000);
		
		ap.btnContinueShopping.click();
		driver.switchTo().activeElement();
		Thread.sleep(3000);
	}
	
	/**
	 * Click "Go to Checkout"
	 * @throws InterruptedException 
	 */
	public void goToCheckout() throws InterruptedException {
		driver.switchTo().activeElement();
		Thread.sleep(3000);
		
		ap.btnGoToCheckout.click();
	}
	
	
}
