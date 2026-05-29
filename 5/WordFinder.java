import java.util.regex.*;

public class WordFinder {
    public static void main(String[] args) {
        String text = "tung tung TUng sahur";
        char letter = 't';
        if (!Character.isLetter(letter)) {
            System.out.println("Ошибка: символ должен быть буквой");
            return;
        }

        Pattern pattern = Pattern.compile("\\b" + letter + "\\w*\\b", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
