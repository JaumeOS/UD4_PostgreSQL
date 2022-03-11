package dades;

import org.postgresql.util.PGobject;

import java.sql.SQLException;

import static auxiliars.EinesCadenes.parseValue;
import static auxiliars.EinesCadenes.tanca;

public class Activitats extends PGobject {
    private String titol;
    private String enunciat;
    private String url;

    public Activitats(String titol, String enunciat, String url) {
        this.setTitol(titol);
        this.setEnunciat(enunciat);
        this.setUrl(url);
        this.setType("\"Institut\".\"tipus_activitat\"");
        this.getValue();
    }

    public Activitats() {
        this(null, null, null);
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getEnunciat() {
        return enunciat;
    }

    public void setEnunciat(String enunciat) {
        this.enunciat = enunciat;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String getValue() {
        String value = "(" + tanca(titol) + ",";
        value += tanca(enunciat) + ",";
        value += tanca(url) + ')';
        return value;
    }

    @Override
    public void setValue(String value) throws SQLException {
        super.setValue(value);
        // Descomposa string amb format "(v1,v2,...,vn)"
        // en array d'strings ["v1","v2",...,"vn"]
        String[] atributs = parseValue(value);
        // Assigna valors als atributs de la instancia
        titol = atributs[0];
        enunciat = atributs[1];
        url = atributs[2];
    }

    @Override
    public String toString() {
        return "DadesContacte{" +
                "titol='" + titol + '\'' +
                ", enunciat='" + enunciat + '\'' +
                ", url='" + url + '\'' +
                ", type='" + type + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}