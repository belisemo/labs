import java.util.regex.*;
public class IpCheck {
    public static void main(String[] args) {
        String ip = "192.168.0.1";

        try {
            String regex = "^((25[0-5]|2[0-4][0-9]\\d|1[0-9][0-9]\\d\\d|[1-9][0-9]?\\d)\\.){3}" +
                    "(25[0-5]|2[0-4][0-9]\\d|1[0-9][0-9]\\d\\d|[1-9][0-9]?\\d)$";

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(ip);

            if (matcher.matches()) {
                System.out.println("IP корректный");
            } else {
                System.out.println("IP НЕ корректный");
            }

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
