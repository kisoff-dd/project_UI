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
    public void getRequest() {
        //сревниваем полученый результат и почту из конфига
        Assert.assertEquals(GetData.data(Config.first_name,Config.last_name), Config.email,"тест1 данные не совпадают");
    }
    @Test
    public void getRequest2() {
        Assert.assertEquals(GetData.data(Config.first_name2,Config.last_name2), Config.email2,"тест2 данные не совпадают");
    }

}


