package com.exemple.openapi.metier.model;

import lombok.Builder;

@Builder
public record Produit(
        String name,
        double prix,
        int quantite
) {
}
