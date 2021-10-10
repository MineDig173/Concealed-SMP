package Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class ip extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent e) {
        super.onGuildMessageReceived(e);
        if (e.getMessage().getContentRaw().equalsIgnoreCase(".ip")){
            EmbedBuilder eb = new EmbedBuilder();
            eb.setTitle("IP & Port For Concealed SMP**");
            eb.setDescription("The IP Is **concsmp.mc-crafters.com** & The Port Is **35745**");
            eb.setColor(Color.RED);
            e.getChannel().sendMessage(eb.build()).queue();
            e.getMessage().delete().queue();
        }
    }
}
