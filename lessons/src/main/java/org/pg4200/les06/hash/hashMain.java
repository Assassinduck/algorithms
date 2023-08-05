package org.pg4200.les06.hash;
class Item {

    public final String value;
    public final int code;

    public Item(String value, int code) {
        this.value = value;
        this.code = code;
    }
}
public class hashMain {



    public static void main(String[] args) {
        MyHashMapLinearProbe<Item, String> map = new MyHashMapLinearProbe<Item, String>();

        int[] code = {0, 42, 996};

        Item a = new Item("foo", code[0]);
        Item b = new Item("bar", code[1]);

        map.put(a,a.value);
        map.put(b, b.value);

        System.out.println(map.size());


        System.out.println(map.get(a));
        System.out.println(map.get(b));

        map.delete(a);

        System.out.println();


    }
}

