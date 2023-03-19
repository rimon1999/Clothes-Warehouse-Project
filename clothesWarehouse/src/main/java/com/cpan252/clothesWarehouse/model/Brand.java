package com.cpan252.clothesWarehouse.model;

public enum Brand {


    BALENCIAGA("Balenciaga"), STONE("Stone"), ISLAND("Island"), DIOR("Dior"),
    LOUIS_VUITTON("Louis Vuitton"), GUCCI("Gucci");

    public final String name;

    private Brand(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}


