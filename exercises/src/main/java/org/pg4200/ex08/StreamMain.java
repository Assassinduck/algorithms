package org.pg4200.ex08;

import org.pg4200.ex06.Author;
import org.pg4200.ex06.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamMain {

    public static void main(String[] args) {

        /*Author autor1 = new Author("julian", "Pettersen");
        Author autor2 = new Author("petter", "juliansen");

        Author autor3 = new Author("tommy", "andersen");
        Author autor4 = new Author("karl", "marx");


        List<Author> authorList = List.of(autor1, autor2);
        List<Author> authorList2 = List.of(autor3, autor4);

        Book book1 = new Book("Man", 2011, authorList );
        Book book2 = new Book("lol", 2013, authorList2 );

        List<Book> books = List.of(book1,book2);

        ComputationExampleStream stream = new ComputationExampleStream();
        System.out.println(stream.compute(books).size());*/
        ComputationExampleStream stream = new ComputationExampleStream();


        Author first = new Author("a","b");
        Author second = new Author("c","d");

        Book book = new Book("title", 2012, Arrays.asList(first, second));

        List<String> list = stream.compute(List.of(book));

        System.out.println(Arrays.toString(list.toArray()));


    }
}
