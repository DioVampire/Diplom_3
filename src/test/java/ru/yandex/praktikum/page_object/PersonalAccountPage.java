package ru.yandex.praktikum.page_object;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.enabled;

public class PersonalAccountPage {

    //Кнопка "История заказов"
    @FindBy(how = How.XPATH, using = ".//a[text()='История заказов']")
    private SelenideElement ordersHistoryButton;
    //Кнопка "Выход"
    @FindBy(how = How.XPATH, using = ".//button[text()='Выход']")
    private SelenideElement logOutButton;
    //Кнопка "Конструктор"
    @FindBy(how = How.XPATH, using = ".//p[contains(text(), \"Конструктор\")]")
    private SelenideElement constructorButton;
    //Логотип
    @FindBy(how = How.XPATH, using = ".//div[@class=\"AppHeader_header__logo__2D0X2\"]")
    private SelenideElement logoButton;

    //Клик на кнопку "Выход"
    @Step("Click log out button")
    public void clickLogOutButton() {
        logOutButton.shouldBe(enabled);
        logOutButton.click();
    }

    //Клик на кнопку "Конструктор"
    @Step("Click constructor button")
    public void clickConstructorButton() {
        constructorButton.click();
    }

    //Клик на логотип бургер
    @Step("Click logo button")
    public void clickLogoButton() {
        logoButton.click();
    }

    //Ожидание загрузки личного кабинета
    @Step("Wait for Personal Account page loaded")
    public void waitForPersonalAccount() {
        logOutButton.shouldBe(Condition.visible);
    }

    //Ожидание выхода из личного кабинета
    @Step("Wait after log out")
    public void waitAfterLogOut() {
        logOutButton.shouldBe(Condition.disappear);
    }

}
