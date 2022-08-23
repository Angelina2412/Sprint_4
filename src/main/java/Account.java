import org.apache.commons.lang3.StringUtils;

public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public String checkNameToEmboss(String name) {
        StringBuilder message = new StringBuilder();

        /*
             Этот метод должен проверять, что сохранённая через конструктор строка соответствует требованиям.
             Если строка удовлетворяет условиям, метод возвращает true, иначе — false.
         */
//        if (name.length() >= 3 & name.length() <= 19 & !StringUtils.startsWith(name, " ") & !StringUtils.endsWith(name, " ")
//                & StringUtils.containsWhitespace(name)) {
//            return true;
//        }
//        return false;
        if (name.length() < 3) message.append("Не должно быть меньше 3 символов. ");
        if (name.length() > 19) message.append("Не должно быть больше 19 символов. ");
        if (StringUtils.startsWith(name, " ")) message.append("Строка не должна начинаться с пробела. ");
        if (StringUtils.endsWith(name, " ")) message.append("Строка не должна заканчиваться пробелом. ");
        if (!(StringUtils.containsWhitespace(name))) message.append("Строка должны быть разделена пробелами. ");
        if (message.length() == 0) message.append ("Введённые данные удовлетворяют условиям!");
        return message.toString();
    }
}

