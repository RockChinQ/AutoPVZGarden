package main.process;

import main.boot.Game;

import java.awt.*;

public class ProcessSellAll implements IProcess{

    @Override
    public void process(Game game) throws Exception {
        System.out.println("Sell all");
        game.click(16,71);
        Point selBtn=new Point(342,64);
        for (int i=0;i<8;i++){
            System.out.println("First Line:"+i);
            Point p1=new Point(111+i*85,155);
            game.clickToNoWait(selBtn,p1);
            Game.sleep(200);
            game.click(427,459);
            Game.sleep(800);
        }
        for (int i=0;i<8;i++){
            System.out.println("Second Line:"+i);
            Point p1=new Point(105+i*85+(i>1?20:0),230);
            game.clickToNoWait(selBtn,p1);
            Game.sleep(200);
            game.click(427,459);
            Game.sleep(800);
        }
        for (int i=0;i<8;i++){
            System.out.println("Third Line:"+i);
            Point p1=new Point(83+i*85+(i>1?30:0),325);
            game.clickToNoWait(selBtn,p1);
            Game.sleep(200);
            game.click(427,459);
            Game.sleep(800);
        }
        for (int i=0;i<8;i++){
            System.out.println("Fourth Line:"+i);
            Point p1=new Point(75+i*85+(i>1?45:0),433);
            game.clickToNoWait(selBtn,p1);
            Game.sleep(200);
            game.click(427,459);
            Game.sleep(800);
        }
    }
}
