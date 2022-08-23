import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class CheckValidation {
    private final String name;
    private final String expectedResult;

    public CheckValidation(String name, String expectedResult) {
        this.name = name;
        this.expectedResult = expectedResult;
    }
    @Parameterized.Parameters
    public static Object[][] dataForTest() {
        return new Object[][] {
                { "", "Не должно быть меньше 3 символов. Строка должны быть разделена пробелами. "},
                { "Да", "Не должно быть меньше 3 символов. Строка должны быть разделена пробелами. "},
                { "ф с", "Введённые данные удовлетворяют условиям!"},
                { "Фв а", "Введённые данные удовлетворяют условиям!"},
                { "Игорь Пааааавлович", "Введённые данные удовлетворяют условиям!"},
                { "Игорь Паааааавлович", "Введённые данные удовлетворяют условиям!"},
                { "Игорь Паааааавловичч", "Не должно быть больше 19 символов. "},
                { "Игорь Пааааавлович ", "Строка не должна заканчиваться пробелом. "},
                { " Игорь Пааааавлович ", "Не должно быть больше 19 символов. Строка не должна начинаться с пробела. Строка не должна заканчиваться пробелом. "},
                { " Игорь Пааааавлович", "Строка не должна начинаться с пробела. "},
                { "ИгорьПааааавлович", "Строка должны быть разделена пробелами. "},
                { " ", "Не должно быть меньше 3 символов. Строка не должна начинаться с пробела. Строка не должна заканчиваться пробелом. "},
        };
    }
    @Test
    public void checkValidation() {
        Account account = new Account(name);
        Assert.assertEquals(expectedResult, account.checkNameToEmboss(name));
    }
}
