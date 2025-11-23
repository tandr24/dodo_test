import data.YumeData;
import org.junit.jupiter.api.Test;
import pages.AboutUsPage;
import pages.CartPage;
import pages.YumePage;

public class SushiTest extends TestBase {
    YumePage yumeSteps = new YumePage();
    YumeData yumeData = new YumeData();
    AboutUsPage aboutUsPage = new AboutUsPage();
    CartPage cartPage = new CartPage();

    @Test
    void addItemToCart() {
        yumeSteps.openSite("/")
                .chooseItem(yumeData.item);

        cartPage.goToCart()
                .checkCart(yumeData.item);
    }

    @Test
    void changeCityOnSite() {
        yumeSteps.openSite("/")
                .chooseCity(yumeData.city)
                .checkCity(yumeData.city);
    }

    @Test
    void deleteItemFromCart() {
        yumeSteps.openSite("/")
                .chooseItem(yumeData.item);
        cartPage.goToCart()
                .checkCart(yumeData.item)
                .deleteItemFromCart(yumeData.item)
                .checkCartIsEmpty();
    }

    @Test
    void clearCart() {
        yumeSteps.openSite("/")
                .chooseItem(yumeData.item);
        cartPage.goToCart()
                .removeAllItemFromCart()
                .checkCartIsEmpty();
    }

    @Test
    void checkIfContactInfoExistsAndCorrect() {
        yumeSteps.openSite("/");
        aboutUsPage.openTabAboutUs()
                .chooseCityInTabAboutUs(yumeData.city)
                .verifyContactInfo(yumeData.city);

    }

}
