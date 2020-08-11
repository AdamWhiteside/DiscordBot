package events;

import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GuildMessageReceived extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

/*
        Role r = new Role "dummy";

        if (event.getMember().getRoles().stream().filter(r -> r.getName().equalsIgnoreCase("dummy"))
                .findFirst().orElse(null) == "dummy") {
            event.getMessage().addReaction("🤢").queue();
        }
 */
    }


}
