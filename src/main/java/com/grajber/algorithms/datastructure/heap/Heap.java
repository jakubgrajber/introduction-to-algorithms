package com.grajber.algorithms.datastructure.heap;

import com.grajber.algorithms.datastructure.exception.OverflowException;

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

    public Heap<T> insert(T element) {
        if (size >= capacity)
            throw new OverflowException();
        heap[size+1] = element;
        size++;
        return this;
    }

    public void sort() {
        buildMaxHeap();
        for (int i = size; i >= 2; i--) {
            var temp = heap[1];
            heap[1] = heap[i];
            heap[i] = temp;
            size--;
            maxHeapify(1);
        }
    }

    public void buildMaxHeap() {
        for (int i = size/2; i >= 1; i--)
            maxHeapify(i);
    }

    public void maxHeapify(int root) {
        int left = left(root);
        int right = right(root);
        int largest;
        if (left <= size && heap[left].compareTo(heap[root]) > 0)
            largest = left;
        else
            largest = root;
        if (right <= size && heap[right].compareTo(heap[largest]) > 0)
            largest = right;
        if (largest != root) {
            var temp = heap[largest];
            heap[largest] = heap[root];
            heap[root] = temp;
            maxHeapify(largest);
        }
    }

    public void maxHeapifyIteratively(int root) {
        while (true) {
            int left = left(root);
            int right = right(root);
            int largest;
            if (left <= size && heap[left].compareTo(heap[root]) > 0)
                largest = left;
            else
                largest = root;
            if (right <= size && heap[right].compareTo(heap[largest]) > 0 )
                largest = right;

            if (largest != root) {
                var temp = heap[largest];
                heap[largest] = heap[root];
                heap[root] = temp;
                root = largest;
            } else
                return;
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

    public static void main(String[] args) {
        Heap<Integer> heap = new Heap<>(10);
        heap.insert(16).insert(4).insert(10)
                .insert(14).insert(7).insert(9).insert(3)
                .insert(2).insert(8).insert(1);

        heap.print();
        heap.sort();
        heap.print();
    }
}
