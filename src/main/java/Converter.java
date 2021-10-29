import java.lang.reflect.Field;

/**
 * @author Samosonok Liliia
 * @version 1.0
 */

public class Converter {

    static Book book = new Book("Witcher", 600);
    static String result;

    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {
        System.out.println(ConvertBook(book));
    }

    public static String ConvertBook(Object object) throws IllegalAccessException, NoSuchFieldException {
        Class<?> clazz = object.getClass();
        String className = clazz.getSimpleName().toLowerCase();
        Field[] fields = clazz.getDeclaredFields();

        String field1 = getAnnotationValue(fields);

        Field titleField = clazz.getDeclaredField("title");

        titleField.setAccessible(true);

        Object title = titleField.get(object);

        result = ("<" + className + ">\n" +
                "   <" + field1 + ">" + title + "</" + field1 + ">\n" +
                "</" + className + ">\n");

        return result;
    }

    public static String getAnnotationValue(Field[] fields){
        for (Field field : fields) {
            if (field.isAnnotationPresent(Pseudonym.class)) {
                return field.getDeclaredAnnotation(Pseudonym.class).value();
            } else return null;
        }
        return null;
    }
}
