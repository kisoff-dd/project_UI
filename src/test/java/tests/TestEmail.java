package tests;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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
    //public static WebDriver driver;
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
        //startBrowser();
        driver.get(Settings.loginPage);
        driver.manage().window().maximize();

    }

    @Test
    public void testEmail() {
        try {
            loginPage.inputLogin(Settings.loginEmail,Settings.passwordEmail);  // логинемся в почте
            profilePage.entryEmail();                                          // переходим по меню в почту
            //incomingEmailPage.clickMailSearch(Settings.themeLetter);         // ищем письма с темой, возвращаем колво
            String countFirst = incomingEmailPage.clickMailSearch(Settings.themeLetter);
            writeEmailPage.newEmail(Settings.eMail, Settings.themeLetter, countFirst);// пишем новое письмо

            Assert.assertEquals(countFirst, incomingEmailPage.getCountEmail());
           // Assert.assertEquals(incomingEmail.clickMailSearch(Settings.themeLetter), 2);


        } catch (Exception e) {
            System.out.println("что-то где то поламалось УБРАТЬ ПЕРЕД СДАЧЕЙ ПРОЕКТА " + e.getMessage());
        }


  /*  @AfterTest(enabled = true)
    public void close() {
         profilePage.entryMenu();
         profilePage.userLogout();
         driver.quit(); }*/
    }}
