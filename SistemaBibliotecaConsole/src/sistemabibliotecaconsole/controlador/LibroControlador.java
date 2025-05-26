package SistemaBibliotecaConsole.controlador;

import SistemaBibliotecaConsole.modelo.Libro;
import SistemaBibliotecaConsole.modelo.LibroDAO;

import java.sql.SQLException;
import java.util.List;

public class LibroControlador {
    private final LibroDAO libroDAO = new LibroDAO();

    public void agregarLibro(Libro libro) throws SQLException {
        libroDAO.agregarLibro(libro);
    }

    public List<Libro> obtenerLibros() throws SQLException {
        return libroDAO.listarLibros();
    }

    public void editarLibro(Libro libro) throws SQLException {
        libroDAO.editarLibro(libro);
    }

    public void eliminarLibro(int id) throws SQLException {
        libroDAO.eliminarLibro(id);
    }
}
