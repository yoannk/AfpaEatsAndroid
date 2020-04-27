package com.example.afpaeats.Entities;

public class Session {
    private static String id;
    private static Utilisateur utilisateur;
    private static Panier panier;

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        Session.id = id;
    }

    public static Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public static void setUtilisateur(Utilisateur utilisateur) {
        Session.utilisateur = utilisateur;
    }

    public static Panier getPanier() {
        if (panier == null) {
            panier = new Panier();
        }
        return panier;
    }

    public static void setPanier(Panier panier) {
        Session.panier = panier;
    }
}