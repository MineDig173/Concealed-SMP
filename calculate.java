package Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class calculate extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent e) {
        super.onGuildMessageReceived(e);
        if (!e.getAuthor().isBot()){
            String[] msg = e.getMessage().getContentRaw().split(" ");

            if (msg[0].equalsIgnoreCase(".calculate") && msg.length == 1){
                EmbedBuilder eb = new EmbedBuilder();
                eb.setTitle("**How To Use .calculate**");
                eb.setDescription(".calculate [add/sub/times/divide] [num1] [num2]");
                eb.setColor(Color.RED);
                e.getChannel().sendMessage(eb.build()).queue();
                e.getMessage().delete().queue();
            }else if(msg[0].equalsIgnoreCase(".calculate") && msg[1].equalsIgnoreCase("add")){
                int num1 = Integer.parseInt(msg[2]);
                int num2 = Integer.parseInt(msg[3]);
                EmbedBuilder eb = new EmbedBuilder();
                eb.setTitle("**Here's Your Answer, **" + e.getAuthor().getName());
                eb.setDescription("**" + (num1 + num2) + "**");
                eb.setColor(Color.GREEN);
                e.getChannel().sendMessage(eb.build()).queue();
                e.getMessage().delete().queue();
            }else if(msg[0].equalsIgnoreCase(".calculate") && msg[1].equalsIgnoreCase("sub")){
                int num1 = Integer.parseInt(msg[2]);
                int num2 = Integer.parseInt(msg[3]);
                EmbedBuilder eb = new EmbedBuilder();
                eb.setTitle("**Here's Your Answer, **" + e.getAuthor().getName());
                eb.setDescription("**" + (num1 - num2) + "**");
                eb.setColor(Color.GREEN);
                e.getChannel().sendMessage(eb.build()).queue();
                e.getMessage().delete().queue();
            }else if (msg[0].equalsIgnoreCase(".calculate") && msg[1].equalsIgnoreCase("times")) {
                EmbedBuilder eb = new EmbedBuilder();
                int num1 = Integer.parseInt(msg[2]);
                int num2 = Integer.parseInt(msg[3]);
                eb.setTitle("**Here's Your Answer, **" + e.getAuthor().getName());
                eb.setDescription("**" + (num1 * num2) + "**");
                eb.setColor(Color.GREEN);
                e.getChannel().sendMessage(eb.build()).queue();
                e.getMessage().delete().queue();
            }else if (msg[0].equalsIgnoreCase(".calculate") && msg[1].equalsIgnoreCase("divide")) {
                EmbedBuilder eb = new EmbedBuilder();
                int num1 = Integer.parseInt(msg[2]);
                int num2 = Integer.parseInt(msg[3]);
                eb.setTitle("**Here's Your Answer, **" + e.getAuthor().getName());
                eb.setDescription("**" + (num1 / num2) + "**");
                eb.setColor(Color.GREEN);
                e.getChannel().sendMessage(eb.build()).queue();
                e.getMessage().delete().queue();
            }
        }

    }
}
