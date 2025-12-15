package org.Selenide.examples;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.junit5.TextReportExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

@ExtendWith(TextReportExtension.class)
class SelenideUsersTest extends BaseTestSelenide {

    @Test
    void showsAllUsersCategories() {
        open("https://selenide.org/users.html");
        $$("#user-tags .tag").
                first(5)
                .shouldHave(texts("usa", "europe", "asia", "estonia", "ukraine"));
    }

    @ParameterizedTest(name = "#{index}. Let's search [{argumentsWithNames}]")
    @ValueSource(strings = {"usa", "ukraine", "europe", "estonia"})
    void userCanSearchAnyKeyword(String tag) throws InterruptedException {
        Configuration.timeout = TimeUnit.SECONDS.toMillis(60000);
        open("https://selenide.org");
        $(".main-menu-pages").find(byText("Users")).click();
        ElementsCollection users = $$("#selenide-users .user:not(.hidden)");
        users.shouldHave(size(1));
        $("#user-tags .reset-filter").shouldHave(text("all")).click();
        users.shouldHave(sizeGreaterThan(165));

        $$("#user-tags .tag")
                .shouldHave(sizeGreaterThan(7))
                .findBy(text(tag))
                .click();

        users.shouldHave(size($$("#selenide-users ." + tag).size()), Duration.ofSeconds(10));
        users.filterBy(not(cssClass(tag))).shouldHave(size(0));
        users.shouldHave(sizeGreaterThan(5));
        users.shouldHave(sizeLessThan(100));
        //Assertions.assertEquals();
    }
}