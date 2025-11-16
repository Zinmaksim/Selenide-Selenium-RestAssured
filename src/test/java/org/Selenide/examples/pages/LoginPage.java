package org.Selenide.examples.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    private final SelenideElement login = $("[id=username]");

    private final SelenideElement password = $("[name=password]");

    private final SelenideElement loginButton = $("[id=login-button]");

    private void enter2ndFactor() {
        $(By.xpath("//input[@name=\"otpCode\"]")).shouldBe(visible);
        if ($("#login-otp-button").isDisplayed()) {
            $("#login-otp-button").click();
        } else {
            $(By.name("otpCode")).val("0000").pressEnter();
        }
    }

    public void auth() {
        open("https://idemo.bspb.ru/statement");
        password.shouldBe(visible, Duration.ofSeconds(20)).pressEnter();
        enter2ndFactor();

    }


}
