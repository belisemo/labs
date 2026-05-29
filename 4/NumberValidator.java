import java.io.IOException;
import java.util.logging.*;



class CustomNumberFormatException extends Exception {
    public CustomNumberFormatException(String message, Throwable cause) {
        super(message, cause);
    }
}

public class NumberValidator {

    private static final Logger logger = Logger.getLogger(NumberValidator.class.getName());

    static {
        try {
            FileHandler fileHandler = new FileHandler("errors.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
            logger.setUseParentHandlers(false);
        } catch (IOException e) {
            System.err.println("Ошибка настройки логирования: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String value = "123j";

        try {
            validate(value);
             System.out.println("Строка '" + value + "' успешно преобразована в число.");
        } catch (CustomNumberFormatException e) {
            logger.log(Level.SEVERE, "Произошло исключение", e);
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static void validate(String str) throws CustomNumberFormatException {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            CustomNumberFormatException customEx =
                    new CustomNumberFormatException("Строка '" + str + "' не является числом", e);

            logger.log(Level.SEVERE, "Ошибка при валидации строки: " + str, customEx);

            throw customEx;

        }
    }
}
