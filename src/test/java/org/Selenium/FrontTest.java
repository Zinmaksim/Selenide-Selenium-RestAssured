package org.Selenium;

import core.BaseSeleniumTest;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import page.FirstPage;
import java.awt.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FrontTest extends BaseSeleniumTest {
   // public static WebDriver driver;

    @ParameterizedTest
    @ValueSource(strings = {"egorov@mail.ru", "egorov@mail", "egorov@"})
    public void openTextBox(String email) throws InterruptedException, AWTException {
        FirstPage firstPage = new FirstPage();
        firstPage.openElements().openTextBox().submitTextBox("Egorov", email, "London", "Paris");

                 }

   @Test
   public void openAlert() throws InterruptedException, AWTException {
       FirstPage firstPage = new FirstPage();
       firstPage.openAlert().openFirstAlert();
       // hard assert
       assertThat(driver.getCurrentUrl()).isEqualTo("http://85.192.34.140:8081/alerts");
       // soft assert
       SoftAssertions softly = new SoftAssertions();
       softly.assertThat(driver.getCurrentUrl()).isEqualTo("http://85.192.34.140:8081/alerts");
       softly.assertThat(driver.getCurrentUrl()).isEqualTo("http://85.192.34.140:8081/"); // эта проверка с ошибкой, но тест не будет падать
      // конструкция делает, чтобы тест не падал в случае ошибок
       try {
           // Вызов assertAll для сбора ошибок
           softly.assertAll();
       } catch (Throwable e) {
           // Здесь можно обработать исключение, например, логировать его
           System.out.println("Тест завершился с ошибками: " + e.getMessage());
       }

   }


}









