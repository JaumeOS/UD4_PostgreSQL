import auxiliars.PostgresException;
import controller.BaseDades;
import dades.Assignatura;

import java.sql.SQLException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5433/institut";
        Properties propietats = new Properties();
        propietats.put("user", "postgres");
        propietats.put("password", "1234");
        propietats.put("currentSchema", "Institut");

        BaseDades db = new BaseDades(url, propietats);

        try {
            Assignatura assignatura1 = db.getAssignatura("SPPRO");
            db.creaAssignaturaActivitat(assignatura1, "activitat1");
            System.out.println(db.getAssignatura("SPPRO"));

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (PostgresException e) {
            e.printStackTrace();
        }
    }
}
