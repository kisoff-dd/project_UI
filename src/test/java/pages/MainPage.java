package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import tools.GetChromeDriver;
import tools.Settings;

import java.util.concurrent.TimeUnit;

public class MainPage extends PageFactory {
    public static WebDriver driver = GetChromeDriver.getcromedriver();
    // private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static void startBrowser() {
        driver.manage().window().maximize(); //окно разворачивается на полный экран
        driver.get(Settings.loginPage); //получение ссылки на страницу входа из файла настроек
    }


}
