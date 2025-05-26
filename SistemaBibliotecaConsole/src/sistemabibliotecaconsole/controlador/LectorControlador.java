package SistemaBibliotecaConsole.controlador;

import SistemaBibliotecaConsole.modelo.Lector;
import SistemaBibliotecaConsole.modelo.LectorDAO;

import java.sql.SQLException;
import java.util.List;

public class LectorControlador {
    private final LectorDAO lectorDAO = new LectorDAO();

    public void agregarLector(Lector lector) throws SQLException {
        lectorDAO.agregarLector(lector);
    }

    public List<Lector> obtenerLectores() throws SQLException {
        return lectorDAO.listarLectores();
    }

    public void editarLector(Lector lector) throws SQLException {
        lectorDAO.editarLector(lector);
    }

    public void eliminarLector(int id) throws SQLException {
        lectorDAO.eliminarLector(id);
    }
}
