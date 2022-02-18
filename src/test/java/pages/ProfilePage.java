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

    @FindBy(xpath = "//*[contains(@class, 'user-pic__image')]") //определение локатора меню пользователя
    private WebElement userMenu;

    @FindBy(xpath ="//*[@href='https://mail.yandex.ru']") //определение локатора почта
    private WebElement userEmail;

    @FindBy(xpath = "//*[contains(@class, 'menu-item_action_exit menu__item menu__item_type_link')]")
    private WebElement logoutBtn; //определение локатора кнопки выхода из аккаунта

    public String getUserName() { //метод для получения имени пользователя из меню пользовател
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'account__name_hasAccentLetter')]")));
        String userName = userMenu.getText();
        return userName; }

    public void entryEmail() { //метод для нажатия кнопки почта
        userEmail.click(); }

    public void entryMenu() { //метод для нажатия кнопки меню пользователя
        userMenu.click(); }

    public void userLogout() { //метод для нажатия кнопки выхода из аккаунта
        logoutBtn.click(); } }
