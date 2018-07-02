package com.github.datastructures;

import com.codahale.metrics.Timer;
import com.github.metrics.MetricsServer;

import java.util.NoSuchElementException;

/**
 * This is a simple implementation of the queue data structure using Array. This implementation was only focused on
 * implementing the data structure for the Integer data type.
 */
public class Queue {
    private int queueArray[];
    private int front, rear, size, len;
    private MetricsServer metricsServer = MetricsServer.getInstance();
    private Timer.Context enqContext;
    private Timer.Context deqContext;

    /**
     * Constructor for the queue data structure, define the arrya size here.
     *
     * @param n size of the array you need
     */
    public Queue(int n) {
        queueArray = new int[n];
        size = n;
        front = 0;
        rear = -1;
    }

    /**
     * check whether queue is empty or not. Here empty means no more elements can be retrieved from dequeue method.
     *
     * @return if the array is empty true, else false
     */
    public boolean isEmpty() {
        return (front > rear);
    }

    /**
     * check whether queue is full or not
     *
     * @return if the array is full true, else false
     */
    public boolean isFull() {
        return (rear == size - 1);
    }

    /**
     * Just return the front value without dequeue it.
     *
     * @return front value of the queue
     */
    public int frontValue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Underflow Exception: There is no element to retrieve");
        }
        return (queueArray[front]);
    }

    /**
     * method to add new element to the array
     *
     * @param val value of the element
     */
    public void enqueue(int val) {
        enqContext = metricsServer.getEnqueueTime().time();
        if (isFull()) {
            throw new IndexOutOfBoundsException("Overflow Exception: The queue array is full, you cant enqueue more elements");
        } else {
            queueArray[++rear] = val;
        }
        enqContext.stop();
    }

    /**
     * method to retrive front element and remove it from array
     *
     * @return front element(Permanently)
     */
    public int dequeue() {
        deqContext = metricsServer.getDequeueTime().time();
        if (isEmpty()) {
            throw new NoSuchElementException("Underflow Exception: There is no element to dequeue");
        }
        deqContext.stop();
        return queueArray[front++];
    }

    /**
     * method to display full size of the array
     *
     * @return array size
     */
    public int arraySize() {
        return size;
    }

    /**
     * method to display number of elements of the array
     *
     * @return number of elements in the array
     */
    public int length() {
        return (rear - front + 1);
    }
}
