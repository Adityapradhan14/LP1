import java.util.concurrent.Semaphore;

class ReaderWritersProblem {
    // Semaphore for managing access for readers and writers
    static Semaphore readLock = new Semaphore(1);
    static Semaphore writeLock = new Semaphore(1);
    static int readCount = 0;

    // Reader class implementing Runnable
    static class Read implements Runnable {
        @Override
        public void run() {
            try {
                // Acquire lock for reading
                readLock.acquire();
                readCount++;
                if (readCount == 1) {
                    writeLock.acquire(); // Block writers if it's the first reader
                }
                readLock.release();

                // Reading section
                System.out.println("Thread " + Thread.currentThread().getName() + " is READING");
                Thread.sleep(1500); // Simulate reading process
                System.out.println("Thread " + Thread.currentThread().getName() + " has FINISHED READING");

                // Releasing section
                readLock.acquire();
                readCount--;
                if (readCount == 0) {
                    writeLock.release(); // Release writer lock if no readers left
                }
                readLock.release();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // Writer class implementing Runnable
    static class Write implements Runnable {
        @Override
        public void run() {
            try {
                writeLock.acquire(); // Acquire lock for writing
                System.out.println("Thread " + Thread.currentThread().getName() + " is WRITING");
                Thread.sleep(2500); // Simulate writing process
                System.out.println("Thread " + Thread.currentThread().getName() + " has FINISHED WRITING");
                writeLock.release(); // Release lock after writing
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        // Create Reader and Writer tasks
        Read read = new Read();
        Write write = new Write();

        // Create and name threads for readers and writers
        Thread t1 = new Thread(read);
        t1.setName("thread1");
        Thread t2 = new Thread(read);
        t2.setName("thread2");
        Thread t3 = new Thread(write);
        t3.setName("thread3");
        Thread t4 = new Thread(read);
        t4.setName("thread4");

        // Start the threads
        t1.start();
        t3.start();
        t2.start();
        t4.start();
    }
}

