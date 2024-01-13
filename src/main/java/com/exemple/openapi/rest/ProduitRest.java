package com.exemple.openapi.rest;

import com.exemple.openapi.metier.model.Produit;
import com.exemple.openapi.metier.service.ProduitInterface;
import com.exemple.openapi.metier.service.impl.ProduitImplementation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Produits",description = "API pour la gestion des Produits")
@RestController
public class ProduitRest {

    @Autowired
    ProduitInterface produitInterface;

    @PostMapping("/ajout")
    public Produit ajoutProduit(String name,double prix,int quantite){
        return produitInterface.ajout(name,prix,quantite);
    }
    @GetMapping("/consulter-produits")
    public List<Produit> list(){
        return produitInterface.consultProduit();
    }

    @GetMapping("/totalProduit")
    public int total(){
        return produitInterface.consultProduit().size();
    }
}
