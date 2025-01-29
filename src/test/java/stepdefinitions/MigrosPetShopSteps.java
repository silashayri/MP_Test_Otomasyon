package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import pages.PetShopPage;
import utils.Driver;

public class MigrosPetShopSteps {
    HomePage homePage = new HomePage();
    PetShopPage petShopPage = new PetShopPage();

    @Given("Kullanıcı Migros anasayfasını açar")
    public void kullaniciMigrosAnasayfasiniAcar() {
        Driver.getDriver().get("https://www.migros.com.tr/");
    }

    @When("Kategoriler menüsünden Pet Shop seçilir")
    public void kategorilerMenusundenPetShopSecilir() throws InterruptedException {
        homePage.navigateToPetShop();
    }

    @Then("Pet Shop sayfasının açıldığı doğrulanır")
    public void petShopSayfasininAcildigiDogrulanir() throws InterruptedException {
        Assert.assertTrue("Pet Shop sayfası açılmadı",
                petShopPage.isPetShopPageDisplayed());
    }

    @When("Ürünler düşük fiyata göre sıralanır")
    public void urunlerDusukFiyataGoreSiralanir() throws InterruptedException {
        petShopPage.sortByLowestPrice();
    }

    @Then("Ürünlerin düşük fiyata göre sıralandığı doğrulanır")
    public void urunlerinDusukFiyataGoreSiralandigiDogrulanir() {
        Assert.assertTrue("Ürünler fiyata göre sıralanmadı",
                petShopPage.isProductsSortedByPrice());
    }
} 