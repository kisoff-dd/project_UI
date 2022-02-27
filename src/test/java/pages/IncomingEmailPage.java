package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import static tools.Waiting.waitingElem;


public class IncomingEmailPage {


    public WebDriver driver;

    public IncomingEmailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    @FindBy(xpath = "//*[@class='mail-Search']")         // определение локатора кнопка поиск писем
    private WebElement mailSearch;

    @FindBy(xpath ="//*[@placeholder='Поиск']")          // определение локатора строка ввода поиска
    private WebElement searchInputText;

    @FindBy(xpath ="//*[@title='расширенный поиск']")
    private WebElement advancedSearch;                   // определение локатора "расширенный поиск"

    @FindBy(xpath ="//*[@id=\"js-apps-container\"]/div[2]/div[7]/div/div[3]/div[3]/div[1]/div/div/button[3]")
    private WebElement filterFolders;                    // определение локатора фильтр папки *

    @FindBy(xpath ="//div[contains(@class,'control menu__item menu__item_type_option')]/span[contains(text(),'Входящие')]")
    private WebElement filterIncoming;                   // определение локатора фильтр Входящие *

    @FindBy(xpath = "//*[@class='mail-MessagesSearchInfo-Title_misc nb-with-xs-left-gap']")
    private WebElement numberEmail;                      // определение локатора количество писем

    @FindBy(xpath = "//*[@href=\"#compose\"]")           // определение локатора написать письмо
    private WebElement writeEmail;

    @FindBy(xpath = "//*[@class='Layout-m__root--2L1me qa-LeftColumn-MainButtons js-compose-button-container']/button")
    private WebElement refresh;                            // определение локатора проверить новые письма


    public String clickMailSearch(String text) {    // метод для нажатия кнопки поиск
        waitingElem("//*[@class='mail-Search']", driver).isDisplayed();
        mailSearch.click();                               // нажатие кнопки поиск
        advancedSearch.click();                           // нажатие кнопки "расширенный поиск"
        filterFolders.click();                            // нажатие кнопки фильтр Папки
        filterIncoming.click();                           // нажатие кнопки фильтр Входящая
        searchInputText.sendKeys(text);                   // ввода параметра поиска(тема письма)
        searchInputText.submit();
        waitingElem("//*[@class='mail-MessagesSearchInfo_Summary']", driver).isDisplayed();
        String countFirst = numberEmail.getText();        // получаем кол-во писем символьно буквенное
        writeEmail.click();                               // нажатие кнопки Написать(письмо)
        return countFirst;                                // возвращаем значение  для темы нового письма
    }
    public Integer getCountEmailBefore(String count) {    // метод сколько писем в начале
        return (Integer.parseInt(count.replaceAll("\\D+","")));  // удаляем буквы, переводим в число
    }
    public Integer getCountEmailAfter() {                  // метод сколько писем после отправки письма
        String count = numberEmail.getText();              // получаем символы с буквами
        return (Integer.parseInt(count.replaceAll("\\D+","")));  // удаляем буквы, переводим в число
    }
}