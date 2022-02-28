import SupportingFiles.PayLoads;
import SupportingFiles.ReUsableMethods;
import io.restassured.RestAssured;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.ArrayList;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class LibraryAPI {

    private String id = "";
    private ArrayList<String> ids = new ArrayList<String>();

    @Test(dataProvider = "BookDataArray")
    public void AddBook(String isbn, String aisle){
        RestAssured.baseURI = "http://216.10.245.166";

        String addPlaceResponse = given().log().all().header("Content-Type","application/json").body(PayLoads.addBook(isbn, aisle))
                .when().post("/Library/Addbook.php")
                .then().log().all().assertThat().statusCode(200)
                .extract().response().asString();
        var addPlaceResponseJSON = ReUsableMethods.stringToJSON(addPlaceResponse);
        id = addPlaceResponseJSON.get("ID");
        System.out.println(id);
        ids.add(id);
        System.out.println(ids);
    }

    @Test(dataProvider = "responseIdArray")
    public void DeleteBook(String id){
            given().log().all().header("Content-Type","application/json").body(PayLoads.deleteBook(id))
                    .when().post("/Library/DeleteBook.php")
                    .then().log().all().assertThat().statusCode(200)
                    .body("msg", equalTo("book is successfully deleted"));

    }

    @DataProvider(name="BookDataArray")
    public Object[][] getBookData(){
        var bookDataArray = new Object[][] {{"RALJ","001"},{"RALJ","002"},{"RALJ","003"}};
        return bookDataArray;
    }

    @DataProvider(name="responseIdArray")
    public Object[][] getIds(){
        var idArray = new Object[][] {{ids.get(0)},{ids.get(1)},{ids.get(2)}};
        return idArray;
    }
}
