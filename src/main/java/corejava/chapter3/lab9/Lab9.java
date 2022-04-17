package corejava.chapter3.lab9;

import corejava.chapter3.lab8.Greeter;

import java.util.ArrayList;
import java.util.List;

public class Lab9 {

    public static void runTogether(Runnable... tasks) {
        for (Runnable task : tasks)
            new Thread(task).start();
    }

    public static void runInOrder(Runnable... tasks) {
        for (Runnable task : tasks) {
            task.run();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable[] tasks = createTasks(10, 100);

        System.out.println("START RUN IN ORDER:");
        runInOrder(tasks);
        System.out.println("START RUN TOGETHER:");
        runTogether(tasks);
    }

    private static Runnable[] createTasks(int countTasks, int countTime) {
        List<Runnable> tasks = new ArrayList<>();
        for (int i = 0; i < countTasks; i++) {
            tasks.add(new Greeter(countTime, "Hello, " + i));
        }
        return tasks.toArray(new Runnable[0]);
    }
}
