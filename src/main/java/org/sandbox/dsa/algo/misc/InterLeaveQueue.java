package org.sandbox.dsa.algo.misc;

import java.util.LinkedList;
import java.util.Queue;

public class InterLeaveQueue {

    private static void interLeaveQueue(Queue<Integer> queue) {
        Queue<Integer> temp = new LinkedList<>();

        int size = queue.size()/2;
        for (int i=0; i<size; i++) {
            temp.add(queue.remove());
        }

        while(!temp.isEmpty()) {
            queue.add(temp.remove());
            queue.add(queue.remove());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=10; i++) {
            q.add(i*10);    //10 20 30.....80 90 100
        }

        //Print Queue Before inter leaving
        System.out.println("Before inter leaving :- " + q.toString());

        //Method call to inter leave the queue
        interLeaveQueue(q);

        //Print Queue After inter leaving
        System.out.print("After inter leaving :-  " + q.toString());
    }

}
