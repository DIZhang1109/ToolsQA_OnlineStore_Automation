package pageObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccessoriesPage {
	@FindBy(xpath = ".//*[@id='post-105']/header/h1")
	public WebElement txtHeader;
	@FindBy(className = "pp_previous")
	public WebElement linkPrevious;
	@FindBy(className = "pp_next")
	public WebElement linkNext;
	@FindBy(className = "pp_close")
	public WebElement linkClose;
	@FindBy(className = "go_to_checkout")
	public WebElement btnGoToCheckout;
	@FindBy(className = "continue_shopping")
	public WebElement btnContinueShopping;
}
