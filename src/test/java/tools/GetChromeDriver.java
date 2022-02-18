package tools;

import org.openqa.selenium.chrome.ChromeDriver;

public class GetChromeDriver {
    public static ChromeDriver getcromedriver() {
        String path = System.getProperty("user.dir");
        String chromeDriverPath = path + "\\chromedriver\\chromedriver98.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        return new ChromeDriver();
    }
}
