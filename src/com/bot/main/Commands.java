package com.bot.main;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;


public class Commands extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split("\\s+");

        if (args[0].equalsIgnoreCase(Main.prefix + "test")) {

            commandClean(event);

            event.getChannel().sendMessage("Hello World").queue();
            //
            //
        } else if (args[0].equalsIgnoreCase(Main.prefix + "test1")) {
            if (args.length < 2) {
                //TODO error
            } else {
                EmbedBuilder info = new EmbedBuilder();
                String user = event.getMember().getUser().getName();

                try {
                    user = event.getMember().getNickname();
                } catch (NullPointerException caught) {
                }


                String newName = "kafloof";

                info.setTitle("Hark!");
                info.setDescription("Let it be heard that");
                info.addField(user, "shall henceforth be known as", false);
                info.setColor(0xf45642);
                info.setFooter(newName, event.getMember().getUser().getAvatarUrl());

                //member.setNickname(newName);
                commandClean(event);

                event.getChannel().sendMessage(info.build()).queue();
                info.clear();
            }

            //
            //
        } else if (args[0].equalsIgnoreCase(Main.prefix + "clear")) {
            if (args.length < 2) {
                //TODO error
            } else {
                int ab = Integer.parseInt(args[1]);
                if (ab > 99) {
                    ab = 99;
                }

                if(ab < 99){
                    ab++;
                }

                if (ab == 1) {
                    ab = 2;
                    event.getChannel().sendMessage("#").queue();
                }

                if (ab == 0) {
                    ab = 2;
                    event.getChannel().sendMessage("$").queue();
                    event.getChannel().sendMessage("%").queue();
                }

                List<Message> messages = event.getChannel().getHistory().retrievePast(ab).complete();
                event.getChannel().deleteMessages(messages).queue();
            }
        }
        //
        //
        else if (args[0].equalsIgnoreCase(Main.prefix + "help")) {

        }
    }

    public void commandClean(GuildMessageReceivedEvent event) {
        event.getChannel().sendMessage("_").queue();
        event.getChannel().deleteMessages(event.getChannel().getHistory().retrievePast(2).complete()).queue();
    }

}
