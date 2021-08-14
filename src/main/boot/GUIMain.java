package main.boot;

import main.process.IProcess;
import main.process.ProcessSellAll;

public class GUIMain {
    public static Game game;
    public static ProcessMgr processMgr=new ProcessMgr();
    public static void main(String[] args) {
        processMgr.add("sellAll", new ProcessSellAll());

        new PositionWindow();
    }
}
