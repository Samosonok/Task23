
/**
 * @author Samosonok Liliia
 * @version 1.0
 */

public class Book {

    @Pseudonym("book name")
    private String title;
    @Ignore
    private int pages;

    public Book(String title, int pages) {
        this.title = title;
        this.pages = pages;
    }
}
