package pageObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {
	@FindBy(id = "logo")
	public WebElement imgLogo;
	@FindBy(xpath = ".//*[@id='header_cart']/a")
	public WebElement spanCheckOut;
	@FindBy(xpath = ".//*[@id='account']/a")
	public WebElement spanMyAccount;
	@FindBy(xpath = ".//*[@id='menu-item-15']/a")
	public WebElement navbarHome;
	@FindBy(xpath = ".//*[@id='menu-item-33']/a")
	public WebElement navbarProductCategory;
	@FindBy(xpath = ".//*[@id='menu-item-34']/a")
	public WebElement navbarAccessoriesCategory;
	@FindBy(xpath = ".//*[@id='menu-item-35']/a")
	public WebElement navbariMacsCategory;
	@FindBy(xpath = ".//*[@id='menu-item-36']/a")
	public WebElement navbariPadsCategory;
	@FindBy(xpath = ".//*[@id='menu-item-37']/a")
	public WebElement navbariPhonesCategory;
	@FindBy(xpath = ".//*[@id='menu-item-38']/a")
	public WebElement navbariPodsCategory;
	@FindBy(xpath = ".//*[@id='menu-item-39']/a")
	public WebElement navbarMacBooksCategory;
	@FindBy(xpath = ".//*[@id='menu-item-72']/a")
	public WebElement navbarAllProduct;
	@FindBy(xpath = ".//*[@id='slide_menu']/a[1]")
	public WebElement slideshowItem1;
	@FindBy(xpath = ".//*[@id='slide_menu']/a[2]")
	public WebElement slideshowItem2;
	@FindBy(xpath = ".//*[@id='slide_menu']/a[3]")
	public WebElement slideshowItem3;
	@FindBy(xpath = ".//*[@id='slides']/div[1]/div[1]/h2")
	public WebElement slideshowTitle;
}
