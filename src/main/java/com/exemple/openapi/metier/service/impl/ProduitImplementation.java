package com.exemple.openapi.metier.service.impl;

import com.exemple.openapi.metier.model.Produit;
import com.exemple.openapi.metier.service.ProduitInterface;
import lombok.val;

import java.util.ArrayList;
import java.util.List;

public class ProduitImplementation implements ProduitInterface {

    List<Produit> produitList = new ArrayList<>();

    @Override
    public Produit ajout(String name, double prix, int quantite) {

        val produit = Produit.builder().name(name).prix(prix).quantite(quantite).build();

        produitList.add(produit);

        return produit;
    }

    @Override
    public List<Produit> consultProduit() {
        return produitList;
    }
}
