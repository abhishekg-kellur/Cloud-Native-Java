package conpro;

import java.util.LinkedList;
import java.util.Queue;

public class ConsumerProducer {

    public static final int BUFFER_SIZE = 5;
    public static final int MAX_ITEMS = 20;

    private static final Queue<Integer> buffer = new LinkedList<>();
    private static int itemCount = 0;

    public static class Producer implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (buffer) {
                    while (buffer.size() == BUFFER_SIZE) {
                        try {
                            buffer.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    if (itemCount < MAX_ITEMS) {
                        int item = itemCount++;
                        buffer.add(item);
                        System.out.println("Produced: " + item);
                        buffer.notifyAll();
                    } else {
                        break;
                    }
                }
            }
        }
    }

    public static class Consumer implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (buffer) {
                    while (buffer.isEmpty()) {
                        try {
                            buffer.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    if (!buffer.isEmpty()) {
                        int item = buffer.poll();
                        System.out.println("Consumed: " + item);
                        buffer.notifyAll();
                    } else {
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread producerThread = new Thread(new Producer());
        Thread consumerThread = new Thread(new Consumer());

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
