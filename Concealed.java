package concealed.concealed;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.*;

public final class Concealed extends JavaPlugin {
    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new Listeners(), this);
        Bukkit.getLogger().info(ChatColor.RED + "" + ChatColor.BOLD + "[Concealed]: " + ChatColor.YELLOW + "Concealed Successfully " + ChatColor.GREEN + ChatColor.BOLD + "Enabled" + ChatColor.YELLOW + "!!!");
        Bukkit.getLogger().info(ChatColor.RED + "" + ChatColor.BOLD + "[Concealed]" + ChatColor.YELLOW + "You Cannot Distribute This Plugin To Other People Without Permission By MineDig173!!!");
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (command.getName().equalsIgnoreCase("die")) {
            if (sender instanceof Player p) {
                p.setHealth(0);
                p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "[CONCEALED]>> " + ChatColor.YELLOW + "So, You Have Chosen..." + ChatColor.RED + ChatColor.BOLD + "DEATH!!!");
            }
        } else if (command.getName().equalsIgnoreCase("sethome")) {
            if (sender instanceof Player p) {
                Bukkit.dispatchCommand(Bukkit.getPlayerExact(p.getDisplayName()), "trigger sethome");
                p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "[CONCEALED]>> " + ChatColor.YELLOW + "You Have Set Your Home!");
            } else {
                Bukkit.getLogger().info(ChatColor.RED + "" + ChatColor.BOLD + "[CONCEALED]>> " + ChatColor.YELLOW + "A Player Is Required To Run This Command!");
            }
        } else if (command.getName().equalsIgnoreCase("home")) {
            if (sender instanceof Player p) {
                Bukkit.dispatchCommand(Bukkit.getPlayerExact(p.getDisplayName()), "trigger home");
                p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "[CONCEALED]>> " + ChatColor.YELLOW + "Welcome Home, " + ChatColor.GREEN + p.getDisplayName() + ChatColor.YELLOW + "!");
            } else {
                Bukkit.getLogger().info(ChatColor.RED + "" + ChatColor.BOLD + "[CONCEALED]>> " + ChatColor.YELLOW + "A Player Is Required To Run This Command!");
            }
        } else if (command.getName().equalsIgnoreCase("grave")) {
            if (sender instanceof Player p) {
                Bukkit.dispatchCommand(Bukkit.getPlayerExact(p.getDisplayName()), "trigger grave");
                p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "[CONCEALED]>> " + ChatColor.YELLOW + "So This Is Where You Die, " + ChatColor.GREEN + p.getDisplayName() + ChatColor.YELLOW + "?");
            } else {
                Bukkit.getLogger().info(ChatColor.RED + "" + ChatColor.BOLD + "[CONCEALED]>>> " + ChatColor.YELLOW + "A Player Is Required To Run This Command!");
            }
        } else if (command.getName().equalsIgnoreCase("info")) {
            if (sender instanceof Player p) {
                if (args.length == 0) {
                    p.sendMessage(ChatColor.RED + "" + "Name: " + ChatColor.BLUE + ChatColor.BOLD + p.getDisplayName());
                    p.sendMessage(ChatColor.RED + "Health: " + ChatColor.BLUE + ChatColor.BOLD + p.getHealth());
                    p.sendMessage(ChatColor.RED + "Level: " + ChatColor.BLUE + ChatColor.BOLD + p.getLevel());
                    p.sendMessage(ChatColor.RED + "Ping: " + ChatColor.BLUE + ChatColor.BOLD + p.getPing());
                } else {
                    Player t = Bukkit.getPlayerExact(args[0]);
                    p.sendMessage(ChatColor.RED + "" + "Name: " + ChatColor.BLUE + ChatColor.BOLD + t.getDisplayName());
                    p.sendMessage(ChatColor.RED + "Health: " + ChatColor.BLUE + ChatColor.BOLD + t.getHealth());
                    p.sendMessage(ChatColor.RED + "Level: " + ChatColor.BLUE + ChatColor.BOLD + t.getLevel());
                    p.sendMessage(ChatColor.RED + "Ping: " + ChatColor.BLUE + ChatColor.BOLD + t.getPing());
                }
            } else if (sender instanceof ConsoleCommandSender) {
                if (args.length == 0) {
                    Bukkit.getLogger().info(ChatColor.RED + "" + ChatColor.BOLD + "[CONCEALED]>>> " + ChatColor.YELLOW + "A Player Is Needed To Execute This Command!");
                } else {
                    Player t = Bukkit.getPlayerExact(args[0]);
                    Bukkit.getLogger().info(ChatColor.RED + "" + "Name: " + ChatColor.BLUE + ChatColor.BOLD + t.getDisplayName());
                    Bukkit.getLogger().info(ChatColor.RED + "Health: " + ChatColor.BLUE + ChatColor.BOLD + t.getHealth());
                    Bukkit.getLogger().info(ChatColor.RED + "Level: " + ChatColor.BLUE + ChatColor.BOLD + t.getLevel());
                    Bukkit.getLogger().info(ChatColor.RED + "Ping: " + ChatColor.BLUE + ChatColor.BOLD + t.getPing());
                }
            }

        }else if (command.getName().equalsIgnoreCase("cords")){
            if (sender instanceof Player p){
                Bukkit.dispatchCommand(Bukkit.getPlayerExact(p.getDisplayName()), "trigger ch_toggle");

            }
        }else if (command.getName().equalsIgnoreCase("concealed help")){
            if (sender instanceof Player p){
                Inventory gui = Bukkit.createInventory(p, 18, ChatColor.YELLOW+"Useful Menu");
                ItemStack i1 = new ItemStack(Material.BEACON);
                ItemStack i2 = new ItemStack(Material.DARK_OAK_DOOR);
                ItemStack i3 = new ItemStack(Material.STONE_BRICK_WALL);
                ItemStack i4 = new ItemStack(Material.COMPASS);
                ItemStack i5 = new ItemStack(Material.ENDER_PEARL);
                ItemStack i6 = new ItemStack(Material.GRASS_BLOCK);
                ItemStack i7 = new ItemStack(Material.NETHERRACK);

                ItemMeta i1_meta = i1.getItemMeta();
                i1_meta.setDisplayName(ChatColor.AQUA+"/sethome");
                ArrayList<String> i1_lore = new ArrayList<>();
                i1_lore.add(ChatColor.YELLOW+"Set Your Home");
                i1_meta.setLore(i1_lore);
                i1.setItemMeta(i1_meta);

                ItemMeta i2_meta = i2.getItemMeta();
                i2_meta.setDisplayName(ChatColor.DARK_AQUA+"/home");
                ArrayList<String> i2_lore = new ArrayList<>();
                i2_lore.add(ChatColor.YELLOW+"Teleport To  Your Home");
                i2_meta.setLore(i2_lore);
                i2.setItemMeta(i2_meta);

                ItemMeta i3_meta = i3.getItemMeta();
                i3_meta.setDisplayName(ChatColor.GRAY+"/grave");
                ArrayList<String> i3_lore = new ArrayList<>();
                i3_lore.add(ChatColor.YELLOW+"Teleport To Your Last Grave");
                i3_meta.setLore(i3_lore);
                i3.setItemMeta(i3_meta);

                ItemMeta i4_meta = i4.getItemMeta();
                i4_meta.setDisplayName(ChatColor.GOLD+"/cords");
                ArrayList<String> i4_lore = new ArrayList<>();
                i4_lore.add(ChatColor.YELLOW+"Shows Your Cords And Direction(N,S,E,W)");
                i4_meta.setLore(i4_lore);
                i4.setItemMeta(i4_meta);

                ItemMeta i5_meta = i5.getItemMeta();
                i5_meta.setDisplayName(ChatColor.LIGHT_PURPLE+"/tpa");
                ArrayList<String> i5_lore = new ArrayList<>();
                i5_lore.add(ChatColor.YELLOW+"Coming Soon!");
                i5_meta.setLore(i5_lore);
                i5.setItemMeta(i5_meta);

                ItemMeta i6_meta = i6.getItemMeta();
                i6_meta.setDisplayName(ChatColor.AQUA+"/overworld");
                ArrayList<String> i6_lore = new ArrayList<>();
                i6_lore.add(ChatColor.YELLOW+"If You're In The Nether, It Will Show \n Your Pos. In Overworld");
                i6_meta.setLore(i6_lore);
                i6.setItemMeta(i6_meta);

                ItemMeta i7_meta = i7.getItemMeta();
                i7_meta.setDisplayName(ChatColor.AQUA+"/nether");
                ArrayList<String> i7_lore = new ArrayList<>();
                i7_lore.add(ChatColor.YELLOW+"If You're In The Overworld, It Will Show \n Your Pos. In Nether");
                i7_meta.setLore(i7_lore);
                i7.setItemMeta(i7_meta);

                gui.addItem(i1,i2, i3, i4, i5, i6, i7);
                p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "[CONCEALED]>> " + ChatColor.YELLOW + "Opening Menu....");
                p.openInventory(gui);

            }
        }else if (command.getName().equalsIgnoreCase("nether")){
            if (sender instanceof Player p){
                Bukkit.dispatchCommand(Bukkit.getPlayerExact(p.getDisplayName()), "trigger nc_inNether");
            }
        }else if (command.getName().equalsIgnoreCase("overworld")){
            if (sender instanceof Player p){
                Bukkit.dispatchCommand(Bukkit.getPlayerExact(p.getDisplayName()), "trigger nc_inOverworld");
            }
        }
        return true;
    }
        @Override
        public void onDisable () {
            // Plugin shutdown logic
            Bukkit.getLogger().info(ChatColor.RED + "" + ChatColor.BOLD + "[Concealed]: " + ChatColor.YELLOW + "Concealed Successfully " + ChatColor.RED + ChatColor.BOLD + "Disabled" + ChatColor.YELLOW + "!!!");
        }
    }
