package org.Selenide.examples;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.google.common.io.Files;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;

public class BaseTestSelenide {
    @BeforeAll
    public static void setUp() {
        //closeWebDriver();
        WebDriverManager.chromedriver().setup();
        Configuration.browserSize = "1920*1080";
        Configuration.pageLoadTimeout = 100000;
        // Configuration.baseUrl = "https://idemo.bspb.ru";
        //Configuration.proxyEnabled = true;
        //Configuration.proxyHost = "0.0.0.0";
        //Configuration.fileDownload = PROXY;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    // @BeforeEach
    // public void login() {
    //     open("/");
    //    $(By.xpath("//input[@name=\"username\"]")).val("demo");
    //    $(By.xpath("//input[@name=\"password\"]")).val("demo").pressEnter();
    //     enter2ndFactor();
    // }

    @AfterEach
    public void tearDown() throws IOException {
        screenshot();
        // необязательно здесь
        clearBrowserCache();
    }

    @Attachment(type = "image/png")
    public byte[] screenshot() throws IOException {
        File screenshot = Screenshots.getLastScreenshot();
        return screenshot == null ? null : Files.toByteArray(screenshot);
    }

}
