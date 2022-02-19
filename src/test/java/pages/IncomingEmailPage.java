package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class IncomingEmailPage {


    public WebDriver driver;

    public IncomingEmailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    @FindBy(xpath = "//*[@class='mail-Search']")         //определение локатора кнопка поиск писем
    private WebElement mailSearch;

    @FindBy(xpath ="//*[@placeholder='Поиск']")          //определение локатора строка ввода поиска
    private WebElement searchInputText;

    @FindBy(xpath ="//*[@title='расширенный поиск']")
    private WebElement advancedSearch;                   //определение локатора "расширенный поиск"

    @FindBy(xpath ="//*[@id=\"js-apps-container\"]/div[2]/div[7]/div/div[3]/div[3]/div[1]/div/div/button[3]")
    private WebElement filterFolders;                    //определение локатора фильтр папки

    @FindBy(xpath ="//*[@id=\"nb-1\"]/body/div[12]/div/div/div[1]/span")
    private WebElement filterIncoming;                   //определение локатора фильтр Входящие

    @FindBy(xpath = "//*[@class='mail-MessagesSearchInfo-Title_misc nb-with-xs-left-gap']")
    private WebElement numberEmail;                      //определение локатора количество писем

    @FindBy(xpath = "//*[@href=\"#compose\"]")         //определение локатора написать письмо //span[text()='Написать']
    private WebElement writeEmail;


    public String clickMailSearch(String text) {          // метод для нажатия кнопки поиск
        mailSearch.click();
        advancedSearch.click();                           // нажатие кнопки "расширенный поиск"
        filterFolders.click();                            // нажатие кнопки фильтр Папки
        filterIncoming.click();                           // нажатие кнопки фильтр Входящая
        searchInputText.sendKeys(text);                   // ввода параметра поиска(тема письма)
        searchInputText.submit();
        String countFirst = getCountEmail();
        writeEmail.click();
        //driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);//ожидаем полной загрузки старницы

       // Integer count = Integer.parseInt(s);
        // StringBuffer count = new StringBuffer(s);
       // count = count.replaceAll("\\D+","");
        return countFirst;
    }

    public String getCountEmail() {          // метод для нажатия кнопки поиск
        String count = numberEmail.getText();             // взятие кол-ва писем
        return count ;
    }
}