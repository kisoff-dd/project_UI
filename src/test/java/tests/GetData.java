package tests;


import io.restassured.http.ContentType;
import io.restassured.response.Response;


import static io.restassured.RestAssured.*;

public class GetData {

    public static String data (String fistName, String last_name) {
        int page = 1;
        do {
            Response response = given()
                    .contentType(ContentType.JSON)
                    .when().get("/users?page=" + page)                  //перебор страниц
                    .then()
                    .extract().response();
            String text = response.jsonPath()
                    .getString("data.find{(it.first_name =='" + fistName + "')&&" +
                            "(it.last_name =='" + last_name + "')}.email");// если имя и фамилия совпадает забираем почту
            if (text != null) {                                            // если значение не пустое возвращаем результат
                return text;
            }
            page++;

        } while (page != 3);
        return "Данные не найдены";

    }}
