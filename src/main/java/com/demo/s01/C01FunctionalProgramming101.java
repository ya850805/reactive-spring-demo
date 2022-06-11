package com.demo.s01;

import com.demo.domain.Book;
import com.demo.domain.InMemoryDataSource;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Compare functional programming & non-functional programming
 */
public class C01FunctionalProgramming101 {
    //返回一個包含每種類別中最貴的書的列表(非函數式編程)
    public static List<Book> getMostExpensiveBookByCategory() {
        var map = new HashMap<String, Book>();
        for (Book book : InMemoryDataSource.BOOKS) {
            var aBook = map.get(book.getCategory());

            if (Objects.nonNull(aBook)) {
                if (book.getPrice().compareTo(aBook.getPrice()) > 0) {
                    map.put(book.getCategory(), book);
                }
            } else {
                map.put(book.getCategory(), book);
            }
        }
        return new ArrayList<>(map.values());
    }

    //返回一個包含每種類別中最貴的書的列表(函數式編程)
    public static List<Book> getMostExpensiveBooksByCategoryFunctional() {
        return Stream.of(InMemoryDataSource.BOOKS)
                .collect(Collectors.groupingBy(Book::getCategory))
                .entrySet()
                .stream()
                .map(e -> e.getValue()
                        .stream()
                        .sorted(Comparator.comparing(Book::getPrice).reversed())
                        .findFirst()
                        .get()
                )
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        var books1 = getMostExpensiveBookByCategory();
        books1.stream().forEach(System.out::println);

        System.out.println();

        var books2 = getMostExpensiveBooksByCategoryFunctional();
        books2.stream().forEach(System.out::println);
    }
}
