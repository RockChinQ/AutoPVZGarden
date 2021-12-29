package main.process;

import main.boot.GUIMain;
import main.boot.Game;

import java.awt.*;
import java.awt.event.InputEvent;

public class ProcessFeedAllBlindly implements IProcess{

    @Override
    public void process(Game game) throws Exception {

        System.out.println("Feed all");
        game.robot.mouseRelease(InputEvent.BUTTON1_MASK);
        Game.sleep(1000);
        Point selBtn=new Point(137,64);

        ProcessCollectGold.lineNum=0;
        for (int i=0;i<8;i++){
            System.out.println("First Line:"+i);
            checkFertilizer(game);
            Point p1=new Point(150+i*80,120);
            game.clickTo(selBtn,p1);
            Game.sleep(50);
            if (i==1){
                Game.sleep(1000);
            }
        }
//        game.exec("collectGold");

        ProcessCollectGold.lineNum=1;
        for (int i=0;i<8;i++){
            System.out.println("Second Line:"+i);
            checkFertilizer(game);
            Point p1=new Point(150+i*80+(i>3?25:0),220);
            game.clickTo(selBtn,p1);
            Game.sleep(30);
        }
//        game.exec("collectGold");

        ProcessCollectGold.lineNum=2;
        for (int i=0;i<8;i++){
            System.out.println("Third Line:"+i);
            checkFertilizer(game);
            Point p1=new Point(110+i*90+(i>3?20:0),314);
            game.clickTo(selBtn,p1);
            Game.sleep(30);
        }
//        game.exec("collectGold");

        ProcessCollectGold.lineNum=3;
        for (int i=0;i<8;i++){
            System.out.println("Fourth Line:"+i);
            checkFertilizer(game);
            Point p1=new Point(105+i*90+(i>3?34:0),420);
            game.clickTo(selBtn,p1);
            Game.sleep(30);
        }
        Game.sleep(700);

        ProcessCollectGold.lineNum=0;
        game.exec("collectGold");
        ProcessCollectGold.lineNum=1;
        game.exec("collectGold");
        ProcessCollectGold.lineNum=2;
        game.exec("collectGold");
        ProcessCollectGold.lineNum=3;
        game.exec("collectGold");
//        game.exec("collectGold");
    }
    public void checkFertilizer(Game game)throws Exception{
        if (!GUIMain.fertilizer(game)){
            Game.sleep(1400);
            ProcessCollectGold.fromZero=true;
            game.exec("collectGold");
            ProcessCollectGold.fromZero=false;
            game.exec("buyFertilizer");
        }
    }
}
