package main.boot;

import main.process.IProcess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProcessMgr {
    public Map<String, IProcess> processMap=new HashMap<>();
    public void add(String name,IProcess process){
        processMap.put(name,process);
    }
    public IProcess get(String name){
        return processMap.get(name);
    }
}
