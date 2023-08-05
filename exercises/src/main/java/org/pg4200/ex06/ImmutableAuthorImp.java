package org.pg4200.ex06;

import java.util.Objects;

public class ImmutableAuthorImp implements ImmutableAuthor{


    private final String name;

    private final String surname;


    public ImmutableAuthorImp() {
        this(null, null);
    }


    public ImmutableAuthorImp(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
    @Override
    public ImmutableAuthorImp withName(String name) {
        return new ImmutableAuthorImp( name, this.surname);
    }

    @Override
    public ImmutableAuthorImp withSurname(String surname) {
        return new ImmutableAuthorImp(this.name, surname);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImmutableAuthorImp author = (ImmutableAuthorImp) o;
        return Objects.equals(name, author.getName()) &&
                Objects.equals(surname, author.getSurname());
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, surname);
    }
}
