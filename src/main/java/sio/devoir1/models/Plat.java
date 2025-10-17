package sio.devoir1.models;

public class Plat
{
    private String nom;
    private double prix;
    private String photo;

    public Plat(String nom, double prix, String photo) {
        this.nom = nom;
        this.prix = prix;
        this.photo = photo;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
