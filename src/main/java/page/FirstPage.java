package page;

import blocks.ListAlertsBlock;
import blocks.PanelElementsBlock;
import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.awt.*;

public class FirstPage extends BaseSeleniumPage {

    @FindBy(xpath = "//div[@class=\"avatar mx-auto white\"]")
    private WebElement iconElements;

    @FindBy(xpath = " //*[h5[text()='Alerts, Frame & Windows']]")
    private WebElement iconAlerts;

    public FirstPage() {
        //driver.get("http://85.192.34.140:8081/");
        // отвечает за инициализацию всех элементов
        PageFactory.initElements(getDriver(), this);
    }

    public FirstPage open() {
        BaseSeleniumPage.getDriver().get("http://85.192.34.140:8081/");
        return this;
    }

    public PanelElementsBlock openElements() throws AWTException, InterruptedException {
        iconElements.click();
        //PanelElementsBlock panelElements = new PanelElementsBlock();
//
        //panelElements.openTextBox();
        return new PanelElementsBlock();
    }

    public ListAlertsBlock openAlert() throws AWTException, InterruptedException {
        iconAlerts.click();
        PanelElementsBlock panelElements = new PanelElementsBlock();
        panelElements.openAlerts();
        return new ListAlertsBlock();
    }
}
