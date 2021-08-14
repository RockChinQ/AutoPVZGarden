package main.process;

import main.boot.GUIMain;
import main.boot.Game;

public class ProcessPlantFlowers implements IProcess{

    @Override
    public void process(Game game) throws Exception {
        Thread.sleep(2000);
        game.click(280,280);
        game.exec("buyFlowers");
        Thread.sleep(500);
        //first round
        game.exec("waterAllBlindly");
        Thread.sleep(500);
        game.exec("feedAllBlindly");
        Thread.sleep(500);
        GUIMain.changeDate();
        Thread.sleep(500);
        //second round
        game.exec("waterAllBlindly");
        Thread.sleep(500);
        game.exec("feedAllBlindly");
        Thread.sleep(500);
        GUIMain.changeDate();
        Thread.sleep(500);
        //third round
        game.exec("waterAllBlindly");
        Thread.sleep(500);
        game.exec("feedAllBlindly");
        Thread.sleep(500);

        game.exec("sellAll");
    }
}
