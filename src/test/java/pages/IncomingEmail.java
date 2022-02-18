package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class IncomingEmail {


    public WebDriver driver;

    public IncomingEmail(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    @FindBy(xpath = "//*[@class='mail-Search']") //определение локатора кнопка поиск писем
    private WebElement mailSearch;

    @FindBy(xpath ="//*[@placeholder='Поиск']") //определение локатора строка ввода поиска
    private WebElement searchInputText;

    @FindBy(xpath ="//*[@title='расширенный поиск']")
    private WebElement advancedSearch; //определение локатора "расширенный поиск"

    @FindBy(xpath ="//*[@id=\"js-apps-container\"]/div[2]/div[7]/div/div[3]/div[3]/div[1]/div/div/button[3]")
    private WebElement filterFolders; //определение локатора фильтр папки

    @FindBy(xpath ="//*[@id=\"nb-1\"]/body/div[12]/div/div/div[1]/span") //определение локатора фильтр Входящие
    private WebElement filterIncoming;

    @FindBy(xpath = "//*[@class='mail-MessagesSearchInfo-Title_misc nb-with-xs-left-gap']") //определение локатора количество писем
    private WebElement numberEmail;

    public void clickMailSearch() { //метод для нажатия кнопки поиск
        mailSearch.click(); }

    public void inputText(String text) { //метод ввода параметра поиска(тема письма)
        searchInputText.sendKeys(text + "\n"); }

    public void clickAdvancedSearch() { //метод для нажатия кнопки "расширенный поиск"
        advancedSearch.click(); }

    public void clickFilterFolders() { //метод для нажатия кнопки фильтр Папки
        filterFolders.click(); }

    public void clickFilterIncoming() { //метод для нажатия кнопки фильтр Входящая
        filterIncoming.click(); }

    public String countEmail() { //метод для подсчета кол-ва писем
       // WebDriverWait wait = new WebDriverWait(driver, 2);
        String count = numberEmail.getText();
        return count; }


}