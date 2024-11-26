package com.example;

public class CommandManager {

    

    private static CommandManager instance;

    private  CommandManager(){
        
    }


    public static CommandManager getInstance() {
        if (instance == null) {
            instance = new CommandManager();
        }
        return instance;
    }


}
