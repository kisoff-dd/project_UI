package tests;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.IncomingEmail;
import pages.LoginPage;
import pages.ProfilePage;
import tools.GetChromeDriver;
import tools.Settings;


public class TestEmail {
    public static WebDriver driver = GetChromeDriver.getcromedriver();
    //public static WebDriver driver;
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static IncomingEmail incomingEmail;


    @BeforeTest(enabled = true)
    public static void setup() {
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        incomingEmail = new IncomingEmail(driver);
        //startBrowser();
        driver.get(Settings.loginPage);

    }

    @Test
    public void testEmail() {
        try {
          /*  loginPage.inputLogin(Settings.loginEmail);//вводим логин
            loginPage.clickLoginBtn(); //нажимаем кнопку входа
            loginPage.inputPasswd(Settings.passwordEmail); //вводим пароль
            loginPage.clickLoginBtn(); //нажимаем кнопку входа*/

            profilePage.entryMenu();//
            profilePage.entryEmail();

            incomingEmail.clickMailSearch();
            incomingEmail.clickAdvancedSearch();
            incomingEmail.clickFilterFolders();
            incomingEmail.clickFilterIncoming();
            incomingEmail.inputText(Settings.themeLetter);

            //получаем отображаемый логин
            Assert.assertEquals(incomingEmail.countEmail(), 2); //и сравниваем его с логином из файла настроек



        } catch (Exception e) {
            System.out.println("что-то гдето поламалось " + e.getMessage());
        }


  /*  @AfterTest(enabled = true)
    public void close() {
         profilePage.entryMenu();
         profilePage.userLogout();
         driver.quit(); }*/
    }}
