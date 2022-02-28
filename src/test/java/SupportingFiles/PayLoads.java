package SupportingFiles;

public class PayLoads {
    public static String addBook(String isbn, String aisle){
        String payload = "{\n" +
                "\n" +
                "\"name\":\"Learn Self Discipline\",\n" +
                "\"isbn\":\""+isbn+"\",\n" +
                "\"aisle\":\""+aisle+"\",\n" +
                "\"author\":\"Danny Denzongpa\"\n" +
                "}";
        return payload;
    }

    public static String deleteBook (String id){
        String payload = "{\n" +
                " \n" +
                "\"ID\" : \""+id+"\"\n" +
                " \n" +
                "}";
        return payload;
    }
}
