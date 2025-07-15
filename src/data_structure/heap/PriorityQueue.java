package data_structure.heap;

import java.util.Comparator;
import java.util.NoSuchElementException;

public class PriorityQueue<T> {
    private T[] heap;
    private int size;
    private final Comparator<? super T> comparator;

    @SuppressWarnings("unchecked")
    public PriorityQueue(int capacity, Comparator<? super T> comparator) {
        heap = (T[]) new Object[capacity];
        size = 0;
        this.comparator = comparator;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 父节点的索引
    private int parent(int node) {
        return (node - 1) / 2;
    }

    // 左子节点的索引
    private int left(int node) {
        return node * 2 + 1;
    }

    // 右子节点的索引
    private int right(int node) {
        return node * 2 + 2;
    }

    // 交换数组的两个元素
    private void swap(int i, int j) {
        T temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // 查，返回堆顶元素，时间复杂度 O(1)
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority queue underflow");
        }
        return heap[0];
    }

    // 增，向堆中插入一个元素，时间复杂度 O(logN)
    public void push(T x) {
        // 扩容
        if (size == heap.length) {
            resize(2 * heap.length);
        }
        // 把新元素追加到最后
        heap[size] = x;
        // 然后上浮到正确位置
        swim(size);
        size++;
    }

    // 删，删除堆顶元素，时间复杂度 O(logN)
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Priority queue underflow");
        }
        T res = heap[0];
        // 把堆底元素放到堆顶
        swap(0, size - 1);
        // 避免对象游离
        heap[size - 1] = null;
        size--;
        // 然后下沉到正确位置
        sink(0);
        // 缩容
        if ((size > 0) && (size == heap.length / 4)) {
            resize(heap.length / 2);
        }
        return res;
    }

    // 上浮操作，时间复杂度是树高 O(logN)
    private void swim(int node) {
        while (node > 0 && comparator.compare(heap[parent(node)], heap[node]) > 0) {
            swap(parent(node), node);
            node = parent(node);
        }
    }

    // 下沉操作，时间复杂度是树高 O(logN)
    private void sink(int node) {
        while (left(node) < size || right(node) < size) {
            // 比较自己和左右子节点，看看谁最小
            int min = node;
            if (left(node) < size && comparator.compare(heap[left(node)], heap[min]) < 0) {
                min = left(node);
            }
            if (right(node) < size && comparator.compare(heap[right(node)], heap[min]) < 0) {
                min = right(node);
            }
            if (min == node) {
                break;
            }
            // 如果左右子节点中有比自己小的，就交换
            swap(node, min);
            node = min;
        }
    }

    // 调整堆的大小
    @SuppressWarnings("unchecked")
    private void resize(int capacity) {
        assert capacity > size;
        T[] temp = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            temp[i] = heap[i];
        }
        heap = temp;
    }


}