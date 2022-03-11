package dades;

import auxiliars.PostgresException;

public class Assignatura {
    private String codi;
    private String nom;
    private Cicle cicle;
    private Activitats activitats;

    public Activitats getActivitats() {
        return activitats;
    }

    public void setActivitats(Activitats activitats) {
        this.activitats = activitats;
    }

    public Assignatura(String codi, String nom, Cicle cicle, Activitats activitats) throws PostgresException {
        this.codi = codi;
        this.nom = nom;
        this.cicle = cicle;
        this.activitats = activitats;
    }

    public String getCodi() {
        return codi;
    }

    public void setCodi(String codi) throws PostgresException {
        if (codi == null || codi.trim() == "" || codi.length() != 5) {
            throw new PostgresException("El codi del cicle ha de tenir exactament cinc posicions");
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

    public Cicle getCicle() {
        return cicle;
    }

    public void setCicle(Cicle cicle) {
        this.cicle = cicle;
    }

    @Override
    public String toString() {
        return "Assignatura{" +
                "codi='" + codi + '\'' +
                ", nom='" + nom + '\'' +
                ", cicle=" + cicle +
                ", activitats=" + activitats +
                '}';
    }
}