package main.boot;

import java.util.TimerTask;

public class AddingTimer extends TimerTask {
    private static long time=0;

    public static long getTime() {
        return time*GUIMain.TIMER_DELAY;
    }

    @Override
    public void run() {
        time++;
    }
}
