package com.grajber.algorithms.datastructure.heap;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Heap<T extends Comparable<T>> {

    private final T[] heap;
    private final int capacity;
    private int size;

    public Heap(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.heap = (T[]) new Comparable[capacity+1];
    }

    public boolean insert(T element) {
        if (size >= capacity)
            return false;
        heap[size+1] = element;
        size++;
        return true;
    }

    public void maxHeapify(int root) {
        int left = left(root);
        int right = right(root);
        int largest;
        if (left <= size && heap[left].compareTo(heap[root]) > 0)
            largest = left;
        else
            largest = root;
        if (right <= size && heap[right].compareTo(heap[root]) > 0)
            largest = right;
        if (largest != root) {
            var temp = heap[largest];
            heap[largest] = heap[root];
            heap[root] = temp;
            maxHeapify(largest);
        }
    }

    public void minHeapify(int root) {
        int left = left(root);
        int right = right(root);
        int min;
        if (left <= size && heap[left].compareTo(heap[root]) < 0)
            min = left;
        else
            min = root;
        if (right <= size && heap[right].compareTo(heap[root]) < 0)
            min = right;
        if (min != root) {
            var temp = heap[min];
            heap[min] = heap[root];
            heap[root] = temp;
            minHeapify(min);
        }
    }

    public void print() {
        System.out.println(Arrays.toString(heap));
    }
    public int parent(int position) {
        return position >> 1;
    }

    public int left(int position) {
        return position << 1;
    }

    public int right(int position) {
        return (position << 1) + 1;
    }
}
