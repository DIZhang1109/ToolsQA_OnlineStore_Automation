package executionAction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

import config._Constants;

import pageObjectRepository.AccountPageAfterLogin;
import pageObjectRepository.AccountPageBeforeLogin;
import pageObjectRepository.MainPage;
import utility.ExcelUtils;
import utility.PublicFunctions;

public class Login_Action extends LoadableComponent<Login_Action> {
	PublicFunctions pf = new PublicFunctions();
	MainPage mp = new MainPage();
	AccountPageBeforeLogin apbl = new AccountPageBeforeLogin();
	AccountPageAfterLogin apal = new AccountPageAfterLogin();
	public WebDriver driver;
	
	public Login_Action() {
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
	 * Assert the main page's link address 
	 */
	public void assertMainPageURL() {
		Assert.assertEquals(mp.spanCheckOut.getAttribute("href"), "http://store.demoqa.com/products-page/checkout/");
		Assert.assertEquals(mp.spanMyAccount.getAttribute("href"), "http://store.demoqa.com/products-page/your-account/");
		pf.captureScreenShot(driver, "TC001_TS1_MainPage");
	}
	
	/**
	 * Input username and password, then click login button
	 * @throws Exception 
	 */
	public void testLogin(String sheetname) throws Exception {
		mp.spanMyAccount.click();
		PageFactory.initElements(driver, apbl);

		ExcelUtils dd = new ExcelUtils(
				"D:\\Documents\\workspace\\selenium\\ToolsQA_OnlineStore_Automation\\src\\test\\java\\dataEngine\\DataEngine.xlsx",
				sheetname);
		for (int i = 1; i < dd.excel_get_rows(); i++) {
			apbl.Username.clear();
			apbl.Username.sendKeys(dd.getCellDataasstring(i, 1));
			apbl.Password.clear();
			apbl.Password.sendKeys(dd.getCellDataasstring(i, 2));
			pf.captureScreenShot(driver, i + "TC001_TS2_AccountPage");
			apbl.btnLogin.click();
			
			if (sheetname.equals("001_LoginCorrectly")) {
				assertLoginStatusSuccessfully(dd.getCellDataasstring(i, 1));
			} else {
				assertLoginStatusUnsuccessfully();
			}
		}
	}
	
	/**
	 * Assert if user login successfully
	 * @throws InterruptedException 
	 */
	public void assertLoginStatusSuccessfully(String username) throws InterruptedException {
		PageFactory.initElements(driver, apal);
		Thread.sleep(2500);
		
		apal.linkMetaLogOut.isDisplayed();
		apal.linkLogOut.isDisplayed();
		pf.captureScreenShot(driver, "TC001_TS3_AccountPageLoginSuccessfully");
		Assert.assertEquals(apal.linkHeaderWelcome.getText().substring(7), username);
		apal.linkMetaLogOut.click();
		Thread.sleep(2500);
		
		if (!driver.getTitle().equals(_Constants.AccountPage_Title)) {
			driver.navigate().to(_Constants.URLAccountPage);
		}
	}
	
	/**
	 * Assert if user login unsuccessfully
	 * @throws InterruptedException 
	 */
	public void assertLoginStatusUnsuccessfully() throws InterruptedException {
		PageFactory.initElements(driver, apbl);
		Thread.sleep(2500);

		Assert.assertTrue(apbl.msgInvalidCredentials.isDisplayed());
	}
}
