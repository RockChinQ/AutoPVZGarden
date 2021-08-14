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
        Thread.sleep(1000);
        Point selBtn=new Point(137,64);

        ProcessCollectGold.lineNum=0;
        for (int i=0;i<8;i++){
            System.out.println("First Line:"+i);
            checkFertilizer(game);
            Point p1=new Point(111+i*85,155);
            game.clickTo(selBtn,p1);
            Thread.sleep(600);
        }
        game.exec("collectGold");

        ProcessCollectGold.lineNum=1;
        for (int i=0;i<8;i++){
            System.out.println("Second Line:"+i);
            checkFertilizer(game);
            Point p1=new Point(105+i*85+(i>1?20:0),230);
            game.clickTo(selBtn,p1);
            Thread.sleep(600);
        }
        game.exec("collectGold");

        ProcessCollectGold.lineNum=2;
        for (int i=0;i<8;i++){
            System.out.println("Third Line:"+i);
            checkFertilizer(game);
            Point p1=new Point(83+i*85+(i>1?30:0),325);
            game.clickTo(selBtn,p1);
            Thread.sleep(600);
        }
        game.exec("collectGold");

        ProcessCollectGold.lineNum=3;
        for (int i=0;i<8;i++){
            System.out.println("Fourth Line:"+i);
            checkFertilizer(game);
            Point p1=new Point(75+i*85+(i>1?45:0),433);
            game.clickTo(selBtn,p1);
            Thread.sleep(600);
        }
        game.exec("collectGold");
    }
    public void checkFertilizer(Game game)throws Exception{
        if (!GUIMain.fertilizer(game)){
            Thread.sleep(700);
            game.exec("collectGold");
            game.exec("buyFertilizer");
        }
    }
}
