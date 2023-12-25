package com.exemple.openapi.metier.repository.impl;

import com.exemple.openapi.metier.model.Produit;
import com.exemple.openapi.metier.repository.ProduitRepositoryInterface;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class ProduitRepoImplementation implements ProduitRepositoryInterface {

    @Autowired
    DataSource dataSource;

    @Override
    public Produit ajouterDb(Produit produit) {

        val jdbcTemplate = getJdbcTemplate();

        val sql = "insert into produits values (?,?,?)";

        jdbcTemplate.update(sql,produit.name(),produit.prix(),produit.quantite());
        return produit;
    }

    @Override
    public List<Produit> consulterNousProduits() {
        val jdbctemplate = getJdbcTemplate();
        val sql = "SELECT * FROM Produits";
        return jdbctemplate.query(sql,new ProduiMapper());
    }

    private JdbcTemplate getJdbcTemplate() {
        val jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate;
    }
}
