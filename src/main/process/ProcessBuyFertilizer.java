package main.process;

import main.boot.Game;

public class ProcessBuyFertilizer implements IProcess{

    @Override
    public void process(Game game) throws Exception {

        game.click(771,94);
        Thread.sleep(1500);
        for (int i=0;i<4;i++){
            System.out.println("Buying fertilizer:"+i);
            game.click(400,378);
            Thread.sleep(300);
            game.click(311,393);
            Thread.sleep(300);
        }
        game.click(441,582);
    }
}
