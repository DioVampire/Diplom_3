package ru.yandex.praktikum;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.page_object.LoginPage;
import ru.yandex.praktikum.page_object.MainPage;
import ru.yandex.praktikum.page_object.PersonalAccountPage;
import ru.yandex.praktikum.page_object.SwitchBrowser;

import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.Assert.assertEquals;
import static ru.yandex.praktikum.page_object.BaseUrls.*;


public class PersonalAccountTests {

    MainPage mainPage;

    @Before
    public void setup() {
        closeWebDriver();
        Configuration.browser = browser;
        SwitchBrowser.setupBrowser();
        MainPage main = open(MAIN_PAGE_URL, MainPage.class);
        main.clickPersonalAccountButton();
        LoginPage login = page(LoginPage.class);
        login.logIn(login.EMAIL, login.PASSWORD);
    }

    @After
    public void teardown() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }

    @Test
    @DisplayName("Go to Personal Account Page via Personal Account button")
    @Description("The test iss to check that a user can move to your personal account from Main page")
    public void fromMainPageToPersonalAccountTest() {
        MainPage main = page(MainPage.class);
        main.clickPersonalAccountButton();
        PersonalAccountPage personalPage = page(PersonalAccountPage.class);
        personalPage.waitForPersonalAccount();
        //Проверка, что страница персонального аккаунта открывается успешно
        assertEquals(url(), PERSONAL_ACCOUNT_PAGE_URL);
    }

    @Test
    @DisplayName("Go to Constructor section from personal account")
    @Description("The test is to check that a user can move to Constructor section from Personal account via Constructor button")
    public void fromPersonalAccountToConstructorTest() {
        MainPage main = page(MainPage.class);
        main.clickPersonalAccountButton();
        PersonalAccountPage personalPage = page(PersonalAccountPage.class);
        personalPage.waitForPersonalAccount();
        personalPage.clickConstructorButton();
        //Проверка, что секция конструктора открывается успешно
        assertEquals(url(), MAIN_PAGE_URL);
    }

    @Test
    @DisplayName("Go to Main Page from personal account")
    @Description("The test is to check that a user can move to Main page from Personal account via Logo button")
    public void fromPersonalAccountToMainPageViaLogoTest() {
        MainPage main = page(MainPage.class);
        main.clickPersonalAccountButton();
        PersonalAccountPage personalPage = page(PersonalAccountPage.class);
        personalPage.waitForPersonalAccount();
        personalPage.clickLogoButton();
        //Проверка, что переход на главную страницу произошел успешно
        assertEquals(url(), MAIN_PAGE_URL);
    }

    @Test
    @DisplayName("Log out from Personal account")
    @Description("The test is to check that a user can log out from Personal Account")
    public void logOutTest() {
        MainPage main = page(MainPage.class);
        main.clickPersonalAccountButton();
        PersonalAccountPage personalPage = page(PersonalAccountPage.class);
        personalPage.waitForPersonalAccount();
        personalPage.clickLogOutButton();
        personalPage.waitAfterLogOut();
        //Проверка, что после выхода из аккаунта доступна страница логина
        assertEquals(url(), LOGIN_PAGE_URL);
    }

}
