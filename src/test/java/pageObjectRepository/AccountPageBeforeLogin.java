package pageObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPageBeforeLogin {
	@FindBy(id = "log")
	public WebElement Username;
	@FindBy(id = "pwd")
	public WebElement Password;
	@FindBy(id = "rememberme")
	public WebElement cbxRememberMe;
	@FindBy(id = "login")
	public WebElement btnLogin;
	@FindBy(xpath = ".//*[@id='ajax_loginform']/p[1]")
	public WebElement msgInvalidCredentials;
}
