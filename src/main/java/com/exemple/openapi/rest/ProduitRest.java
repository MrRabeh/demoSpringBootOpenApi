package com.exemple.openapi.rest;

import com.exemple.openapi.metier.model.Produit;
import com.exemple.openapi.metier.service.ProduitInterface;
import com.exemple.openapi.metier.service.impl.ProduitImplementation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Produits",description = "API pour la gestion des Produits")
@RestController
public class ProduitRest {

    ProduitInterface produitInterface = new ProduitImplementation();

    @PutMapping("/ajout/{name}/{prix}/{quantite}")
    public Produit ajoutProduit(@PathVariable String name,@PathVariable double prix,@PathVariable int quantite){
        return produitInterface.ajout(name,prix,quantite);
    }
    @GetMapping("/consulter-produits")
    public List<Produit> list(){
        return produitInterface.consultProduit();
    }
}
