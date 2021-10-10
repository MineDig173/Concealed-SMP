package Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class fps extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent e) {
        super.onGuildMessageReceived(e);
        if (e.getMessage().getContentRaw().equalsIgnoreCase(".fps")){
            EmbedBuilder eb = new EmbedBuilder();
            eb.setTitle("**How To Have Better FPS(Boost) In Minecraft For Free**");
            eb.setDescription("**In Game**\n" +
                    "- Go To Video Settings And Set Everything To The Lowest Possible Option.\n" +
                    "**Through Clients**\n" +
                    "We Allowed Clients In Our Server, Here's Some Clients You Can Use:\n" +
                    "- Badlion(Premium)\n" +
                    "- Lunar(Premium)\n" +
                    "- Salwyrr(Cracked)[Currently Not Available For 1.17.1\n" +
                    "**Through Mods**\n" +
                    "You Can Use Client Side Mods In The Server. Here's Some For Forge & Fabric:\n" +
                    "**Forge:**\n" +
                    "- Optifine\n" +
                    "**Fabric:**\n" +
                    "- Sodium\n" +
                    "- Lithium\n" +
                    "- FerritCore\n" +
                    "- Optifabric(You Need Optifine To Work)\n" +
                    "**Premium Ways**\n" +
                    "-Buy A Good PC :)");
            eb.setColor(Color.RED);
            e.getChannel().sendMessage(eb.build()).queue();
            e.getMessage().delete().queue();
        }
    }
}
