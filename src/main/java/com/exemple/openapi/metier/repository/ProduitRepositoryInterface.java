package com.exemple.openapi.metier.repository;

import com.exemple.openapi.metier.model.Produit;

import java.util.List;

public interface ProduitRepositoryInterface {

    public Produit ajouterDb(Produit produit);

    public List<Produit> consulterNousProduits();
}
