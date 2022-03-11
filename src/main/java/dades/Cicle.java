package dades;


import auxiliars.PostgresException;

public class Cicle {
    private String codi;
    private String nom;

    public Cicle(String codi, String nom) throws PostgresException {
        this.setCodi(codi);
        this.setNom(nom);
    }


    public String getCodi() {
        return codi;
    }

    public void setCodi(String codi) throws PostgresException {
        if (codi == null || codi.trim() == "" || codi.length() != 2) {
            throw new PostgresException("El codi del cicle ha de tenir exactament dues posicions");
        }
        this.codi = codi;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) throws PostgresException {
        if (nom == null || nom.trim() == "" || nom.length() > 100) {
            throw new PostgresException("El nom del cicle no pot ser nul, ni cadena buida, ni tenir més de 100 posicions.");
        }
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Cicle{" +
                "codi='" + codi + '\'' +
                ", nom='" + nom + '\'' +
                '}';
    }
}
