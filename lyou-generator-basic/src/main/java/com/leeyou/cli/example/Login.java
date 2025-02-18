package com.leeyou.cli.example;

import picocli.CommandLine;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.concurrent.Callable;

class Login implements Callable<Integer> {
    @CommandLine.Option(names = {"-u", "--user"}, description = "User name")
    String user;

    @CommandLine.Option(names = {"-p", "--password"}, arity="0..1",description = "Passphrase", interactive = true)
    String password;

    public Integer call() throws Exception {
        System.out.println("password = " + password);

        return 0;
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new Login()).execute("-u","user123","-p");
    }


}