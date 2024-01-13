package com.exemple.openapi.rest;

import com.exemple.openapi.metier.model.Produit;
import com.exemple.openapi.metier.service.ProduitInterface;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Produits",description = "API pour la gestion des Produits")
@RestController
public class ProduitRest {

    @Autowired
    ProduitInterface produitInterface;

    @Operation(description = "ajout produit")
    @ApiResponse(responseCode = "200",
            description = "Ajout Produit OK",
    content = {@Content(mediaType = "application/json",
    schema = @Schema(implementation = Produit.class))})
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
