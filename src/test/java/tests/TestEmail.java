package tests;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.IncomingEmailPage;
import pages.LoginPage;
import pages.WriteEmailPage;
import tools.GetChromeDriver;
import tools.Settings;


public class TestEmail {
    public static WebDriver driver = GetChromeDriver.getcromedriver();
    public static LoginPage loginPage;
    public static IncomingEmailPage incomingEmailPage;
    public static WriteEmailPage writeEmailPage;

    @BeforeTest
    public static void setup() {
        loginPage = new LoginPage(driver);
        incomingEmailPage = new IncomingEmailPage(driver);
        writeEmailPage = new WriteEmailPage(driver);
        driver.get(Settings.loginPage);
        driver.manage().window().maximize();

    }

    @Test
    public void testEmail() {

            loginPage.inputLogin(Settings.loginEmail, Settings.passwordEmail);      // логинемся в почте
            String count = incomingEmailPage.clickMailSearch(Settings.themeLetter); // ищем письма с темой, возвращаем строку колво
            int countFirst = (incomingEmailPage.getCountEmailBefore(count));        // вычисляем число
            writeEmailPage.newEmail(Settings.eMail, Settings.themeLetter, count);   // пишем новое письмо

            Assert.assertEquals(countFirst,(incomingEmailPage.getCountEmailAfter()-1),"количество писем не изменилось");
    }

    @AfterTest(enabled = false)
    public void close () {
           driver.quit();
        }
}
