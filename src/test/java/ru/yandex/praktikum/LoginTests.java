package ru.yandex.praktikum;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.page_object.*;

import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.Assert.assertEquals;
import static ru.yandex.praktikum.page_object.BaseUrls.*;


public class LoginTests {

    MainPage mainPage;

    @Before
    public void setup() {
        closeWebDriver();
        Configuration.browser = browser;
        SwitchBrowser.setupBrowser();
    }

    @After
    public void teardown() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }

    @Test
    @DisplayName("Login on Main page")
    @Description("The test is to check that a user can login on Main Page")
    public void loginFromMainPageTest() {
        MainPage main = open(MAIN_PAGE_URL, MainPage.class);
        main.clickLoginButtonOnMainPage();
        LoginPage login = page(LoginPage.class);
        login.logIn(login.EMAIL, login.PASSWORD);
        login.waitAfterLogin();
        //Проверка, что авторизация успешно перевела на главную страницу
        assertEquals(url(), MAIN_PAGE_URL);
    }

    @Test
    @DisplayName("Login via Personal Account button")
    @Description("The test is to check that a user can login via Personal Account button")
    public void loginViaPersonalAccountButtonTest() {
        MainPage main = open(MAIN_PAGE_URL, MainPage.class);
        main.clickPersonalAccountButton();
        LoginPage login = page(LoginPage.class);
        login.logIn(login.EMAIL, login.PASSWORD);
        login.waitAfterLogin();
        //Проверка, что авторизация успешна через личный кабинет
        assertEquals(url(), MAIN_PAGE_URL);
    }

    @Test
    @DisplayName("Login on Registration page")
    @Description("The test is to check that a user can login on Registration page")
    public void loginOnRegistrationPageTest() {
        RegistrationPage register = open(REGISTER_PAGE_URL, RegistrationPage.class);
        register.clickLoginOnRegistrationButton();
        LoginPage login = page(LoginPage.class);
        login.logIn(login.EMAIL, login.PASSWORD);
        login.waitAfterLogin();
        //Проверка, что авторизация успешна через страницу регистрации
        assertEquals(url(), MAIN_PAGE_URL);
    }

    @Test
    @DisplayName("Login on Forgot Password page")
    @Description("The test is to check that a user can login on Forgot Your Password page")
    public void loginFromForgotPasswordPageTest() {
        ForgotPasswordPage forgotPasswordPage = open(FORGOT_PASSWORD_URL, ForgotPasswordPage.class);
        forgotPasswordPage.clickLoginButtonOnForgotPassword();
        LoginPage login = page(LoginPage.class);
        login.logIn(login.EMAIL, login.PASSWORD);
        login.waitAfterLogin();
        //Проверка, что авторизация успешна через страницу восстановления пароля
        assertEquals(url(), MAIN_PAGE_URL);
    }

}
