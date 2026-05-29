import java.util.regex.*;

public class PasswordCheck {
    public static void main(String[] args) {
        String password = "GOIdaSVO2022";

        try {
            Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,16}$");
            Matcher matcher = pattern.matcher(password);

            if (matcher.matches()) {
                System.out.println("Пароль корректный");
            } else {
                System.out.println("Пароль НЕ корректный");
            }

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
