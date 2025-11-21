import data.YumeData;
import org.junit.jupiter.api.Test;
import pages.YumeSteps;

public class SushiTest extends TestBase {
    YumeSteps yumeSteps = new YumeSteps();
    YumeData yumeData = new YumeData();

    @Test
    void addItemToCart() {
        yumeSteps.openSite("/")
                .chooseItem(yumeData.item)
                .goToCart()
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
                .chooseItem(yumeData.item)
                .goToCart()
                .checkCart(yumeData.item)
                .deleteItemFromCart(yumeData.item)
                .checkCartIsEmpty();
    }

    @Test
    void clearCart() {
        yumeSteps.openSite("/")
                .chooseItem(yumeData.item)
                .goToCart()
                .removeAllItemFromCart()
                .checkCartIsEmpty();
    }

    @Test
    void checkIfContactInfoExistsAndCorrect() {
        yumeSteps.openSite("/")
                .openTabAboutUs()
                .chooseCityInTabAboutUs(yumeData.city)
                .verifyContactInfo(yumeData.city);

    }

}
