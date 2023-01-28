package com.thread.synchroized.basics.basisc1;

/**
 * @author Admin
 * 方法同步
 */
public class ParkingCash {
    private static final int cost = 2;
    private long cash;

    public ParkingCash() {
        this.cash = 0;
    }

    /**
     * 当有车离开停车场时费用增加
     */
    public void vehiclePay(){
        cash += cost;
    }

    public void close(){
        System.out.printf("closing accounting");
        long totalAmmount;
        totalAmmount = cash;
        cash = 0;
        System.out.printf("The total amount is : %d\n",totalAmmount);
    }
}
