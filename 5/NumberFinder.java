import java.util.regex.*;

public class NumberFinder {
    public static void main(String[] args) {
        String text = "28 лет в богом забытых джунглях Убивать солдат было несложно, я быстро с этим смирился.\n";


        try {
            Pattern pattern = Pattern.compile("\\b\\d+(\\.\\d+)?\\b");
            Matcher matcher = pattern.matcher(text);

            while (matcher.find()) {
                System.out.println(matcher.group());
            }

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
