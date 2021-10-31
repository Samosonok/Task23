import java.lang.reflect.Field;

/**
 * @author Samosonok Liliia
 * @version 1.0
 */

public class Converter {

    static Book book = new Book("Witcher", "Sapkowski", 600);
    static String result;
    static String tagName1;
    static String tagName2;
    static Object fieldName1;
    static Object fieldName2;

    public static void main(String[] args) throws IllegalAccessException {
        System.out.println(convertSomeObject(book));
    }

    public static String convertSomeObject(Object object) throws IllegalAccessException {
        Class<?> clazz = object.getClass();
        String className = clazz.getSimpleName().toLowerCase();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Ignore.class)) {
                field.getDeclaredAnnotation(Ignore.class);
            } else if (field.isAnnotationPresent(Pseudonym.class)) {
                tagName1 = field.getDeclaredAnnotation(Pseudonym.class).value();
                fieldName1 = field.get(object);
            } else {
                tagName2 = field.getName();
                fieldName2 = field.get(object);
            }
        }

        result = ("<" + className + ">" +
                "\n   <" + tagName1 + ">" + fieldName1 + "</" + tagName1 + ">" +
                "\n   <" + tagName2 + ">" + fieldName2 + "</" + tagName2 + ">" +
                "\n</" + className + ">");

        return result;
    }
}
