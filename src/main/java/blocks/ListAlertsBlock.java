package blocks;

import core.BaseSeleniumPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ListAlertsBlock extends BaseSeleniumPage {
    //@FindBy(xpath = "//div[span[text()='Click Button to see alert']]/following-sibling::div")
    @FindBy(xpath = "//*[@id=\"alertButton\"]")
    private WebElement firstAlert;


    public ListAlertsBlock() {
        PageFactory.initElements(getDriver(), this);
    }

    public void openFirstAlert() throws InterruptedException {
        firstAlert.click();
        Alert alerts = getDriver().switchTo().alert();
        if (alerts.getText().contains("You clicked a button"))
            System.out.println("Good alert");
        else System.out.println("different alert");
        alerts.accept();

        // new ListAlertsBlock();
    }

}
