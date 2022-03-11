package controller;

import auxiliars.PostgresException;
import dades.Activitats;
import dades.Assignatura;
import dades.Cicle;
import org.postgresql.PGConnection;

import java.sql.*;
import java.util.Properties;


public class BaseDades {
    private final String url;
    private final Properties propietats;

    public BaseDades(String url, Properties propietats) {
        this.url = url;
        this.propietats = propietats;
    }

    public Activitats getActivitats(String codi) throws PostgresException {
        Activitats activitats = null;
        try (Connection con = DriverManager.getConnection(url, propietats);
             PreparedStatement st =
                     con.prepareStatement("SELECT codi, nom FROM \"Institut\".\"Cicles\" WHERE codi=?")) {
            st.setString(1, codi);
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    activitats = new Activitats(rs.getString(1), rs.getString(2), rs.getString(3));
                }
            }
        } catch (SQLException e) {
            throw new PostgresException("Error recuperant un cicle: " + e.getMessage());
        }
        return activitats;
    }

    public Cicle getCicle(String codi) throws SQLException, PostgresException {
        Cicle cicle = null;
        try (Connection con = DriverManager.getConnection(url, propietats);
             PreparedStatement st = con.prepareStatement("Select codi, nom from \"Institut\".\"Cicles\" Where codi=?")) {
            st.setString(1, codi);
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    cicle = new Cicle(rs.getString(1), rs.getString(2));
                }
            }
        }
        return cicle;
    }

    /**
     * 2. Recupera una assignatura a partir del seu identificador
     *
     * @param codi
     * @return
     * @throws PostgresException
     */
    public Assignatura getAssignatura(String codi) throws SQLException, PostgresException {
        Assignatura assignatura = null;
        try (Connection con = DriverManager.getConnection(url, propietats);
             PreparedStatement st = con.prepareStatement("Select * from \"Institut\".\"Assignatures\" Where codi=?")) {
            st.setString(1, codi);
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    assignatura = new Assignatura(rs.getString(1), rs.getString(2), getCicle(rs.getString(3)), getActivitats(rs.getString(4)));
                }
            }
        }
        return assignatura;
    }

    // (1 punt) Crea un nou mètode per afegir una activitat a una assignatura determinada.
    public void creaAssignaturaActivitat(Assignatura assignatura, String titolActivitat) throws PostgresException {
        try (Connection con = DriverManager.getConnection(url, propietats)) {
            PGConnection conpg = (PGConnection) con;
            conpg.addDataType("\"Institut\".\"tipus_activitat\"", Activitats.class);

            try (PreparedStatement st = con.prepareStatement(
                    "UPDATE \"Institut\".\"Assignatures\"\n" +
                            "SET activitat.titol = ?" +
                            "WHERE codi = ?;")) {
                st.setString(1, titolActivitat);
                st.setString(2, assignatura.getCodi());
                st.executeUpdate();
            }
        } catch (SQLException e) {
            throw new PostgresException("Error afegint alumne: " + e.getMessage());
        }
    }
}