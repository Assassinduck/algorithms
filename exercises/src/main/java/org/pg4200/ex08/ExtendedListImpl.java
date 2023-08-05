package org.pg4200.ex08;

import org.pg4200.les02.list.MyArrayList;
import org.pg4200.les06.set.MySet;
import org.pg4200.les06.set.MySetHashMap;


import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class ExtendedListImpl<T> extends MyArrayList<T> implements ExtendedList<T> {


    @Override
    public ExtendedList<T> filter(Predicate<T> predicate) {

        ExtendedListImpl<T> list = new ExtendedListImpl<>();

        for (int i = 0; i < this.size ; i++) {
            T value = this.get(i);
            if(predicate.test(value)){
                list.add(value);
            }
        }

        return list;
    }

    @Override
    public <R> ExtendedList<R> map(Function<T, R> mapper) {

        ExtendedListImpl<R> list = new ExtendedListImpl<>();

        for (int i = 0; i < this.size; i++) {
            T value = this.get(i);
            R result = mapper.apply(value);
            list.add(result);
        }

        return list;
    }

    @Override
    public <R> ExtendedList<R> flatMap(Function<T, ExtendedList<R>> mapper) {

        ExtendedListImpl<R> list = new ExtendedListImpl<>();



        for (int i = 0; i < this.size ; i++) {
            T value = this.get(i);
            ExtendedList<R> newList = mapper.apply(value);
            for (int j = 0; j < newList.size(); j++) {
                R rVal = newList.get(j);
                list.add(rVal);
            }

        }
        return list;

    }

    @Override
    public void forEach(Consumer<T> action) {

        for(int i = 0; i < this.size;i++) {
            T value = this.get(i);
            action.accept(value);
        }

    }

    @Override
    public MySet<T> toSet() {
        MySet<T> set = new MySetHashMap<>();

        for (int i = 0; i < this.size ; i++) {
            T value = this.get(i);
            set.add(value);
        }

        return set;
    }


}
