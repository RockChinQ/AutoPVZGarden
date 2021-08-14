package main.process;

import main.boot.Game;

import java.awt.*;

public class ProcessWaterBlindly implements IProcess {

    @Override
    public void process(Game game) throws Exception {
        Point waterPot=new Point(68,80);
        for (int i=0;i<5;i++){
            System.out.println("First Line");
            game.clickTo(waterPot,new Point(149,195));
            Thread.sleep(200);
            game.clickTo(waterPot,new Point(320,190));
            Thread.sleep(200);
            game.clickTo(waterPot,new Point(497,190));
            Thread.sleep(200);
            game.clickTo(waterPot,new Point(658,190));
            Thread.sleep(200);

            ProcessCollectGold.lineNum=0;
            game.exec("collectGold");
            ProcessCollectGold.lineNum=1;
            game.exec("collectGold");

            System.out.println("Second Line");
            game.clickTo(waterPot,new Point(138,390));
            Thread.sleep(200);
            game.clickTo(waterPot,new Point(315,390));
            Thread.sleep(200);
            game.clickTo(waterPot,new Point(520,390));
            Thread.sleep(200);
            game.clickTo(waterPot,new Point(694,390));
            Thread.sleep(200);

            ProcessCollectGold.lineNum=2;
            game.exec("collectGold");
            ProcessCollectGold.lineNum=3;
            game.exec("collectGold");

            Thread.sleep(4000);
        }
    }
}
