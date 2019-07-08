package com.clairenyga.quizcamion.model;

public class User {
    private String mPrenom;
    private String mNom;
    private String mImmattracteur;
    private String mImmatremorque;

    public User() {
    }

    public User(String prenom, String nom, String immattracteur, String immatremorque) {
        mPrenom = prenom;
        mNom = nom;
        mImmattracteur = immattracteur;
        mImmatremorque = immatremorque;
    }

    public String getNom() {
        return mNom;
    }

    public void setNom(String nom) {
        mNom = nom;
    }

    public String getImmattracteur() {
        return mImmattracteur;
    }

    public void setImmattracteur(String immattracteur) {
        mImmattracteur = immattracteur;
    }

    public String getImmatremorque() {
        return mImmatremorque;
    }

    public void setImmatremorque(String immatremorque) {
        mImmatremorque = immatremorque;
    }

    public String getFirstname() {
        return mPrenom;
    }

    public void setFirstname(String firstname) {
        mPrenom = firstname;
    }

    @Override
    public String toString() {
        return "User{" +
                "mFirstname='" + mPrenom + '\'' +
                '}';
    }
}
