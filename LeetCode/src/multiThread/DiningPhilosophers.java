package multiThread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class DiningPhilosophers {

    public DiningPhilosophers() {
        for (int i = 0; i < 5; i++) {
            locks[i] = new ReentrantLock();
        }
    }

    private Lock[] locks = new Lock[5];

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        int fork1 = philosopher;
        int fork2 = (philosopher + 1) % 5;
        locks[Math.min(fork1, fork2)].lock();
        locks[Math.max(fork1, fork2)].lock();
        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putLeftFork.run();
        putRightFork.run();
        locks[Math.min(fork1, fork2)].unlock();
        locks[Math.max(fork1, fork2)].unlock();
    }
}