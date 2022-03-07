package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import static tools.Waiting.waitingElem;


public class LoginPage {                            // конструктор класса, занимающийся инициализацией полей класса

    By xPathFieldPasswd = By.xpath("//*[@id=\"passp-field-passwd\"]");

    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    @FindBy(xpath = "//a[contains(@class,\"Enter with-shadow\")]")
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
        waitingElem(xPathFieldPasswd, driver).isDisplayed();
        passwdField.sendKeys(passwd);
        loginBtn.click();
    }
}