package executionAction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

import config._Constants;

import pageObjectRepository.MainPage;
import utility.PublicFunctions;

public class MainPage_Action extends LoadableComponent<MainPage_Action> {
	PublicFunctions pf = new PublicFunctions();
	MainPage mp = new MainPage();
	public WebDriver driver;
	
	public MainPage_Action() {
		// TODO Auto-generated constructor stub
		driver = new FirefoxDriver();
		PageFactory.initElements(driver, mp);
	}
	
	@Override
	protected void load() {
		// TODO Auto-generated method stub
		driver.navigate().to(_Constants.URLMainPage);
		driver.manage().window().maximize();
	}
	
	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub
		Assert.assertTrue(driver.getTitle().equals(_Constants.MainPage_Title));
	}
	
	/**
	 * Assert the main page elements' link address 
	 */
	public void assertMainPageNavBarElements() {
		Assert.assertEquals(mp.navbarHome.getAttribute("href"), "http://store.demoqa.com/");
		Assert.assertEquals(mp.navbarProductCategory.getAttribute("href"), "http://store.demoqa.com/products-page/product-category/");
		Assert.assertEquals(mp.navbarAccessoriesCategory.getAttribute("href"), "http://store.demoqa.com/products-page/product-category/accessories/");
		Assert.assertEquals(mp.navbariMacsCategory.getAttribute("href"), "http://store.demoqa.com/products-page/product-category/imacs/");
		Assert.assertEquals(mp.navbariPadsCategory.getAttribute("href"), "http://store.demoqa.com/products-page/product-category/ipads/");
		Assert.assertEquals(mp.navbariPhonesCategory.getAttribute("href"), "http://store.demoqa.com/products-page/product-category/iphones/");
		Assert.assertEquals(mp.navbariPodsCategory.getAttribute("href"), "http://store.demoqa.com/products-page/product-category/ipods/");
		Assert.assertEquals(mp.navbarMacBooksCategory.getAttribute("href"), "http://store.demoqa.com/products-page/product-category/macbooks/");
		Assert.assertEquals(mp.navbarAllProduct.getAttribute("href"), "http://store.demoqa.com/products-page/product-category/");
		
		pf.mouseHoverToElement(driver, mp.navbarProductCategory);
		Assert.assertEquals(mp.navbarHome.getText(), "Home");
		Assert.assertEquals(mp.navbarProductCategory.getText(), "Product Category");
		Assert.assertEquals(mp.navbarAccessoriesCategory.getText(), "Accessories");
		Assert.assertEquals(mp.navbariMacsCategory.getText(), "iMacs");
		Assert.assertEquals(mp.navbariPadsCategory.getText(), "iPads");
		Assert.assertEquals(mp.navbariPhonesCategory.getText(), "iPhones");
		Assert.assertEquals(mp.navbariPodsCategory.getText(), "iPods");
		Assert.assertEquals(mp.navbarMacBooksCategory.getText(), "MacBooks");
		Assert.assertEquals(mp.navbarAllProduct.getText(), "All Product");
		pf.captureScreenShot(driver, "TC003_TS1_MainPage");
	}
	
	/**
	 * Test the function of slide show
	 * @throws InterruptedException 
	 */
	public void testSlideShowFunction() throws InterruptedException {
		mp.slideshowItem1.click();
		Thread.sleep(1500);
		Assert.assertEquals(mp.slideshowTitle.getText(), _Constants.Slideshow_Title1);
		
		mp.slideshowItem2.click();
		Thread.sleep(1500);
		Assert.assertEquals(mp.slideshowTitle.getText(), _Constants.Slideshow_Title2);
		
		mp.slideshowItem3.click();
		Thread.sleep(1500);
		Assert.assertEquals(mp.slideshowTitle.getText(), _Constants.Slideshow_Title3);
	}
}
