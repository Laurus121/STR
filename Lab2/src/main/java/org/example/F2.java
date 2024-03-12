package org.example;
public class F2 extends Thread{
    Integer monitor1,monitor2;
    int sleep_min, sleep_max, activity_min, activity_max;

    public F2(Integer monitor1, Integer monitor2, int sleep_min, int sleep_max, int activity_min, int activity_max) {
        this.monitor1 = monitor1;
        this.monitor2 = monitor2;
        this.sleep_min = sleep_min;
        this.sleep_max = sleep_max;
        this.activity_min = activity_min;
        this.activity_max = activity_max;
    }
    public void run()
    {
        synchronized (monitor1)
        {
            synchronized (monitor2)
            {
            System.out.println(this.getName() + " - STATE 1");
            int k = (int) Math.round(Math.random()*(activity_max
                    - activity_min) + activity_min);
            for (int i = 0; i < k * 100000; i++) {
                i++; i--;
            }
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


