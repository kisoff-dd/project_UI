package tests;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


import static io.restassured.RestAssured.*;

public class GetData {

    public static String data (String firstName, String lastName) {
        int page = 1;
        int total_pages;
        String email;
        RestAssured.baseURI = "https://reqres.in/api";
        do {
            Response response = given()
                    .contentType(ContentType.JSON)
                    .when().get("/users?page=" + page)                  //перебор страниц
                    .then()
                    .extract().response();
            email = response.jsonPath()
                    .getString("data.find{(it.first_name =='" + firstName + "')&&" +
                            "(it.last_name =='" + lastName + "')}.email");// если имя и фамилия совпадает забираем почту
            total_pages = response.jsonPath()                              // определяем кол-во страниц на сайте для цикла
                   .getInt("total_pages");
            if (email != null) {                                            // если значение не пустое возвращаем результат
                return email;
            }
            page++;
        } while (page != total_pages+1);
        return "Данные не найдены";

    }}
