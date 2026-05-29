public class Stack<T> {

    private T[] data;
    private int size;

    public Stack(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public void push(T element) {
        if (size == data.length) {
            System.out.println("Стек переполнен");
            return;
        }
        data[size] = element;
        size++;
    }

    public T pop() {
        if (size == 0) {
            System.out.println("Стек пуст");
            return null;
        }
        size--;
        return data[size];
    }

    public T peek() {
        if (size == 0) {
            System.out.println("Стек пуст");
            return null;
        }
        return data[size - 1];
    }
}
