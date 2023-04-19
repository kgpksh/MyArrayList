package org.example;

public class MyArrayList<T> {
    private int maxSize = 16;
    private int pointer = -1;
    private T[] array;
    public MyArrayList() {
        array = (T[]) new Object[maxSize];
    }
    public MyArrayList(int size) {
        this.maxSize = size;
        array = (T[]) new Object[size];
    }

    public boolean add(T element) {

        if (pointer == maxSize - 1) {
            maxSize *= 2;
            T[] tmp = (T[]) new Object[maxSize];
            for (int tmpIndex = 0; tmpIndex < pointer + 1; tmpIndex++) {
                tmp[tmpIndex] = array[tmpIndex];
            }

            array = tmp;
        }
        pointer++;
        array[pointer] = element;
        return true;
    }

    public int size() {
        return pointer + 1;
    }

    public T get(int index) throws IndexOutOfBoundsException {
        try {
            return array[index];
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw indexOutOfBoundsException;
        }
    }

    public T remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= pointer) {
            throw new IndexOutOfBoundsException();
        }

        T result = array[index];
        array[index] = null;
        pointer--;

        for (int i = index + 1; i < maxSize; i++) {
            array[i - 1] = array[i];
        }
        return result;
    }

    public boolean contains(T target) {
        for (int index = 0; index < pointer; index++) {
            if (array[index].equals(target)) {
                return true;
            }
        }

        return false;
    }

    public int indexOf(T target) {
        for (int index = 0; index < pointer + 1; index++) {
            if (array[index].equals(target)) {
                return index;
            }
        }

        return -1;
    }
    public void show() {
        for (T ele : array) {
            System.out.println(ele);
        }
    }

    public void clear() {
        for (int index = 0; index < pointer + 1; pointer++) {
            array[index] = null;
        }

        pointer = -1;
    }

    public boolean isEmpty() {
        return pointer == -1;
    }
}
