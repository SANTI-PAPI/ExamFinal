/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import com.mycompany.examfinalController.Controller_libro;
import com.mycompany.examfinalController.Controller_user;
import com.mycompany.examfinalModelo.Modelo_usuario;
import java.util.List;
import java.util.Scanner;

public class Vista {
    private Controller_libro bookController;
    private Controller_user userController;
    private Modelo_usuario currentUser;
    private Scanner scanner;

    public Vista() {
        bookController = new Controller_libro();
        userController = new Controller_user();
        scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.print("Ingrese su nombre de usuario: ");
        String username = scanner.nextLine();
        currentUser = userController.getUserByUsername(username);
        if (currentUser == null) {
            System.out.println("Usuario no válido.");
            return;
        }
        
        if (currentUser.isIsAdmin()) {
            runAdminMenu();
        } else {
            runUserMenu();
        }
    }

    private void runAdminMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Agregar libro");
            System.out.println("2. Eliminar libro");
            System.out.println("3. Actualizar disponibilidad");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opción: ");
            int option = scanner.nextInt();
            scanner.nextLine(); //
        }
    }
    
                       switch (option) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    updateAvailability();
                    break;
                case 4:
                    generateSalesReport();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        
    

    private void runUserMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n--- Menú de Usuario ---");
            System.out.println("1. Buscar libros por título");
            System.out.println("2. Buscar libros por autor");
            System.out.println("3. Comprar libro");
            System.out.println("4. Devolver libro");
            System.out.println("5. Recomendaciones de libros");
            System.out.println("6. Salir");
            System.out.print("Ingrese una opción: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (option) {
                case 1:
                    searchBooksByTitle();
                    break;
                case 2:
                    searchBooksByAuthor();
                    break;
                case 3:
                    purchaseBook();
                    break;
                case 4:
                    returnBook();
                    break;
                case 5:
                    getBookRecommendations();
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }

    private void addBook() {
        System.out.print("Ingrese el título del libro: ");
        String title = scanner.nextLine();
        System.out.print("Ingrese el autor del libro: ");
        String author = scanner.nextLine();
        Controller_libro.addBook(title, author);
        System.out.println("Libro agregado exitosamente.");
    }

    private void removeBook() {
        System.out.print("Ingrese el título del libro a eliminar: ");
        String title = scanner.nextLine();
        System.out.print("Ingrese el autor del libro a eliminar: ");
        String author = scanner.nextLine();
        List<Modelo_libreria> books = Controller_libro.searchByTitle(title);
        books.retainAll(Controller_libro.searchByAuthor(author));

        if (!books.isEmpty()) {
            Modelo_libreria book = books.get(0);
            Controller_libro.removeBook(book);
            System.out.println("Libro eliminado exitosamente.");
        } else {
            System.out.println("Libro no encontrado.");
        }
    }

    private void updateAvailability() {
        System.out.print("Ingrese el título del libro a actualizar: ");
        String title = scanner.nextLine();
        System.out.print("Ingrese el autor del libro a actualizar: ");
        String author = scanner.nextLine();
        List<Modelo_libreria> books = Controller_libro.searchByTitle(title);
        books.retainAll(Controller_libro.searchByAuthor(author));

        if (!books.isEmpty()) {
            Modelo_libreria book = books.get(0);
            System.out.print("Ingrese la nueva disponibilidad (true/false): ");
            boolean available = scanner.nextBoolean();
            Controller_libro.updateAvailability(book, available);
            System.out.println("Disponibilidad actualizada exitosamente.");
        } else {
            System.out.println("Libro no encontrado.");
        }
    }

    private void generateSalesReport() {
        // Lógica para generar el informe de ventas
        System.out.println("Generando informe de ventas...");
    }

    private void searchBooksByTitle() {
        System.out.print("Ingrese el título del libro a buscar: ");
        String title = scanner.nextLine();
        List<Modelo_libreria> books = Controller_libro.searchByTitle(title);

        if (!books.isEmpty()) {
            System.out.println("Libros encontrados:");
            for (Modelo_libreria book : books) {
                System.out.println("- " + book.getTitle() + " por " + book.getAuthor());
            }
        } else {
            System.out.println("No se encontraron libros con ese título.");
        }
    }

    private void searchBooksByAuthor() {
        System.out.print("Ingrese el autor del libro a buscar: ");
        String author = scanner.nextLine();
        List<Modelo_libreria> books = Controller_libro.searchByAuthor(author);

        if (!books.isEmpty()) {
            System.out.println("Libros encontrados:");
            for (Modelo_libreria book : books) {
                System.out.println("- " + book.getTitle() + " por " + book.getAuthor());
            }
        } else {
            System.out.println("No se encontraron libros con ese autor.");
        }
    }

    private void purchaseBook() {
        // Lógica para comprar un libro
        System.out.println("Comprando libro...");
    }

    private void returnBook() {
        // Lógica para devolver un libro
        System.out.println("Devolviendo libro...");
    }

    private void getBookRecommendations() {
        // Lógica para obtener recomendaciones de libros
        System.out.println("Obteniendo recomendaciones de libros...");
    }
}
        
