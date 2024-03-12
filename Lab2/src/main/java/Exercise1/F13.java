package org.example;

public class F13 extends Thread{
    Integer monitor;
    int sleep_min, sleep_max, activity_min, activity_max;

    public F13(Integer monitor, int sleep_min, int sleep_max, int activity_min, int activity_max) {
        this.monitor = monitor;
        this.sleep_min = sleep_min;
        this.sleep_max = sleep_max;
        this.activity_min = activity_min;
        this.activity_max = activity_max;
    }
public void run()
{
    synchronized (monitor)
    {
        System.out.println(this.getName() + " - STATE 1");
        int k = (int) Math.round(Math.random()*(activity_max
                - activity_min) + activity_min);
        for (int i = 0; i < k * 100000; i++) {
            i++; i--;
        }
    }
    System.out.println(this.getName() + " - STATE 2");
    int k = (int) Math.round(Math.random()*(activity_max
            - activity_min) + activity_min);
    for (int i = 0; i < k * 100000; i++) {
        i++; i--;
    }
    try {
        sleep(sleep_min,sleep_max);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
    System.out.println(this.getName() + " - STATE 3");
}
}

