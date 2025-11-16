package core;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

// делаем класс абстрактным, чтобы не могли создавать экземпляры, потому что  мф будем только наследоваться
abstract public class BaseSeleniumTest {
    protected WebDriver driver;


    @Before
    public void setUp() {
        //setting path of chromedriver.exe
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\maksi\\OneDrive\\Рабочий стол\\AutoLearning\\driver\\chromedriver.exe");
        //WebDriverManager.chromedriver().setup();
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

    @After
    public void tearDown() {
        // закрываем Хром драйвер (обязательно)
        //driver.close();
        // закрываем браузер
        //driver.quit();
    }


}
