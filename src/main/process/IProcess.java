package main.process;

import main.boot.Game;

public interface IProcess {
    void process(Game game)throws Exception;
}
