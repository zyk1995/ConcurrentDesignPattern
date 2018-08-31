package com.zyk.Future;

public class FutureData implements Data {
    private RealData readlData = null;
    private boolean ready = false;

    public synchronized void setReadlData(RealData readlData){
        if (ready) {
            return;
        }
        this.readlData = readlData;
        this.ready = true;
        notifyAll();
    }

    public synchronized String getContent() {
        while (!ready) {
            try {
                wait();
            }catch (InterruptedException e) {

            }
        }
        return readlData.getContent();
    }
}
