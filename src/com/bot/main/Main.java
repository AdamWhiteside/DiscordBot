package com.bot.main;

import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class Main {
    public static JDA jda;
    public static String prefix = "`";

    public static void main(String[] args) throws LoginException {
        jda = new JDABuilder(AccountType.BOT).setToken("NzM4MTMzNDg1NTExNzcwMTMz.XyHeYA.jgxa_5KXI3yAl9PX6BQQ-G-EQfI").build();

        jda.addEventListener(new Commands());
    }

}
