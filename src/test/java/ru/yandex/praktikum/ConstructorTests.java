package ru.yandex.praktikum;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.page_object.MainPage;
import ru.yandex.praktikum.page_object.SwitchBrowser;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selenide.*;
import static ru.yandex.praktikum.page_object.BaseUrls.MAIN_PAGE_URL;


public class ConstructorTests {

    @Before
    public void setup() {
        closeWebDriver();
        Configuration.browser = browser;
        SwitchBrowser.setupBrowser();
        open(MAIN_PAGE_URL, MainPage.class);
    }

    @Test
    @DisplayName("Transition to Fillings section")
    @Description("The test is to check that a user can go to Fillings section")
    public void checkFillingTransitionTest() {
        MainPage mainPage = page(MainPage.class);
        mainPage.clickFillingTab();
        mainPage.getFillingsTab().shouldHave(exactText("Начинки"));
    }

    @Test
    @DisplayName("Transition to Sauces section")
    @Description("The test is to check that a user can go to Sauces section")
    public void checkSauceTransitionTest() {
        MainPage mainPage = page(MainPage.class);
        mainPage.clickSaucesTab();
        mainPage.getSaucesTab().shouldHave(exactText("Соусы"));
    }

    @Test
    @DisplayName("Transition to Buns section")
    @Description("The test is to check that a user can go to Buns section")
    public void checkBunTransitionTest() {
        MainPage mainPage = page(MainPage.class);
        mainPage.clickSaucesTab();
        mainPage.clickBunsTab();
        mainPage.getBunsTab().shouldHave(exactText("Булки"));
    }
}
