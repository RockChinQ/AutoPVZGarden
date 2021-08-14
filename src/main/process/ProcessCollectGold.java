package main.process;

import main.boot.Game;

public class ProcessCollectGold implements IProcess{
    public static int lineNum=0;
    @Override
    public void process(Game game) throws Exception {
        int y=0;
        if (lineNum==0){
            y=177;
        }else if (lineNum==1){
            y=280;
        }else if (lineNum==2){
            y=375;
        }else {
            y=477;
        }
        for (int i=30;i<770;i+=25){
            game.click(i,y);
//            Thread.sleep(5);
        }
    }
}
