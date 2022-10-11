public class Test {
    public static void main(String[] args) {
        QueueImplementedWithArray<String> queue = new QueueImplementedWithArray<>(4);
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        queue.dequeue();
        queue.dequeue();
        queue.enqueue("5");
        queue.print();
        queue.printArrayImplementation();
        queue.enqueue("6");
        queue.enqueue("7");
        queue.print();
        queue.printArrayImplementation();
    }
}
