package org.pg4200.les02.queue;

public class QueMain {
	public static void main(String[] args) {
		
	MyRingArrayQueue<Integer> ring = new MyRingArrayQueue<Integer>();

 		int n = 1_000;

        for(int i=0; i< n; i++){
            ring.enqueue(i);
            ring.enqueue(i);
            ring.dequeue();
            //ie, insert 2 elements, and then remove 1
        }

		ring.enqueue(8);

		System.out.println(ring.peek());


	}
}
