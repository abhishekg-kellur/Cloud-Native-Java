package prg5;

class Thread1 extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread1: " + i);
            try {
                Thread.sleep(2000); 
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Thread1 Finished");
    }
}

class Thread2 extends Thread {
    public void run() {
        for (int i = 10; i <= 15; i++) {
            System.out.println("Thread2: " + i);
            try {
                Thread.sleep(3000); 
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Thread2 Finished");
    }
}

public class MainThread {
    public static void main(String[] args) {
        System.out.println("Main thread started");

        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Main thread finished");
    }
}
