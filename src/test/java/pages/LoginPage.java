package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class LoginPage {                            // конструктор класса, занимающийся инициализацией полей класса

    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    @FindBy(xpath = "//*[contains(@id, 'passp-field-login')]")  //определение локатора поля ввода логина
    private WebElement loginField;

    @FindBy(xpath = "//*[contains(text(), 'Войти')]/..")        //определение локатора кнопки входа в аккаунт
    private WebElement loginBtn;

    @FindBy(xpath = "//*[contains(@id, 'passp-field-passwd')]") //определение локатора поля ввода пароля
    private WebElement passwdField;

    public void inputLogin(String login, String passwd) {       //метод для ввода логина
        loginField.sendKeys(login);
        loginBtn.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);//ожидаем полной загрузки старницы
        passwdField.sendKeys(passwd);
        loginBtn.click();
    }
}