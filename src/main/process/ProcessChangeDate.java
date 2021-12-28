package main.process;

import main.boot.GUIMain;
import main.boot.Game;

public class ProcessChangeDate implements IProcess{
    @Override
    public void process(Game game) throws Exception {
        GUIMain.changeDate();
    }
}
