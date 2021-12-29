package main.boot;

import javax.swing.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class PositionWindow extends JFrame {
    JButton init=new JButton("Init"),timeWin=new JButton("timeWin");
    JComboBox<String> processSelect=new JComboBox<>();
    JButton exec=new JButton("Exec!");
    JButton emergence =new JButton("Emergence Stop");
    JButton pause =new JButton("Pause");
    Thread gameThr=new Thread();
    public PositionWindow(){
        this.setBounds(300,300,300,300);
        this.setLayout(null);
        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent e) {
                setTitle(getWidth()+","+getHeight());
            }

            @Override
            public void componentMoved(ComponentEvent e) {

            }

            @Override
            public void componentShown(ComponentEvent e) {

            }

            @Override
            public void componentHidden(ComponentEvent e) {

            }
        });

        init.setBounds(20,20,120,30);
        init.addActionListener((e -> {
            try {
                if (GUIMain.game != null)
                    GUIMain.game.dispose();
                if (GUIMain.setting==null){
                    throw new Exception("time setting window is null");
                }
                GUIMain.game = new Game(this.getLocation(), GUIMain.processMgr);
                init.setText("Game:" + this.getLocation().x + "," + this.getLocation().y);
            }catch (Exception e0){
//                javax.swing.JOptionPane.showMessageDialog(null,"Err while init:\n"+ Arrays.toString(e0.getStackTrace()));
                e0.printStackTrace();
            }
        }));
        this.add(init);

        timeWin.setBounds(150,20,120,30);
        timeWin.addActionListener((e -> {
            GUIMain.setting=this.getLocation();
            timeWin.setText("timeWin:"+GUIMain.setting.x+","+GUIMain.setting.y);
        }));
        this.add(timeWin);

        for (String name:GUIMain.processMgr.processMap.keySet()){
            processSelect.addItem(name);
        }
        processSelect.setBounds(20,60,120,30);
        this.add(processSelect);

        exec.setBounds(150,60,70,30);
        exec.addActionListener((e -> {
            if (GUIMain.game==null){
                javax.swing.JOptionPane.showMessageDialog(null,"no game obj is initialized.");
                return;
            }
            this.gameThr=new Thread(()->{
                try {
                    GUIMain.game.exec((String) processSelect.getSelectedItem());
                }catch (Exception e0){
//                javax.swing.JOptionPane.showMessageDialog(null,"Err while exec:\n"+ Arrays.toString(e0.getStackTrace()));
                    e0.printStackTrace();
                }
            });
            this.gameThr.start();
        }));
        this.add(exec);

        emergence.setBounds(20,100,170,30);
        emergence.addActionListener((e)->{
            System.out.println("Emergence!");
            this.gameThr.stop();
            System.out.println("Stopped.");
        });
        this.add(emergence);

        pause.setBounds(20,140,170,30);
        pause.addActionListener((e)->{
            if (!Game.pause){
                Game.pause=true;
                Game.paused=false;
            }else {
                if (Game.paused){
                    synchronized (Game.pauseLock){
                        Game.pauseLock.notify();
                    }
                }
            }
        });
        this.add(pause);

        this.setVisible(true);
    }
}
