package com.exemple.openapi.metier.service.impl;

import com.exemple.openapi.metier.model.Produit;
import com.exemple.openapi.metier.repository.ProduitRepositoryInterface;
import com.exemple.openapi.metier.service.ProduitInterface;
import lombok.extern.log4j.Log4j2;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProduitImplementation implements ProduitInterface {

    @Autowired
    ProduitRepositoryInterface produitRepositoryInterface;

    @Override
    public Produit ajout(String name, double prix, int quantite) {

        val produit = Produit.builder().name(name).prix(prix).quantite(quantite).build();
        produitRepositoryInterface.ajouterDb(produit);

        return produit;
    }

    @Override
    public List<Produit> consultProduit() {
        return produitRepositoryInterface.consulterNousProduits();
    }
}
