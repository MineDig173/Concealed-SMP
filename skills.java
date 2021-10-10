package Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class skills extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent e) {
        super.onGuildMessageReceived(e);
        if (e.getMessage().getContentRaw().equalsIgnoreCase(".skills")){
            EmbedBuilder eb = new EmbedBuilder();
            eb.setTitle("**Concealed's Skills And Abilities**");
            eb.setDescription("You Can See About Skills & Abilties At <#895855597747060747> Or \n Experience It In-Game!");
            eb.setColor(Color.red);
            e.getChannel().sendMessage(eb.build()).queue();
            e.getMessage().delete().queue();
        }
    }
}
