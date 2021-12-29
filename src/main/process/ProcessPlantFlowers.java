package main.process;

import main.boot.GUIMain;
import main.boot.Game;

public class ProcessPlantFlowers implements IProcess{

    @Override
    public void process(Game game) throws Exception {
        Game.sleep(2000);
        game.click(280,280);
        game.exec("buyFlowers");
        Game.sleep(500);
        //first round
        game.exec("waterAllBlindly");
        Game.sleep(500);
        game.exec("feedAllBlindly");
        Game.sleep(500);
        GUIMain.changeDate();
        Game.sleep(500);
        //second round
        game.exec("waterAllBlindly");
        Game.sleep(500);
        game.exec("feedAllBlindly");
        Game.sleep(500);
        GUIMain.changeDate();
        Game.sleep(500);
        //third round
        game.exec("waterAllBlindly");
        Game.sleep(500);
        game.exec("feedAllBlindly");
        Game.sleep(500);

        game.exec("sellAll");
    }
}
