package SistemaBibliotecaConsole.modelo;

import SistemaBibliotecaConsole.util.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LectorDAO {

    public void agregarLector(Lector lector) throws SQLException {
        String sql = "INSERT INTO lectores (nombre, email) VALUES (?, ?)";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, lector.getNombre());
            stmt.setString(2, lector.getEmail());
            stmt.executeUpdate();
        }
    }

    public List<Lector> listarLectores() throws SQLException {
        List<Lector> lectores = new ArrayList<>();
        String sql = "SELECT * FROM lectores";
        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lectores.add(new Lector(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("email")
                ));
            }
        }
        return lectores;
    }

    public void editarLector(Lector lector) throws SQLException {
        String sql = "UPDATE lectores SET nombre = ?, email = ? WHERE id = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, lector.getNombre());
            stmt.setString(2, lector.getEmail());
            stmt.setInt(3, lector.getId());
            stmt.executeUpdate();
        }
    }

    public void eliminarLector(int id) throws SQLException {
        String sql = "DELETE FROM lectores WHERE id = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
