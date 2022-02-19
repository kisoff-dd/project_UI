package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class WriteEmailPage {
    public WebDriver driver;

    public WriteEmailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    @FindBy(xpath = "//*[@id=\"js-apps-container\"]/div[2]/div[10]/div/div/div[1]/div/div[2]/div/div[1]/div[1]/div[1]/div/div[1]/div[1]/div[1]/div/div/div/div/div")
    private WebElement addressString;                       //определение локатора поля ввода адреса

    @FindBy(xpath = "//*[@class='ComposeSubject']/div/div/input") //определение локатора поля ввода темы письма
    private WebElement themeEmail;

    @FindBy(xpath = "//*[@id=\"cke_1_contents\"]/div")      //определение локатора поля ввода текста письма
    private WebElement bodyEmail;

    @FindBy(xpath = "//*[@class='Button2 Button2_pin_circle-circle Button2_view_default Button2_size_l']")
    private WebElement sendEmail;                           //определение локатора Кнопка "отправить"

    public void newEmail(String eMail, String themeLetter, String count) {//метод для ввода логина
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);//ожидаем полной загрузки старницы
        bodyEmail.sendKeys("Найдено "+ count );
        themeEmail.sendKeys(themeLetter);
        addressString.sendKeys(eMail);
        sendEmail.click();


   //public void textEmail(int i) {//метод для текста
           /* if (i% 2 == 0){
                text = "\"Найдено "+ i +" писем" ;
            } else {
            text = "\"Найдено "+ i +" письма";*/
    //    String text=

    }
}
