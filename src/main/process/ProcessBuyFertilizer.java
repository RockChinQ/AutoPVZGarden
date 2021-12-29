package main.process;

import main.boot.Game;

public class ProcessBuyFertilizer implements IProcess{

    @Override
    public void process(Game game) throws Exception {

        game.click(771,94);
        Game.sleep(1500);
        for (int i=0;i<4;i++){
            System.out.println("Buying fertilizer:"+i);
            game.click(400,378);
            Game.sleep(300);
            game.click(311,422);
            Game.sleep(300);
        }
        game.click(441,582);
    }
}
