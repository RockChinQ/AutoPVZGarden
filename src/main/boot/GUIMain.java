package main.boot;

import main.process.*;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;

public class GUIMain {
    public static Game game;
    public static ProcessMgr processMgr=new ProcessMgr();
    public static Point setting;
    public static void main(String[] args) {
        processMgr.add("test",new ProcessTest());
        processMgr.add("buyFlowers",new ProcessBuyFlowers());
        processMgr.add("waterAllBlindly",new ProcessWaterBlindly());
        processMgr.add("buyFertilizer",new ProcessBuyFertilizer());
        processMgr.add("feedAllBlindly",new ProcessFeedAllBlindly());
        processMgr.add("sellAll", new ProcessSellAll());
        processMgr.add("collectGold", new ProcessCollectGold());
        processMgr.add("plantFlowers", new ProcessPlantFlowers());

        new PositionWindow();
    }
    public static int deltaDay=0;
    public static void changeDate(){
        game.robot.mouseMove(setting.x+400,setting.y+500);
        game.robot.mousePress(InputEvent.BUTTON1_MASK);
        try{
            Thread.sleep(10);
        }catch (Exception e){
            e.printStackTrace();
        }
        game.robot.mouseRelease(InputEvent.BUTTON1_MASK);

        try{
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Click day combo box");
        game.robot.mouseMove(setting.x+276,setting.y+233);
        game.robot.mousePress(InputEvent.BUTTON1_MASK);
        try{
            Thread.sleep(10);
        }catch (Exception e){
            e.printStackTrace();
        }
        game.robot.mouseRelease(InputEvent.BUTTON1_MASK);

        try{
            Thread.sleep(800);
        }catch (Exception e){
            e.printStackTrace();
        }
        if (deltaDay==0){

            System.out.println("Next day");
            game.robot.mouseMove(setting.x+270,setting.y+266);
            game.robot.mousePress(InputEvent.BUTTON1_MASK);
            try{
                Thread.sleep(10);
            }catch (Exception e){
                e.printStackTrace();
            }
            game.robot.mouseRelease(InputEvent.BUTTON1_MASK);
            deltaDay=1;
        }else {

            System.out.println("Previous day");
            game.robot.mouseMove(setting.x+276,setting.y+200);
            game.robot.mousePress(InputEvent.BUTTON1_MASK);
            try{
                Thread.sleep(10);
            }catch (Exception e){
                e.printStackTrace();
            }
            game.robot.mouseRelease(InputEvent.BUTTON1_MASK);
            deltaDay=0;
        }

        try{
            Thread.sleep(500);
        }catch (Exception e){
            e.printStackTrace();
        }
        game.robot.mouseMove(setting.x+430,setting.y+405);
        game.robot.mousePress(InputEvent.BUTTON1_MASK);
        try{
            Thread.sleep(10);
        }catch (Exception e){
            e.printStackTrace();
        }
        game.robot.mouseRelease(InputEvent.BUTTON1_MASK);

    }
    public static boolean fertilizer(Game game){

        Color c=new Color(0);
        BufferedImage image=game.screenShot(new Rectangle(134,60,10,10));
        int darkCount=0;
        for (int i=0;i<10;i++){
            for (int j=0;j<10;j++){
                if (new Color(image.getRGB(i,j)).getRed()<120){
                    darkCount++;
                }
            }
        }
        if (darkCount>70){
            System.out.println("No fertilizer:"+darkCount);
            return false;
        }else {
            System.out.println("Remains fertilizer"+darkCount);
            return true;
        }
    }

}
