package com.thread.synchroized.basics.basisc1;


/**
 * @author Admin
 * 方法同步,一个停车场的案例
 * 设置一个检测器:建立两个对象当一辆汽车或者一辆摩托车驶入或者驶出停车场时,
 *              一个对象用来存储当前停车场内停车数量
 *              一个用来现金流结果的对象
 */
public class Main {
    public static void main(String[] args) {
        ParkingCash cash = new ParkingCash();
        ParkingStats stats = new ParkingStats(cash);
        System.out.printf("Parking Simulator\n");
        int numberSensors = 2 * Runtime.getRuntime().availableProcessors();
        Thread[] threads = new Thread[numberSensors];
        for (int i = 0; i < numberSensors; i++) {
            Sensor sensor = new Sensor(stats);
            Thread thread = new Thread(sensor);
            thread.start();
            threads[i] = thread;
        }
        for (int i = 0; i < numberSensors; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Number of cars: %d \n",stats.getNumberCase());
        System.out.printf("Number of NumberMotorcycles: %d \n",stats.getNumberMotorcycles());
        cash.close();
    }
}
