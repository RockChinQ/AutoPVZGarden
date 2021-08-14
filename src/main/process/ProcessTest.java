package main.process;

import main.boot.GUIMain;
import main.boot.Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ProcessTest implements IProcess{

    @Override
    public void process(Game game) throws Exception {
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
            System.out.println("No fertilizer");
        }else {
            System.out.println("Has fertilizer");
        }
    }
}
