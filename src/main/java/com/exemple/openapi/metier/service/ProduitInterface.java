package com.exemple.openapi.metier.service;

import com.exemple.openapi.metier.model.Produit;

import java.util.List;

public interface ProduitInterface {

    public Produit ajout(String name,double prix,int quantite);

    public List<Produit> consultProduit();
}
