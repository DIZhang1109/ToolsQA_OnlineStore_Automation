package pageObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPageAfterLogin {
	@FindBy(xpath = ".//*[@id='meta']/ul/li[2]/a")
	public WebElement linkMetaLogOut;
	@FindBy(xpath = ".//*[@id='account_logout']/a")
	public WebElement linkLogOut;
	@FindBy(xpath = ".//*[@id='wp-admin-bar-my-account']/a")
	public WebElement linkHeaderWelcome;
}
