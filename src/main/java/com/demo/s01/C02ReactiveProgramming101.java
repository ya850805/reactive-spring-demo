package com.demo.s01;

import com.demo.domain.Book;
import com.demo.domain.InMemoryDataSource;
import reactor.core.publisher.Flux;

import java.util.Comparator;

/**
 * Test reactive programming
 */
public class C02ReactiveProgramming101 {
    //返回一個包含每種類別中最貴的書的列表(響應式編程)
    public static Flux<Book> getMostExpensiveBooksByCategoryReactive(Flux<Book> books) {
        return books.collectMultimap(Book::getCategory)
                .flatMapMany(m -> Flux.fromIterable(m.entrySet()))
                .flatMap(e -> Flux.fromIterable(e.getValue())
                        .sort(Comparator.comparing(Book::getPrice).reversed())
                        .next()
                );
    }

    public static void main(String[] args) {
        var pipeline = getMostExpensiveBooksByCategoryReactive(Flux.just(InMemoryDataSource.BOOKS));
        pipeline = pipeline.doOnNext(System.out::println);
        System.out.println("什麼都不會發生，直到pipeline開始");
        pipeline.subscribe();
    }
}
