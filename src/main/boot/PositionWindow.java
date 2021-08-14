package main.boot;

import javax.swing.*;
import java.util.Arrays;

public class PositionWindow extends JFrame {
    JButton init=new JButton("Init");
    JComboBox<String> processSelect=new JComboBox<>();
    JButton exec=new JButton("Exec!");
    public PositionWindow(){
        this.setBounds(300,300,300,300);
        this.setLayout(null);
        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        init.setBounds(20,20,120,30);
        init.addActionListener((e -> {
            try {
                if (GUIMain.game != null)
                    GUIMain.game.dispose();
                GUIMain.game = new Game(this.getLocation(), GUIMain.processMgr);
                init.setText("Game:" + this.getLocation().x + "," + this.getLocation().y);
            }catch (Exception e0){
                javax.swing.JOptionPane.showMessageDialog(null,"Err while init:\n"+ Arrays.toString(e0.getStackTrace()));
            }
        }));
        this.add(init);

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
            try {
                GUIMain.game.exec((String) processSelect.getSelectedItem());
            }catch (Exception e0){
                javax.swing.JOptionPane.showMessageDialog(null,"Err while exec:\n"+ Arrays.toString(e0.getStackTrace()));
            }
        }));
        this.add(exec);

        this.setVisible(true);
    }
}
