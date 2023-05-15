import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Controller_libroTest {
    private Controller_libro bookController;

    @BeforeEach
    void setUp() {
        bookController = new Controller_libro();
        bookController.addBook("El Gran Gatsby", "F. Scott Fitzgerald");
        bookController.addBook("1984", "George Orwell");
        bookController.addBook("Cien años de soledad", "Gabriel García Márquez");
    }

    @Test
    void searchByTitle_ExistingTitle_ReturnsMatchingBooks() {
        String keyword = "gatsby";
        List<Modelo_libreria> result = bookController.searchByTitle(keyword);
        assertEquals(1, result.size());
        assertEquals("El Gran Gatsby", result.get(0).getTitle());
    }

    @Test
    void searchByTitle_NonExistingTitle_ReturnsEmptyList() {
        String keyword = "harry potter";
        List<Modelo_libreria> result = bookController.searchByTitle(keyword);
        assertTrue(result.isEmpty());
    }

    @Test
    void searchByAuthor_ExistingAuthor_ReturnsMatchingBooks() {
        String keyword = "garcía márquez";
        List<Modelo_libreria> result = bookController.searchByAuthor(keyword);
        assertEquals(1, result.size());
        assertEquals("Cien años de soledad", result.get(0).getTitle());
    }

    @Test
    void searchByAuthor_NonExistingAuthor_ReturnsEmptyList() {
        String keyword = "tolkien";
        List<Modelo_libreria> result = bookController.searchByAuthor(keyword);
        assertTrue(result.isEmpty());
    }

    @Test
    void updateAvailability_ValidBook_UpdatesAvailability() {
        Modelo_libreria book = bookController.searchByTitle("gatsby").get(0);
        assertTrue(book.isAvailable());

        bookController.updateAvailability(book, false);
        assertFalse(book.isAvailable());
    }

    @Test
    void removeBook_ValidBook_RemovesBook() {
        Modelo_libreria book = bookController.searchByTitle("gatsby").get(0);
        assertTrue(bookController.searchByTitle("gatsby").contains(book));

        bookController.removeBook(book);
        assertFalse(bookController.searchByTitle("gatsby").contains(book));
    }
}