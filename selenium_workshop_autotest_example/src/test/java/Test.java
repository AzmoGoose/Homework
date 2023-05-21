import com.codeborne.selenide.Condition;
import com.codeborne.selenide.*;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class Test {

    @org.junit.Test
    public void logoTest() {
        open("https://pethouse.ua/ua/about/oplata-i-dostavka/");
        $("#tpl-logo").click();
        assert WebDriverRunner.url().equals("https://pethouse.ua/ua/");
        screenshot("logo is working");
    }

    @org.junit.Test
    public void searchIsWorking() {
        open("https://pethouse.ua/ua/");
        $("#search").click();
        $("#search").setValue("їжа для собак").pressEnter();
        $("#tpl-search-results > main > div > div.tpl-page-header > h1").shouldHave(Condition.text("Результати пошуку"));
        $("#tpl-search-results > main > div > div.tpl-page-header > h1").shouldBe(visible);
    }

    @org.junit.Test
    public void ruLanguageSwitching() {
        open("https://pethouse.ua/ua/");
        $("#header-main > section.header-top-top-top > div > div > div.header-left > span > a").click();
        $("#tpl-index > main > div > section:nth-child(1) > div > h2").shouldHave(Condition.text("Акции и скидки"));
        $("#header-main > section.header-top-top > div > div.z2-header-middle > div.header-right > ul:nth-child(2) > li").click();
        $("#tpl-index > div.vex.vex-theme-default.contacts-mdl > div").shouldBe(visible);
        $("#tpl-index > div.vex.vex-theme-default.contacts-mdl > div > form > div.vex-dialog-message > div > div.cw-help-bottom > div.z2-main-contacts-drop-callback-wrapper > div").shouldHave(Condition.text("Перезвоните мне"));
        screenshot("ruLanguageTest");
    }

    @org.junit.Test
    public void uaLanguageSwitching() {
        open("https://pethouse.ua/ru/");
        $("#header-main > section.header-top-top-top > div > div > div.header-left > span > a").click();
        $("#tpl-index > main > div > section:nth-child(1) > div > h2").shouldHave(Condition.text("Акції та знижки"));
        $("#header-main > section.header-top-top > div > div.z2-header-middle > div.header-right > ul:nth-child(1) > li").click();
        $("#tpl-index > div.vex.vex-theme-default.login-mdl > div").shouldBe(visible);
        $("#tpl-index > div.vex.vex-theme-default.login-mdl > div").shouldHave(Condition.text("Продовжити"));
        screenshot("uaLanguageTest");
    }

    @org.junit.Test
    public void searchNonExisting() {
        open("https://pethouse.ua/ua/");
        $("#search").click();
        $("#search").setValue("asdgf12323").pressEnter();
        $("#tpl-search-results > main > div > div.tpl-page-header > h1").shouldHave(Condition.text("Результати пошуку"));
        $("#tpl-for-resolution > div.search-title").shouldHave(Condition.text("знайдено 0 результатів"));
        screenshot("searchNonExisting");
    }

    @org.junit.Test
    public void favoriteWhenNotLoggedIn() {
        open("https://pethouse.ua/ua/");
        $("#header-main > section.header-top-top-top > div > div > div.header-right > div > a.fav-big").click();
        $("#tpl-index > div.vex.vex-theme-default.fav-unlogin-mdl > div").shouldBe(visible);
        $("#tpl-index > div.vex.vex-theme-default.fav-unlogin-mdl > div > form > div.vex-dialog-message").shouldHave(Condition.text("Щоб додавати товари до переліку улюблених"));
        $("#tpl-index > div.vex.vex-theme-default.fav-unlogin-mdl > div > form > div.vex-dialog-message").shouldHave(Condition.text("увійдіть в особистий кабінет"));
        screenshot("favoriteWhenNotLoggedIn");
    }

    @org.junit.Test
    public void compareWhenNoProductsAdded() {
        open("https://pethouse.ua/ua/");
        $("#header-main > section.header-top-top-top > div > div > div.header-right > div > a.compare-big").click();
        $("#tpl-comparison > main > div > div.z2-page-content > div").shouldHave(Condition.text("Нема жодного товару для порівняння :("));
        screenshot("comparePage");
    }


//Can't be done in Anonymous mode, user should have added at least 1 product;
    //@org.junit.Test
    //public void basketDeleteProduct() {
    //open("https://pethouse.ua/ua/basket/");
    //$("#basket-row-wrapper > div > div.z2-basket-row.tpl > div.z2-zero-first-wrapper > div.z2-basket-row-del > a").click();
    //$("#tpl-basket > main > div > div.z2-page-content > div.ph-big-cat-pagewrapper > div.ph-big-cat-text-block").shouldHave(Condition.text("Порожньо!"));
    //$("#tpl-basket > main > div > div.z2-page-content > div.ph-big-cat-pagewrapper > div.ph-big-cat-text-block").shouldHave(Condition.text("У вашому кошику нічого немає"));
    // screenshot("basketDeleteProduct");


    @org.junit.Test
    public void videoWrapperVisibility() {
        open("https://pethouse.ua/ua/");
        $("#tpl-index > main > div > section.zoog-top-videos > ul > li:nth-child(1) > div > div.zog-top-video-item").click();
        $("#tpl-index > div.vex.vex-theme-default.video-mdl > div").shouldBe(visible);
        $("#tpl-index > div.vex.vex-theme-default.video-mdl > div").shouldHave(Condition.text("Які овочі можна котам і собакам?"));
        screenshot("videoWrapperVisibility");
    }

    @org.junit.Test
    public void searchAndAddProductQuantity() {
        open("https://pethouse.ua/ua/");
        $("#search").click();
        $("#search").setValue("їжа для котів").pressEnter();
        $("#tpl-for-resolution > div.bd-search-results > div > div.results > div > section.results-products > div:nth-child(2) > div > div.ph-the-new-tovar-price > div > div > div.ph-new-catalog-price-block-buy > a").click();
        $("#tpl-for-resolution > div.bd-search-results > div > div.results > div > section.results-products > div:nth-child(2) > div > div.ph-the-new-tovar-price > div > div > div.ph-new-catalog-price-block-buy > div").shouldBe(visible);
        $("#header-main > section.header-top-top > div > div.z2-header-middle > div.header-right > div.header-cart > a > span.quantity.large-int").shouldHave(text("1"));
        screenshot("searchAndAddProductQuantity");
    }

    @org.junit.Test
    public void profileLogInOption() {
        open("https://pethouse.ua/ua/");
        $("#header-main > section.header-top-top > div > div.z2-header-middle > div.header-right > ul:nth-child(1) > li").click();
        $("#tpl-index > div.vex.vex-theme-default.login-mdl > div").shouldBe(visible);
        $("#tpl-index > div.vex.vex-theme-default.login-mdl > div").shouldHave(text("Увійти по email та паролю"));
        screenshot("profileLogInOption");
    }

    @org.junit.Test
    public void brandSearch() {
        open("https://pethouse.ua/ua/");
        $("#tpl-index > main > div > section.zoog-top-brands > ul > li:nth-child(1) > div").click();
        $("#tpl-royalcanin > main > div > div.results-header__title > h1").shouldHave(text("Royal Canin (Роял Канін)"));
        screenshot("brandSearch");


    }

}