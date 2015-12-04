package queue;

import java.util.HashMap;

//implement a queue using a hash map
public class HashMapQueue
{
    int position = 0;
    int next = 0;

    HashMap<Integer, String> queue = new HashMap<Integer, String>();

    //insert new element assigning a position in the queue
    public void enqueue(String data) {
        queue.put(++position, data);
    }

    //remove elements out of the queue and keep track of the position to remove next
    public String dequeue() {
        return queue.get(++next);
    }
}