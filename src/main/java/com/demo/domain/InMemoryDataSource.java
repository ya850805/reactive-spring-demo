package com.demo.domain;

import java.math.BigDecimal;

public class InMemoryDataSource {
    public static final Book[] BOOKS = new Book[]{
            new Book("CK Book #1", BigDecimal.valueOf(19.99D), "CS"),
            new Book("CK Book #2", BigDecimal.valueOf(9.99D), "CS"),
            new Book("CK Book #3", BigDecimal.valueOf(39.99D), "CS"),

            new Book("Children Book #1", BigDecimal.valueOf(20.99D), "CHILDREN"),
            new Book("Children Book #2", BigDecimal.valueOf(25.99D), "CHILDREN"),
            new Book("Children Book #3", BigDecimal.valueOf(24.99D), "CHILDREN"),
            new Book("Children Book #4", BigDecimal.valueOf(10.99D), "CHILDREN"),

            new Book("Novel #1", BigDecimal.valueOf(6.99D), "NOVEL"),
            new Book("Novel #1", BigDecimal.valueOf(12.99D), "NOVEL"),
            new Book("Novel #1", BigDecimal.valueOf(8.99D), "NOVEL"),
            new Book("Novel #1", BigDecimal.valueOf(1.99D), "NOVEL"),
    };
}
