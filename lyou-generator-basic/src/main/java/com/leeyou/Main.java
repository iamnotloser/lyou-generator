package com.leeyou;

import com.leeyou.cli.CommandExecutor;

public class Main {
    public static void main(String[] args) {

        CommandExecutor commandExecutor = new CommandExecutor();

        args = new String[]{"generate","-l","-a","-o"};
//        args = new String[]{"config"};
//        args = new String[]{"list"};
        commandExecutor.doExecute(args);
    }
}