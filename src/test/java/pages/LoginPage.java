package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;


public class LoginPage {                            // конструктор класса, занимающийся инициализацией полей класса

    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    @FindBy(xpath = "//*[@id=\"index-page-container\"]/div/div[2]/div/div/div[4]/a[2]")
    private WebElement enter;

    @FindBy(xpath = "//*[contains(@id, 'passp-field-login')]")  //определение локатора поля ввода логина
    private WebElement loginField;

    @FindBy(xpath = "//*[contains(text(), 'Войти')]/..")        //определение локатора кнопки входа в аккаунт
    private WebElement loginBtn;

    @FindBy(xpath = "//*[contains(@id, 'passp-field-passwd')]") //определение локатора поля ввода пароля
    private WebElement passwdField;

    public void inputLogin(String login, String passwd) {       //метод для ввода логина
        enter.click();
        loginField.sendKeys(login);
        loginBtn.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));//ожидаем полной загрузки старницы
        passwdField.sendKeys(passwd);
        loginBtn.click();
    }
}