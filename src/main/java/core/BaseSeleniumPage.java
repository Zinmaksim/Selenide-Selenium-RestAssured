package core;

import org.openqa.selenium.WebDriver;

abstract public class BaseSeleniumPage {
    // Статическое поле — получает driver от BaseSeleniumTest
    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public static void setDriver(WebDriver driver) {
        driverThreadLocal.set(driver);
    }

    public static WebDriver getDriver() {
        WebDriver driver = driverThreadLocal.get();
        if (driver == null) {
            throw new IllegalStateException(
                    "WebDriver is not initialized! " +
                            "Call BaseSeleniumPage.setDriver(...) in @Before setup."
            );
        }
        return driver;
    }
}
