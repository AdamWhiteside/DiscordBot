package events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberLeaveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.util.Random;

public class GuildMemberLeave extends ListenerAdapter {

    String[] messages = {
            "[member] left"
    };

    public void onGuildMemberLeave(GuildMemberLeaveEvent event) {

        Random rand = new Random();
        int number = rand.nextInt(messages.length);
        Color col = new Color((int) (Math.random() * 0x1000000));

        EmbedBuilder join = new EmbedBuilder();
        join.setColor(col);
        join.setDescription(messages[number].replace("[member]", event.getMember().getAsMention()));

        event.getGuild().getDefaultChannel().sendMessage(join.build()).queue();

    }
}