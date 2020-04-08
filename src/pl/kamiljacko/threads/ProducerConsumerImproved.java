package pl.kamiljacko.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

import static pl.kamiljacko.threads.ProducerConsumerImproved.EOF;

public class ProducerConsumerImproved {

    public static final String EOF = "EOF";

    public static void main(String[] args) {

        ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<>(6);
        //ReentrantLock bufferLock = new ReentrantLock(); // new ReentrantLock(true) <- first come, first serve ordering, may prevent from thread starvation also helps keep threads priority, fair lock  - longer waiting therad will get the lock first
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        MyProducer producer = new MyProducer(buffer);
        MyConsumer consumer1 = new MyConsumer(buffer);
        MyConsumer consumer2 = new MyConsumer(buffer);

        executorService.execute(producer);
        executorService.execute(consumer1);
        executorService.execute(consumer2);

        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() {
                return "Callable result";
            }
        });

        try {
            System.out.println(future.get());
        } catch (ExecutionException e) {
            System.out.println("sth went wrong");
        } catch (InterruptedException e) {
            System.out.println("Thread running the task was interrupted");
        }

        executorService.shutdown();
    }
}

class MyProducer
        implements Runnable {
    private ArrayBlockingQueue<String> buffer;

    public MyProducer(ArrayBlockingQueue buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        String[] messages = {"There was something", "there was nothing", "this make some sense", "the end is here"};
        Random random = new Random();
        for (String m : messages) {
            try {
                System.out.println("Adding..." + m);
                buffer.put(m);

                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {
                System.out.println("Producer was interrupted");
            }
        }
        System.out.println("Adding EOF and exiting");
        try {
            buffer.put("EOF");
        } catch (InterruptedException e) {
        }
    }
}

class MyConsumer
        implements Runnable {
    private ArrayBlockingQueue<String> buffer;

    public MyConsumer(ArrayBlockingQueue buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (buffer) {
                try {
                    if (buffer.isEmpty()) {
                        continue;
                    }
                    if (buffer.peek().equals(EOF)) {
                        System.out.println("Exit");
                        break;
                    } else {
                        System.out.println("Removed " + buffer.take());
                    }
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
