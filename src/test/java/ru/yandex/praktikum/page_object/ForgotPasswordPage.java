package ru.yandex.praktikum.page_object;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ForgotPasswordPage {

    //Кнопка "Войти" на странице восстановления пароля
    @FindBy(how = How.XPATH, using = ".//a[text()='Войти']")
    private SelenideElement loginButton;

    //Клик кнопку "Войти"
    @Step("Click login button on Forgot Password Page")
    public void clickLoginButtonOnForgotPassword() {
        loginButton.scrollTo().click();
    }

}
