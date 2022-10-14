package ru.yandex.praktikum.page_object;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegistrationPage {

    public static Faker faker = new Faker();

    //Переменные для регистрации пользователя
    public final String NAME = faker.name().username();
    public final String EMAIL = faker.internet().emailAddress();
    public final String PASSWORD = "Adema2";
    public final String SHORT_PASSWORD = "Adema";

    //Кнопка "Зарегистрироваться"
    @FindBy(how = How.XPATH, using = ".//button[text()='Зарегистрироваться']")
    private SelenideElement registrationButton;
    //Поля Имя (индекс 0), Email (индекс 1), пароль (индекс 2)
    @FindBy(how = How.XPATH, using = ".//input[@class='text input__textfield text_type_main-default']")
    public ElementsCollection nameEmailPasswordFields;
    //Кнопка входа
    @FindBy(how = How.XPATH, using = ".//a[text()='Войти']")
    private SelenideElement loginButtonOnRegistration;
    //Сообщение о некорректном пароле
    @FindBy(how = How.XPATH, using = ".//p[text()='Некорректный пароль']")
    private SelenideElement incorrectPasswordMessage;

    //Ввод имени на странице регистрации
    @Step("Set name on registration")
    public void setNameOnRegisterPage(String name) {
        nameEmailPasswordFields.get(0).shouldBe(Condition.visible);
        nameEmailPasswordFields.get(0).setValue(name);
    }

    //Ввод почты на странице регистрации
    @Step("Set email on registration")
    public void setEmailOnRegisterPage(String email) {
        nameEmailPasswordFields.get(1).shouldBe(Condition.visible);
        nameEmailPasswordFields.get(1).setValue(email);
    }

    //Ввод пароля на странице регистрации
    @Step("Set password on registration")
    public void setPasswordOnRegisterPage(String password) {
        nameEmailPasswordFields.get(2).shouldBe(Condition.visible);
        nameEmailPasswordFields.get(2).setValue(password);
    }

    //Нажатие на кнопку регистрации
    @Step("Click registration button")
    public void clickRegistrationButton() {
        registrationButton.click();
    }

    //Регистрация
    @Step("Registration method")
    public void registration(String name, String email, String password) {
        setNameOnRegisterPage(name);
        setEmailOnRegisterPage(email);
        setPasswordOnRegisterPage(password);
        clickRegistrationButton();
    }

    //Проверка, что сообщение о некорректном пароле появилось
    @Step("Check incorrect password message")
    public boolean checkIncorrectPasswordMessage() {
        return incorrectPasswordMessage.isDisplayed();
    }

    //Ожидание, пока страница регистрации не исчезнет
    @Step("Wait after registration")
    public void waitAfterRegistration() {
        registrationButton.shouldBe(Condition.hidden);
    }

    //Нажатие на кнопку "Войти" после регистрации
    @Step("Click the entry button")
    public void clickLoginOnRegistrationButton() {
        loginButtonOnRegistration.scrollTo().click();
    }

}

