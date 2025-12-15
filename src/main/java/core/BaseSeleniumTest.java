package core;


import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

// делаем класс абстрактным, чтобы не могли создавать экземпляры, потому что мы будем только наследоваться
abstract public class BaseSeleniumTest {
    protected WebDriver driver;


    @BeforeEach
    public void setUp() {
        // Включаем логгирование Selenide → Allure
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)   // ✅ скриншоты при ошибках
                .savePageSource(true)); // опционально: HTML-исходник
        //setting path of chromedriver.exe
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\maksi\\OneDrive\\Рабочий стол\\AutoLearning\\driver\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\maksi\\IdeaProjects\\selenide\\chromedriver.exe");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //driver.manage().window().setSize(new Dimension(1920, 1080));
        // здесь может понадобится выставить в настройках экрана ноутбука разрешение 100% чтобы правильно отобразился экран
        driver.manage().window().maximize();
        // нерекомендованные
        // driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        BaseSeleniumPage.setDriver(driver);
    }

    @AfterEach
    public void tearDown() {
        // закрываем Хром драйвер (обязательно)
        //driver.close();
        // закрываем браузер
        if (driver != null) {
            driver.quit();
        }
    }


}
