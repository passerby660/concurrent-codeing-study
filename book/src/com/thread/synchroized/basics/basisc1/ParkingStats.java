package com.thread.synchroized.basics.basisc1;

/**
 * @author Admin
 * 提供三个私有变量和机动车驶入离开所需要的方法
 */
public class ParkingStats {
    private long numberCase;
    private long numberMotorcycles;
    private ParkingCash cash;

    public ParkingStats(ParkingCash cash) {
        numberCase = 0;
        numberMotorcycles = 0;
        this.cash = cash;
    }

    public void carComeIn(){
        numberCase++;
    }

    public void carGoOUt(){
        numberCase--;
        cash.vehiclePay();
    }

    public void motoComeIn(){
        numberMotorcycles++;
    }

    public void  motoGoOut(){
        numberMotorcycles--;
        cash.vehiclePay();
    }

    public long getNumberCase() {
        return numberCase;
    }

    public long getNumberMotorcycles() {
        return numberMotorcycles;
    }

    public ParkingCash getCash() {
        return cash;
    }
}
