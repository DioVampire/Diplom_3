package ru.yandex.praktikum;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.page_object.MainPage;
import ru.yandex.praktikum.page_object.RegistrationPage;
import ru.yandex.praktikum.page_object.SwitchBrowser;

import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static ru.yandex.praktikum.page_object.BaseUrls.LOGIN_PAGE_URL;
import static ru.yandex.praktikum.page_object.BaseUrls.REGISTER_PAGE_URL;


public class RegistrationTests {

    MainPage mainPage;

    @Before
    public void setup() {
        closeWebDriver();
        Configuration.browser = browser;
        SwitchBrowser.setupBrowser();
    }

    @Test
    @DisplayName("Registration with valid data")
    @Description("The test is to check that after successful registration, login page is available")
    public void registrationWithValidDataTest() {
        RegistrationPage registerPage= open(REGISTER_PAGE_URL, RegistrationPage.class);
        registerPage.registration(registerPage.NAME, registerPage.EMAIL, registerPage.PASSWORD);
        registerPage.waitAfterRegistration();
        //Проверяем, что после регистрации пользователя перевели на страницу логина
        assertEquals(url(), LOGIN_PAGE_URL);
    }

    @Test
    @DisplayName("Registration with short password")
    @Description("The test is to check that a password shorter than 6 symbols can't be used for registration")
    public void registrationWithIncorrectPasswordTest() {
        RegistrationPage registerPage = open(REGISTER_PAGE_URL, RegistrationPage.class);
        registerPage.registration(registerPage.NAME, registerPage.EMAIL, registerPage.SHORT_PASSWORD);
        //Проверяем, что после регистрации пользователя c коротким паролем, появилось сообщение о некорректном пароле
        assertTrue(registerPage.checkIncorrectPasswordMessage());
    }

}
