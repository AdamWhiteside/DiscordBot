package events;

import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GuildMessageReactionAdd extends ListenerAdapter {

    public void onGuildMessageReactionAdd(GuildMessageReactionAddEvent event) {

        if (!event.getMember().getUser().equals(event.getJDA().getSelfUser())) {
            if (event.getReactionEmote().getName().equals("🤢")) {
                event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRolesByName("DontStarver", true).get(0)).queue();
            } else if (event.getReactionEmote().getName().equals("🤳")) {
                event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRolesByName("MineCrafter", true).get(0)).queue();
            } else if (event.getReactionEmote().getName().equals("🙌")) {
                event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRolesByName("OverWatcher", true).get(0)).queue();
            }
        }
    }
}
