
/**
 * @author Samosonok Liliia
 * @version 1.0
 */

public class Book {

    @Pseudonym("book name")
    private String title;
    private String writer;
    @Ignore
    private int pages;

    public Book(String title, String writer, int pages) {
        this.title = title;
        this.writer = writer;
        this.pages = pages;
    }
}
