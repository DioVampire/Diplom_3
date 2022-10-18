package ru.yandex.praktikum.page_object;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;

public class MainPage {

    // Кнопка входа в аккаунт
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти в аккаунт']")
    private SelenideElement loginButtonOnMainPage;

    // Кнопка "Оформить заказ"
    @FindBy(how = How.XPATH, using = "//button[text()=\"Оформить заказ\"]")
    private SelenideElement orderButton;

    // Кнопка "Личный кабинет"
    @FindBy(how = How.XPATH, using = ".//p[text()='Личный Кабинет']")
    private SelenideElement personalAccountButton;

    // Вкладка "Начинки"
    @FindBy(xpath = "//div[@class=\"tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect\"]/span[text()=\"Начинки\"]")
    private SelenideElement fillingsTab;

    // Кнопка "Начинки"
    @FindBy(xpath = "//span[@class=\"text text_type_main-default\" and text()=\"Начинки\"]")
    private SelenideElement fillingsButton;

    // Вкладка "Соусы"
    @FindBy(xpath = "//div[@class=\"tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect\"]/span[text()=\"Соусы\"]")
    private SelenideElement saucesTab;

    // Кнопка "Соусы"
    @FindBy(xpath = "//span[@class=\"text text_type_main-default\" and text()=\"Соусы\"]")
    private SelenideElement saucesButton;

    // Вкладка "Булки"
    @FindBy(xpath = "//div[@class=\"tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect\"]/span[text()=\"Булки\"]")
    private SelenideElement bunsTab;

    // Кнопка "Булки"
    @FindBy(xpath = "//span[@class=\"text text_type_main-default\" and text()=\"Булки\"]")
    private SelenideElement bunsButton;

    @Step("Click Fillings tab")
    public void clickFillingTab() {
        fillingsButton.shouldBe(exist);
        fillingsButton.click();
    }

    @Step("Click Sauces tab")
    public void clickSaucesTab() {
        saucesButton.shouldBe(exist).click();
    }

    @Step("Click Buns tab")
    public void clickBunsTab() {
        bunsButton.shouldBe(visible).click();
    }

    @Step("Log in on Main page")
    public void clickLoginButtonOnMainPage() {
        loginButtonOnMainPage.click();
    }

    @Step("Click Personal Account button")
    public void clickPersonalAccountButton() {
        personalAccountButton.click();
    }

    @Step("Check if Order button is displayed")
    public SelenideElement getOrderButton() {
        return orderButton;
    }

    public SelenideElement getFillingsTab() {
        return fillingsTab;
    }

    public SelenideElement getSaucesTab() {
        return saucesTab;
    }

    public SelenideElement getBunsTab() {
        return bunsTab;
    }
}
