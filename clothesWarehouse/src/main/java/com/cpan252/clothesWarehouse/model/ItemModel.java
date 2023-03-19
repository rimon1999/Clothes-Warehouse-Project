package com.cpan252.clothesWarehouse.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


// This is a model class that represents an item in a warehouse.
// It has fields for the name of the item, its price, the year it was created, and the brand it belongs to.
// It also has constructors, getters and setters for these fields, and annotations for data validation.
// The class is mapped to a database table using JPA annotations.


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ItemModel")
public class ItemModel {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(generator = "gen")
    private Long id;
    @NotBlank

    private String name;

    @Min(1000)

    private double price;
    @Max(2023)

    private Integer yearOfCreation;

    private Brand brandForm;


    public ItemModel(String name, Brand brandForm, double price, int yearOfCreation) {
        this.name = name;
        this.brandForm = brandForm;
        this.price = price;
        this.yearOfCreation = yearOfCreation;


    }
}
