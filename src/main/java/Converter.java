import java.lang.reflect.Field;

/**
 * @author Samosonok Liliia
 * @version 1.0
 */

public class Converter {

    static Book book = new Book("Witcher", 600);
    static String result;

    public static void main(String[] args) throws IllegalAccessException {
        System.out.println(ConvertBook(book));
    }

    public static String ConvertBook(Book book) throws IllegalAccessException {
        @Ignore
        Class<Book> clazz = Book.class;

        @Pseudonym("book")
        String className = clazz.getSimpleName().toLowerCase();

        @Ignore
        Field[] fields = clazz.getDeclaredFields();

        @Pseudonym("title")
        String field1 = fields[0].getName();
        @Pseudonym("pages")
        String field2 = fields[1].getName();

        fields[0].setAccessible(true);
        fields[1].setAccessible(true);

        Object title = fields[0].get(book);
        Object pages = fields[1].get(book);

        result = ("<" + className + ">\n" +
                "   <" + field1 + ">" + title + "</" + field1 +">\n" +
                "   <" + field2 + ">" + pages + "</" + field2 +">\n" +
                "</" + className + ">\n");

        return result;
    }
}
