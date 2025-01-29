package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

import java.util.List;
import java.time.Duration;
import java.util.ArrayList;

public class PetShopPage {
    @FindBy(xpath = "//h2[@id='product-filter-desktop-title']")
    private WebElement petShopHeader;

    @FindBy(xpath = "(//div[@class='chip-sort-row desktop-only']/fe-dropdown/mat-form-field/div)[1]")
    private WebElement sortDropdown;

    @FindBy(xpath = "(//div[@id='mat-select-0-panel']/div/mat-option)[5]")
    private WebElement sortLowPriceFirst;

    @FindBy(xpath = "//div[@class='price-tag']//span[@class='amount']")
    private List<WebElement> productPrices;

    public PetShopPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public boolean isPetShopPageDisplayed() throws InterruptedException {
        Thread.sleep(3000);
        return petShopHeader.getText().contains("Pet Shop");
    }

    public void sortByLowestPrice() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(sortDropdown));
        sortDropdown.click();
        sortLowPriceFirst.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isProductsSortedByPrice() {
        List<Double> prices = new ArrayList<>();
        for (WebElement priceElement : productPrices) {
            String priceText = priceElement.getText().replace("TL", "").replace(",", ".").trim();
            try {
                double price = Double.parseDouble(priceText);
                prices.add(price);
            } catch (NumberFormatException e) {
                System.out.println("Fiyat dönüştürme hatası: " + priceText);
            }
        }

        for (int i = 0; i < prices.size() - 1; i++) {
            if (prices.get(i) > prices.get(i + 1)) {
                System.out.println("Sıralama hatası: " + prices.get(i) + " > " + prices.get(i + 1));
                return false;
            }
        }

        return true;
    }
} 