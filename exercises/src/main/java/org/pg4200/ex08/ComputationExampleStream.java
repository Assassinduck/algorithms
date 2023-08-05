package org.pg4200.ex08;

import org.pg4200.ex06.Author;
import org.pg4200.ex06.Book;

import java.util.List;
import java.util.stream.Collectors;

public class ComputationExampleStream implements ComputationExample{


    private boolean authorsHasNameAndSurname(Author author){
        return author.getName() != null && author.getSurname() != null;
    }

    private String concatNames(Author author){
        return author.getName() + " " + author.getSurname();
    }




    @Override
    public List<String> compute(List<Book> books) {

        return books.stream().
                filter(book -> book.getYear() > 2010 && book.getYear() < 2015)
                .filter(book -> book.getAuthors().size() >= 2)
                .flatMap(book -> book.getAuthors().stream())
                .distinct()
                .filter(this::authorsHasNameAndSurname)
                .map(this::concatNames).collect(Collectors.toList());




    }
}
