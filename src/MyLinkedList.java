import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class MyLinkedList<T extends Comparable<T>> {
    private Node<T> head;
    private final ReentrantLock lock = new ReentrantLock();

    public MyLinkedList() {
        this.head = null;
    }

    public void add(T data) {
        lock.lock();
        try {
            Node<T> newNode = new Node<>(data);
            if (head == null) {
                head = newNode;
            } else {
                Node<T> current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
        } finally {
            lock.unlock();
        }
    }

    public boolean remove(T data) {
        lock.lock();
        try {
            if (head == null) {
                return false;
            }
            if (head.data.equals(data)) {
                head = head.next;
                return true;
            }
            Node<T> current = head;
            while (current.next != null) {
                if (current.next.data.equals(data)) {
                    current.next = current.next.next;
                    return true;
                }
                current = current.next;
            }
            return false;
        } finally {
            lock.unlock();
        }
    }

    public List<T> findTopN(int N) {
        lock.lock();
        try {
            List<T> values = new ArrayList<>();
            Node<T> current = head;
            while (current != null) {
                values.add(current.data);
                current = current.next;
            }
            values.sort(Collections.reverseOrder());
            return values.subList(0, Math.min(N, values.size()));
        } finally {
            lock.unlock();
        }
    }

    public void printIt() {
        lock.lock();
        try {
            Node<T> current = head;
            while (current != null) {
                System.out.print(current.data + " -> ");
                current = current.next;
            }
            System.out.println("null");
        } finally {
            lock.unlock();
        }
    }
}