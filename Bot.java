
import Commands.*;
import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

public class Bot {
    public static void main(String[] args) throws Exception{
            JDA jda = JDABuilder.createDefault("token").build();
            jda.getPresence().setActivity(Activity.playing("Minecraft & .help"));

        jda.addEventListener(new calculate());
        jda.addEventListener(new rules());
        jda.addEventListener(new ip());
        jda.addEventListener(new skills());
        jda.addEventListener(new skills());
        jda.addEventListener(new lag());
        jda.addEventListener(new fps());
        jda.addEventListener(new help());



    }
}
