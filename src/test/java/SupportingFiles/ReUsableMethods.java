package SupportingFiles;
import io.restassured.path.json.JsonPath;

public class ReUsableMethods {
    public static JsonPath stringToJSON(String response){
        JsonPath res = new JsonPath(response);
        return res;
    }
}
