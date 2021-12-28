package main.boot;

import java.util.TimerTask;

public class AddingTimer extends TimerTask {
    private long time=0;

    public long getTime() {
        return time;
    }

    @Override
    public void run() {
        time++;
    }
}
