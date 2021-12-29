package main.boot;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.util.Date;

public class Game {
    public Point position;
    ProcessMgr processMgr;
    public Robot robot;
    public Game(Point position,ProcessMgr processMgr)throws Exception{
        this.position=position;
        this.processMgr=processMgr;
        this.robot=new Robot();
    }

    public void exec(String name)throws Exception{
        long now=new Date().getTime();
        System.out.println("EEEEEEEExecuting:"+name+";");
        this.processMgr.get(name).process(this);
        System.out.println("EEEEEEEEEExecuted:"+name+" spent:"+(new Date().getTime()-now)+"ms");
    }

    public void dispose(){

    }



    public void click(int x,int y){
        robot.mouseMove(this.position.x+x,this.position.y+y);
        try{
            Thread.sleep(20);
        }catch (Exception e){
            e.printStackTrace();
        }
        robot.mousePress(InputEvent.BUTTON1_MASK);
        try{
            Thread.sleep(40);
        }catch (Exception e){
            e.printStackTrace();
        }
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }
    public void clickTo(Point p0,Point p1){
        click(p0.x,p0.y);
        robot.mouseMove(this.position.x+p1.x,this.position.y+p1.y);
        try {
            Thread.sleep(300);
        }catch (Exception e){
            e.printStackTrace();
        }
        click(p1.x,p1.y);
    }
    public void clickToNoWait(Point p0,Point p1){

        click(p0.x,p0.y);
        try {
            Thread.sleep(30);
        }catch (Exception e){
            e.printStackTrace();
        }
        click(p1.x,p1.y);
    }

    public BufferedImage screenShot(Rectangle rect){
        rect.x+=this.position.x;
        rect.y+=this.position.y;
        return robot.createScreenCapture(rect);
    }

    public static boolean pause=false,paused=false;
    public static final Boolean pauseLock=false;
    public static void sleep(long mills)throws Exception{
        if (pause){
            synchronized (pauseLock){
                try {
                    paused=true;
                    GUIMain.positionWindow.pause.setText("Resume");
                    pauseLock.wait();
                    GUIMain.positionWindow.pause.setText("Pause");
                    pause=false;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        Thread.sleep(mills);
    }
}
