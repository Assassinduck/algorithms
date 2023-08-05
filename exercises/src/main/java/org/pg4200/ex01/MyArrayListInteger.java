package org.pg4200.ex01;

public class MyArrayListInteger {



    public static void main(String[] args) {
        MyArrayListInteger arr = new MyArrayListInteger();

        arr.add(5);
        arr.add(1);

        System.out.println(arr);


    }


    private int[] data;


    private int size;

    public MyArrayListInteger(){
        this(10);
    }


    public MyArrayListInteger(int maxlenght){
       data = new int[maxlenght];  
    }

    public Integer get(int index){
        if(index < 0 && index >= size){
            return null;
        }
        return data[index];
    }


    public void add(int value){
        data[size] = value;
        size++;
    }

    public int size(){
        return size;
    }
    
}
