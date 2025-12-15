package blocks;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.event.KeyEvent;

public class PanelElementsBlock extends BaseSeleniumPage {
    @FindBy(xpath = "//*[span[text()='Alerts']]")
    private WebElement iconAlerts;

    @FindBy(xpath = "//*[span[text()='Text Box']]")
    private WebElement iconTextBox;

    public PanelElementsBlock() {
        PageFactory.initElements(getDriver(), this);
    }

    public TextBoxBlock openTextBox() throws AWTException, InterruptedException {
        iconTextBox.click();
        return new TextBoxBlock();
    }

    public void scrollToEndPage() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_END);
        robot.keyRelease(KeyEvent.VK_END);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }

    public void openAlerts() throws AWTException, InterruptedException {
        iconAlerts.click();
        new PanelElementsBlock();
    }

}
