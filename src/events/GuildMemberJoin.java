package events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Invite;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;

import java.awt.*;
import java.util.Random;

public class GuildMemberJoin extends ListenerAdapter {

    String[] messages = {
            "[member] abc",
            "[member] def",
            "abc [member]",
            "def [member]"
    };

    public void onGuildMemberJoin(GuildMemberJoinEvent event) {

        Random rand = new Random();
        int number = rand.nextInt(messages.length);
        Color col = new Color((int) (Math.random() * 0x1000000));

        EmbedBuilder join = new EmbedBuilder();
        join.setColor(col);
        join.setDescription(messages[number].replace("[member]", event.getMember().getAsMention()));

        event.getGuild().getDefaultChannel().sendMessage(join.build()).queue();

    }
}
