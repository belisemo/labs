import java.util.regex.*;

public class LowerUpper {
    public static void main(String[] args) {
        String text = "aBc1De aBBBBccD";


            Pattern pattern = Pattern.compile("[a-z][A-Z]");
            Matcher matcher = pattern.matcher(text);

            String result = matcher.replaceAll("!$0!");
            System.out.println(result);


    }
}
