package entities;


import java.io.Serializable;

public class Envoie implements Serializable {

    private int id;

    private String date;

    private int montant;

    private Emeteur emeteur = new Emeteur();

    private Recepteur recepteur = new Recepteur();


    public Envoie() {
    }

    public Envoie(int id, String date, int montant, Emeteur emeteur, Recepteur recepteur) {
        this.id = id;
        this.date = date;
        this.montant = montant;
        this.emeteur = emeteur;
        this.recepteur = recepteur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public Emeteur getEmeteur() {
        return emeteur;
    }

    public void setEmeteur(Emeteur emeteur) {
        this.emeteur = emeteur;
    }

    public Recepteur getRecepteur() {
        return recepteur;
    }

    public void setRecepteur(Recepteur recepteur) {
        this.recepteur = recepteur;
    }
}
