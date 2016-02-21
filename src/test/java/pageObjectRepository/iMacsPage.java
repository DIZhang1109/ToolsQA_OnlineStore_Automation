package pageObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class iMacsPage {
	@FindBy(xpath = ".//*[@id='post-40']/header/h1")
	public WebElement txtHeader;
	@FindBy(className = "pp_previous")
	public WebElement linkPrevious;
	@FindBy(className = "pp_next")
	public WebElement linkNext;
	@FindBy(className = "pp_close")
	public WebElement linkClose;
}
