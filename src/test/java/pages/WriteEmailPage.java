package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static tools.Waiting.waitingElem;


public class WriteEmailPage {
    public WebDriver driver;

    String xPathTextEmail = "//*[@id=\"cke_1_contents\"]/div/div";
    String xPathNewMail = "//*[@class='mail-MessagesSearchInfo-Title_misc nb-with-xs-left-gap']";

    public WriteEmailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }


    @FindBy(xpath = "//div[contains(@class,'MultipleAddressesDesktop-Field ComposeYabblesField')]/div")
    private WebElement addressString;                       // определение локатора поля ввода адреса

    @FindBy(xpath = "//*[@class='ComposeSubject']/div/div/input") // определение локатора поля ввода темы письма
    private WebElement themeEmail;

    @FindBy(xpath = "//*[@id=\"cke_1_contents\"]/div/div")      // определение локатора поля ввода текста письма
    private WebElement bodyEmail;

    @FindBy(xpath = "//button[contains(@class,' Button2_size_l')]")
    private WebElement sendEmail;                           // определение локатора Кнопка "отправить"

    @FindBy(xpath = "//button[contains(@class, \"Button2_view_action\")]")
    private WebElement refresh;                            // определение локатора проверить новые письма

    @FindBy(xpath = "//*[@class='mail-MessagesSearchInfo-Title_misc nb-with-xs-left-gap']")
    private WebElement numberEmail2;                      // определение локатора количество писем

                                                   // метод создания нового письма
    public void newEmail(String eMail, String themeLetter, String count)  {
        waitingElem(xPathTextEmail, driver).isDisplayed();
        bodyEmail.sendKeys("Найдено "+ count ); // заполнение тела письма
        themeEmail.sendKeys(themeLetter);                  // заполнение темы
        addressString.sendKeys(eMail);                     // заполнение адреса
        sendEmail.click();
        waitingElem(xPathNewMail, driver).isDisplayed();
        refresh.click();                                   // обновляем список
        waitingElem(xPathNewMail, driver).isDisplayed();

    }
}
