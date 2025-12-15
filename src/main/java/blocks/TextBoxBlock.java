package blocks;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextBoxBlock extends BaseSeleniumPage {

    @FindBy(xpath = "//input[@id=\"userName\"]")
    private WebElement fullName;

    @FindBy(xpath = "//input[@id=\"userEmail\"]")
    private WebElement email;

    @FindBy(xpath = "//textarea[@id=\"currentAddress\"]")
    private WebElement currentAddress;

    @FindBy(xpath = "//textarea[@id=\"permanentAddress\"]")
    private WebElement permanentAddress;

    @FindBy(xpath = "//button[@id=\"submit\"]")
    private WebElement buttonSubmit;

    public TextBoxBlock() {
        PageFactory.initElements(getDriver(), this);
    }

    public TextBoxBlock submitTextBox(String fullNameValue, String emailValue, String currentAddressValue, String permanentAddressValue) throws InterruptedException {
        fullName.sendKeys(fullNameValue);
        email.sendKeys(emailValue);
        currentAddress.sendKeys(currentAddressValue);
        permanentAddress.sendKeys(permanentAddressValue);
        buttonSubmit.click();
        return this;
    }

}
