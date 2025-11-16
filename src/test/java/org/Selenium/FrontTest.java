package org.Selenium;

import core.BaseSeleniumTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import page.FirstPage;

import java.awt.*;

public class FrontTest extends BaseSeleniumTest {
    public static WebDriver driver;

  @ParameterizedTest
  @ValueSource(strings = { "egorov@mail.ru", "egorov@mail", "egorov@" })
  public void openTextBox(String email) throws InterruptedException, AWTException {
      FirstPage firstPage = new FirstPage();
      firstPage.openElements().openTextBox().submitTextBox("Egorov", email, "London", "Paris");
  }

   @Test
   public void openAlert() throws InterruptedException, AWTException {
       FirstPage firstPage = new FirstPage();
       firstPage.openAlert().openFirstAlert();
   }



}









