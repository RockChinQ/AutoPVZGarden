package main.boot;

import java.awt.*;
import java.awt.event.InputEvent;

public class Game {
    Point position;
    ProcessMgr processMgr;
    public Robot robot;
    public Game(Point position,ProcessMgr processMgr)throws Exception{
        this.position=position;
        this.processMgr=processMgr;
        this.robot=new Robot();
    }

    public void exec(String name)throws Exception{
        this.processMgr.get(name).process(this);
    }

    public void dispose(){

    }



    public void click(int x,int y){
        robot.mouseMove(this.position.x+x,this.position.y+y);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        try{
            Thread.sleep(10);
        }catch (Exception e){
            e.printStackTrace();
        }
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }
    public void clickTo(Point p0,Point p1){
        click(p0.x,p0.y);
        click(p1.x,p1.y);
    }
}
