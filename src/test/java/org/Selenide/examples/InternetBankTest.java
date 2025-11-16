package org.Selenide.examples;

import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.codeborne.xlstest.XLS;
import com.google.common.io.Files;
import io.qameta.allure.Attachment;
import io.qameta.allure.selenide.AllureSelenide;
import org.Selenide.examples.pages.LoginPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.FileDownloadMode.PROXY;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;
import static org.hamcrest.MatcherAssert.assertThat;

@Disabled
    class InternetBankTest extends BaseTestSelenide{
LoginPage loginPage = new LoginPage();

      //  @Test
      //  void userCanLoginToBspbDemo() {
      //      $(By.xpath("//input[@name=\"username\"]")).val("multicustomer");
      //  }

     //  @Test
     //  void userCanLoadStatementForLastMonth() {
     //      open("/bank/overview/");

     //      $("#accounts .account a").click();
     //      $(".page-header").shouldHave(text("Statement"));
     //      $("#defined-periods").find(byText("Beginning of last month until today")).click();
     //  }

    // рабочий
  @Test
     void userCanViewTransactionDetails() {
         openStatement();
         $(".statement-container .transaction-row.tx-debit .counterparty-name").scrollTo().click();
         $("#transaction-dialog #transaction-header").shouldHave(text("Детали операции"));
         $("#transaction-dialog #payment-beneficiary").shouldHave(text("Получатель"));
         $("#transaction-dialog #payment-beneficiary-account").shouldHave(
                 text("Счёт получателя"),
                 text("40702 810 5 0039 0000902")
         );
     }

     //      @Test
    //       @Disabled
     // void userCanDownloadStatementAsPdf() throws IOException {
     //     openStatement();
     //     $(".statement-container .transaction-row.tx-debit .counterparty-name").scrollTo().click();
     //     //$(By.xpath("//a[@id=\"btn-print-payment\"]")).click();
     //     //$("#statement-export").click();
     //     //File statementPdf = $("#btn-export-pdf").download();
     //     File statementPdf = $(By.xpath("//a[@id=\"btn-print-payment\"]")).download();
     //     PDF pdf = new PDF(statementPdf);
     //     assertThat(pdf, PDF.containsText("ПАО \"БАНК \"САНКТ-ПЕТЕРБУРГ2\""));
     //     assertThat(pdf, PDF.containsText("ПЛАТЕЖНОЕ ПОРУЧЕНИЕ № 121 16.05.2021 Дата"));
     //     assertThat(pdf, PDF.containsText("ОАО \"Коудборн\" Плательщик"));
     // }

     //@Test
     //@Disabled
     //void userCanDownloadStatementAsExcel() throws IOException {
     //    openStatement();
     //    $("#statement-export").click();
     //    File statementExcel = $("#btn-export-xls").download();
     //    XLS xls = new XLS(statementExcel);
     //    assertThat(xls, XLS.containsText("Королёва Ольга"));
     //    assertThat(xls, XLS.containsText("40817810048000102279"));
     //    assertThat(xls, XLS.containsText("Closing balance"));
     //    assertThat(xls, XLS.containsText("Credit turnover"));
     //    assertThat(xls, XLS.containsText("Debit turnover"));
     //    assertThat(xls, XLS.containsText("Reserved"));
     //}

      // @Test
      // void userCanAssignAliasForAccount() {
      //     open("/bank/overview");
      //     SelenideElement account = $("#accounts .account", 2).scrollTo();

      //     account.find("a.alias")
      //             .shouldHave(or("account or alias", text("50817 810 0 4800 0104467"), text("Это типа счёт"))
      //                     .because("the alias could already be changed by previous test run"))
      //             .hover();

      //     account.find(".icon-edit").should(appear).click();
      //     account.find(By.name("alias")).val("Это типа счёт").pressEnter();

      //     account.shouldHave(text("Это типа счёт"));

      //     account.shouldNotHave(text("50817 810 0 4800 0104467"));
      // }


        private void openStatement() {
            loginPage.auth();
            $("#defined-periods").find(byText("С начала прошлого месяца до сегодня")).click();
            $(By.xpath("//button[@id=\"query-button\"]")).click();
        }


    }

