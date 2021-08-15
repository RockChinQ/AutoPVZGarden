package main.process;

import main.boot.Game;

import java.awt.event.InputEvent;

public class ProcessCollectGold implements IProcess{
    public static int lineNum=0;
    public static boolean fromZero=false;
    @Override
    public void process(Game game) throws Exception {
        if (fromZero){
            for(int i=0;i<=lineNum;i++){
                int y=0;
                if (i==0){
                    y=177;
                }else if (i==1){
                    y=280;
                }else if (i==2){
                    y=375;
                }else {
                    y=477;
                }
                for (int j=30;j<770;j+=25){
                    game.robot.mouseMove(game.position.x+j,game.position.y+y);
                    game.robot.mousePress(InputEvent.BUTTON1_MASK);
                    Thread.sleep(3);
                    game.robot.mouseRelease(InputEvent.BUTTON1_MASK);
//            Thread.sleep(5);
                }
            }
        }else {
            int y = 0;
            if (lineNum == 0) {
                y = 177;
            } else if (lineNum == 1) {
                y = 280;
            } else if (lineNum == 2) {
                y = 375;
            } else {
                y = 477;
            }
            for (int i = 30; i < 770; i += 25) {
                game.robot.mouseMove(game.position.x + i, game.position.y + y);
                game.robot.mousePress(InputEvent.BUTTON1_MASK);
                Thread.sleep(3);
                game.robot.mouseRelease(InputEvent.BUTTON1_MASK);
//            Thread.sleep(5);
            }
        }
    }
}
