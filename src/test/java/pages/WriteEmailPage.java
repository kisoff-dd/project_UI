package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

import static tools.Waiting.waitingElement;


public class WriteEmailPage {
    public WebDriver driver;

    public WriteEmailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    @FindBy(xpath = "//div[contains(@class,'MultipleAddressesDesktop-Field ComposeYabblesField')]/div")
    private WebElement addressString;                       // определение локатора поля ввода адреса

    @FindBy(xpath = "//*[@class='ComposeSubject']/div/div/input") // определение локатора поля ввода темы письма
    private WebElement themeEmail;

   // @FindBy(xpath = "//*[@placeholder=\"Напишите что-нибудь\"]//child::div")//*[@placeholder="Напишите что-нибудь"]//child::div
    @FindBy(xpath = "//*[@id=\"cke_1_contents\"]/div")      // определение локатора поля ввода текста письма
    private WebElement bodyEmail;

    @FindBy(xpath = "//*[@class='Button2 Button2_pin_circle-circle Button2_view_default Button2_size_l']")
    private WebElement sendEmail;                           // определение локатора Кнопка "отправить"

    @FindBy(xpath = "//*[@class='Layout-m__root--2L1me qa-LeftColumn-MainButtons js-compose-button-container']/button")
    private WebElement refresh;                            // определение локатора проверить новые письма
    //span[text()='Новое письмо']
                                                           // метод создания нового письма
    public void newEmail(String eMail, String themeLetter, String count) throws InterruptedException {
        Thread.sleep(2000);                          // не успевает обновить отсортированный список входящих
        bodyEmail.sendKeys("Найдено "+ count ); // заполнение тела письма
        themeEmail.sendKeys(themeLetter);                  // заполнение темы
        addressString.sendKeys(eMail);                     // заполнение адреса
        sendEmail.click();
        Thread.sleep(3000);                          // ожидаем получение отправленного письма
        refresh.click();                                   // обновляем список
        Thread.sleep(3000);                          // не успевает обновить отсортированный список входящих

    }
}
