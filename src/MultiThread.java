class Task1 extends Thread {
    public void run() {
        System.out.println("Task 1 started");
        try {
            Thread.sleep(2000); // Simulate some time-consuming task
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task 1 completed");
    }
}

class Task2 extends Thread {
    public void run() {
        System.out.println("Task 2 started");
        try {
            Thread.sleep(3000); // Simulate some time-consuming task
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task 2 completed");
    }
}

public class MultiThread {
    public static void main(String[] args) {
        Task1 task1 = new Task1();
        Task2 task2 = new Task2();

        // Start both threads
        task1.start();
        task2.start();

        try {
            // Wait for both threads to finish
            task1.join();
            task2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Both tasks have completed");
    }
}
