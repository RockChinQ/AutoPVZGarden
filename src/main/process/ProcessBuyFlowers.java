package main.process;

import main.boot.GUIMain;
import main.boot.Game;

public class ProcessBuyFlowers implements IProcess{

    @Override
    public void process(Game game) throws Exception {
        game.click(771,94);
        Game.sleep(2000);
        for (int i=0;i<12;i++){

            //first
            game.click(468,286);
            Game.sleep(300);
            game.click(333,401);
            Game.sleep(100);
            //second
            game.click(545,286);
            Game.sleep(300);
            game.click(333,401);
            Game.sleep(100);
            //third
            game.click(600,286);
            Game.sleep(300);
            game.click(333,401);
            Game.sleep(100);

            GUIMain.changeDate();
            Game.sleep(400);
        }
        game.click(441,582);
    }
}
