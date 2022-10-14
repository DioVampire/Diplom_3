package ru.yandex.praktikum.page_object;
import com.codeborne.selenide.Configuration;

public class SwitchBrowser {

    public static void setupBrowser() {
        //Для отработки метода, нужно поставить Configuration.browser = yandex в секции before теста
        if (System.getProperty("browser") == "yandex") {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\distr\\yandexdriver.exe");
        }
    }

}
