package Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class lag extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent e) {
        super.onGuildMessageReceived(e);
        if (e.getMessage().getContentRaw().equalsIgnoreCase(".lag")){
            EmbedBuilder eb = new EmbedBuilder();
            eb.setTitle("**Server Or Client Lag?**");
            eb.setDescription("**Common reasons for Server Lag(Most Of These Problems Are Handle By Us):**\n" +
                    "- Not Enough RAM\n" +
                    "- Errors are spamming in your console.\n" +
                    "**Common reasons for Client Lag(This Is What You Must Worry):**\n" +
                    "- You're Too Far From The Server(The Server Is Host In Germany)\n" +
                    "- Bad Internet/High Ping\n" +
                    "- Your Device Can't Handle/Low FPS(Frames Per Second)\n" +
                    "   Do .fps For Tips To Make Your Device Run Minecraft Smoother For **Free**!!!\n");
            eb.setColor(Color.RED);
            e.getChannel().sendMessage(eb.build()).queue();
            e.getMessage().delete().queue();
        }
    }
}
