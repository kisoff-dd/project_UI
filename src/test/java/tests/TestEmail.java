package tests;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.IncomingEmailPage;
import pages.LoginPage;
import pages.ProfilePage;
import pages.WriteEmailPage;
import tools.GetChromeDriver;
import tools.Settings;


public class TestEmail {
    public static WebDriver driver = GetChromeDriver.getcromedriver();
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static IncomingEmailPage incomingEmailPage;
    public static WriteEmailPage writeEmailPage;

    @BeforeTest(enabled = true)
    public static void setup() {
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        incomingEmailPage = new IncomingEmailPage(driver);
        writeEmailPage = new WriteEmailPage(driver);
        driver.get(Settings.loginPage);
        driver.manage().window().maximize();

    }

    @Test
    public void testEmail() {
        try {

            loginPage.inputLogin(Settings.loginEmail, Settings.passwordEmail);      // логинемся в почте
          //  profilePage.entryEmail();                                               // переходим по меню в почту
            String count = incomingEmailPage.clickMailSearch(Settings.themeLetter); // ищем письма с темой, возвращаем строку колво
            int countFirst = (incomingEmailPage.getCountEmailBefore(count));        // вычисляем число
            writeEmailPage.newEmail(Settings.eMail, Settings.themeLetter, count);   // пишем новое письмо

            Assert.assertEquals(countFirst,(incomingEmailPage.getCountEmailAfter()-1));//для проверки теста на крах поменять 1 на 2

        } catch (Exception e) {
            System.out.println("что-то где то поламалось УБРАТЬ В финальном релизе " + e.getMessage());
        }


    }
        @AfterTest(enabled = true)
        public void close () {
            profilePage.userLogout();
            driver.quit();
        }
}
