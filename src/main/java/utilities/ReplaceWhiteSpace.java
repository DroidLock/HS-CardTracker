package utilities;

public class ReplaceWhiteSpace implements iReplaceWhiteSpace{
    public String transfromString(String string) {

        string = string.replaceAll("\\s", "%20");
        return string;
    }
}
