package com.exemple.openapi.metier.repository.impl;


import com.exemple.openapi.metier.model.Produit;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProduiMapper implements RowMapper<Produit> {

    @Override
    public Produit mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Produit.builder()
                .name(rs.getString("name"))
                .prix(rs.getDouble("prix"))
                .quantite(rs.getInt("quantite"))
                .build();
    }
}
