package Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class rules extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent e) {
        super.onGuildMessageReceived(e);
        if (e.getMessage().getContentRaw().equalsIgnoreCase(".rules")){
                EmbedBuilder eb = new EmbedBuilder();
                eb.setTitle("**The Rules Of Concealed**");
                eb.setDescription("You Can See Our Rules At <#864528533413429258>");
                eb.setColor(Color.RED);
                e.getChannel().sendMessage(eb.build()).queue();
                e.getMessage().delete().queue();
        }
    }
}
