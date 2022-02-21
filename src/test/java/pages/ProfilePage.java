package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class ProfilePage {

    public WebDriver driver;

    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

   // @FindBy(xpath = "//*[@href=\"https://passport.yandex.ru\"]/div") // определение локатора меню пользователя
    //@FindBy(xpath = "//*[contains(@class, 'user-pic__image')]") // определение локатора меню пользователя
    private WebElement userMenu;

    @FindBy(xpath ="//*[@href='https://mail.yandex.ru']")       // определение локатора почта
    private WebElement userEmail;

    @FindBy(xpath = "//*[contains(@class, 'menu__item menu__item_type_link count-me legouser__menu-item legouser__menu-item_action_exit')]")
    private WebElement logoutBtn;                   // определение локатора кнопки выхода из аккаунта


    public void entryEmail() {
        userMenu.click();                           // нажатие кнопки меню пользователя
        userEmail.click();                          // нажатие папки почта
    }
    public void userLogout() {
        userMenu.click();                           // нажатие кнопки меню пользователя
        logoutBtn.click();                          // нажатие выход из папки
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='WelcomePage-tagline']")));
    }
}
