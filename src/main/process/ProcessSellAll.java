package main.process;

import main.boot.Game;

import java.awt.*;

public class ProcessSellAll implements IProcess{

    @Override
    public void process(Game game) throws Exception {
        System.out.println("Sell all");
        Point selBtn=new Point(280,70);
        for (int i=0;i<8;i++){
            System.out.println("First Line:"+i);
            Point p1=new Point(111+i*85,155);
            game.clickTo(selBtn,p1);
            Thread.sleep(500);
            game.click(427,459);
            Thread.sleep(1500);
        }
    }
}
