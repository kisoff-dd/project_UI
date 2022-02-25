package tests;

import config.Config;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ApiTest {

    @BeforeTest
    public static void setup() {
        RestAssured.baseURI = "https://reqres.in/api";
    }

    @Test
    public void getRequestWithQueryParam() {
        //сревниваем почту из конфига и полученый результат
        Assert.assertEquals(Config.email, GetData.data(Config.first_name,Config.last_name),"тест1 данные не совпадают");
        Assert.assertEquals(Config.email2, GetData.data(Config.first_name2,Config.last_name2),"тест2 данные не совпадают");
    }

}


