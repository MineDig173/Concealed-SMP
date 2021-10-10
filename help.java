package Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class help extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent e) {
        super.onGuildMessageReceived(e);
        if (e.getMessage().getContentRaw().equalsIgnoreCase(".help")){
            EmbedBuilder eb = new EmbedBuilder();
            eb.setTitle("**Available Commands(.)**");
            eb.setDescription("""
                        `-help`\s
                            `Shows All Available Commands`\s
                        `-calculate`\s
                            `Do Simple Calculations`\s
                        `-rules`
                          `Shows Where Our Rules Can Be Seen`
                        `-ip`
                          `Shows You The IP & Port Of The Server`
                        `-skills`
                          `Shows Where Can You Learn About The Skills, Abilities, etc`
                        `-lag`
                          `Shows The Causes Of Lag`
                        `-fps`
                          `Shows The Ways Of Getting More FPS`
                        """);
            eb.setColor(Color.RED);
            e.getChannel().sendMessage(eb.build()).queue();
            e.getMessage().delete().queue();
        }
    }
}
