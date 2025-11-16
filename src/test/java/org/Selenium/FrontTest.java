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

 //   @Test
 //   public void openBusinessCard() throws InterruptedException {
 //       LoginPage loginPage = new LoginPage();
//
 //       String title = loginPage.auth("a61", "Hello123").openSmsCode().openMainPage().openBusinessCardsList().clickCard().openBusinessCard().getTitle();
 //       //Assert.assertEquals(String.format("Element not expected. It is '%s'", title), "МИР СУПРИМ БИЗНЕС ПРО", title);
 //       Assert.assertEquals(title, "МИР СУПРИМ БИЗНЕС ПРО2");
 //   }
//
//
 //   @Test
 //   public void showRequisites() throws InterruptedException {
 //       LoginPage loginPage = new LoginPage();
 //       String cvv = loginPage.auth("a61", "Hello123").openSmsCode().openMainPage().openBusinessCardsList().clickCard().openBusinessCard().clickRequisites().showCvv().inputCodeReq().chowOpenCvv();
 //       //Assert.assertEquals(String.format("Element not expected. It is '%s'", cvv), "703", cvv);
 //       Assert.assertEquals(cvv, "702");
 //   }
//
 //   @Test
 //   public void showExtract() throws InterruptedException {
 //       LoginPage loginPage = new LoginPage();
 //       String url = loginPage.auth("a61", "Hello123").openSmsCode().openMainPage().openBusinessCardsList().clickCard().openBusinessCard().clickExtract().orderExtract().print();
 //       System.out.println("*** ");
 //       Assert.assertTrue(url.contains("blob:https://pro.test.apps.tpaas.trosbank.trus.tsocgen/"));
//
 //   }
//
 //   @Test
 //   public void downloadExtract() throws InterruptedException {
 //       LoginPage loginPage = new LoginPage();
 //       loginPage.auth("a61", "Hello123").openSmsCode().openMainPage().openBusinessCardsList().clickCard().openBusinessCard().clickExtract().orderExtract().deleteExtract().download();
 //       System.out.println("*** ");
 //   }


}









