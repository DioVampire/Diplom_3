package ru.yandex.praktikum.page_object;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;

public class LoginPage {

    //Зарегистрированный пользователь
    public final String EMAIL = "Crimea_bridge@example.com";
    public final String PASSWORD = "Adema1";

    //Поле ввода почты
    @FindBy(how = How.XPATH, using = ".//input[@name='name']")
    public SelenideElement emailField;
    //Поле ввода пароля
    @FindBy(how = How.XPATH, using = ".//input[@name='Пароль']")
    public SelenideElement passwordField;
    //Кнопка "Войти"
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти']")
    private SelenideElement loginButton;

    //Ввод почты
    @Step("Set email")
    public void setEmail(String email) {
        emailField.shouldBe(visible);
        emailField.setValue(email);
    }

    //Ввод пароля
    @Step("Set password")
    public void setPassword(String password) {
        passwordField.shouldBe(visible);
        passwordField.setValue(password);
    }

    //Клик на кнопку входа
    @Step("Click login button")
    public void clickLoginButton() {
        loginButton.click();
    }

    //Метод логина
    @Step("Login")
    public void logIn(String email, String password) {
        setEmail(email);
        setPassword(password);
        clickLoginButton();
    }

    //Ожидание перехода после логина
    @Step("Wait for successful login")
    public void waitAfterLogin() {
        loginButton.shouldBe(Condition.hidden);
    }

}
