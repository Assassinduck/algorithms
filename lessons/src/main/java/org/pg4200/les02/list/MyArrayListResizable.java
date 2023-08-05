package org.pg4200.les02.list;

public class MyArrayListResizable<T> extends MyArrayList<T> {

       public MyArrayListResizable(){
        super();
    }

    public MyArrayListResizable(int capacity){
        super(capacity);
    }


    @Override
    public void add(int index, T value) {


        if(size == data.length){
            Object[] bigger = new Object[data.length * 2];

            for(int i =0; i < data.length; i++){
                bigger[i] = data[i];
            }
            data = bigger;
        }
        
        


        super.add(index, value);
    }

    





    


    
}
