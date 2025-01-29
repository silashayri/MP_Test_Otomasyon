package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import static utils.Driver.getDriver;

public class HomePage {
    @FindBy(xpath = "//span[contains(text(),'KATEGORİLER')]")
    private WebElement categoriesMenu;
    @FindBy(css = "href='https://www.migros.com.tr/pet-shop-c-a0'")
    private WebElement petShopLink;
    @FindBy(xpath = "//*[@class='title-close-btn-wrapper']/fa-icon")
    private WebElement homePageLocationPopUp;

    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void navigateToPetShop() throws InterruptedException {
        Thread.sleep(5000);
        if (homePageLocationPopUp.isDisplayed()) {
            homePageLocationPopUp.click();
        }
        categoriesMenu.click();
        Thread.sleep(2000);
        getDriver().get("https://www.migros.com.tr/pet-shop-c-a0");
    }
} 