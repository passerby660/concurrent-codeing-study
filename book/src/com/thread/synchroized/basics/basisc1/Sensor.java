package com.thread.synchroized.basics.basisc1;

import java.util.concurrent.TimeUnit;

/**
 * @author Admin
 */
public class Sensor implements Runnable {
    private ParkingStats stats;

    public Sensor(ParkingStats stats) {
        this.stats = stats;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            stats.carComeIn();
            stats.carComeIn();
            try {
                TimeUnit.MICROSECONDS.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stats.motoComeIn();
            try {
                TimeUnit.MICROSECONDS.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stats.motoGoOut();
            stats.carGoOUt();
            stats.carGoOUt();
        }
    }
}
