package concealed.concealed;
import net.md_5.bungee.api.chat.ClickEvent;
import org.bukkit.*;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.messaging.Messenger;

import javax.annotation.processing.Messager;
import javax.sound.midi.Receiver;
import javax.xml.transform.Result;
import java.sql.Time;
import java.util.ArrayList;

public class Listeners implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if (p.hasPlayedBefore()) {
            e.setJoinMessage(ChatColor.GREEN + "" + ChatColor.BOLD + p.getDisplayName() + ChatColor.YELLOW + ", Welcome Back To Concealed SMP!!!");
        } else {
            e.setJoinMessage((ChatColor.BLUE + "" + ChatColor.BOLD + p.getDisplayName() + ChatColor.YELLOW + ", Welcome To Concealed SMP!!!"));
        }
    }
    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        e.setQuitMessage(ChatColor.RED + "" + ChatColor.BOLD + "[CONCEALED]>> " + ChatColor.YELLOW + "GoodBye & See You Again, " + ChatColor.AQUA + "" + ChatColor.BOLD + p.getDisplayName());
    }
    @EventHandler
    public void onPlayerSleep(PlayerBedEnterEvent e) {
        Player p = e.getPlayer();
        if (p.getWorld().getTime() > 12542){
            p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "[CONCEALED]>> " + ChatColor.YELLOW + "Good Night, " + ChatColor.AQUA + p.getDisplayName() + ChatColor.YELLOW + ".");
        }
    }    @EventHandler
    public void onBow(EntityDamageByEntityEvent e) {
        if (e.getCause() == EntityDamageEvent.DamageCause.PROJECTILE) {
            if (e.getDamager() instanceof Arrow a && e.getEntity() instanceof Player) {
                if (!(a.getShooter() instanceof Player)) return;
                ((Player) a.getShooter()).playSound(((Player) a.getShooter()).getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 2);
                ((Player) a.getShooter()).sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "[CONCEALED]>> " + ChatColor.RED + ((Player) e.getEntity()).getDisplayName() + ChatColor.YELLOW + " Has " + ChatColor.GREEN + "" + ChatColor.BOLD + ((Player) e.getEntity()).getHealth() + ChatColor.YELLOW + " HP Left!");
            }
        }
    }
    @EventHandler
    public void onClick(InventoryClickEvent e){
        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.YELLOW+"Useful Menu")){
            e.setCancelled(true);
            Player p = (Player) e.getWhoClicked();
            if (e.getCurrentItem().getType().equals(null)){
                return;
            }else if (e.getCurrentItem().getType().equals(Material.BEACON)){
                Bukkit.dispatchCommand(Bukkit.getPlayerExact(p.getDisplayName()), "sethome");
                p.closeInventory();
            }else if (e.getCurrentItem().getType().equals(Material.DARK_OAK_DOOR)){
                Bukkit.dispatchCommand(Bukkit.getPlayerExact(p.getDisplayName()), "home");
                p.closeInventory();
            }else if (e.getCurrentItem().getType().equals(Material.STONE_BRICK_WALL)){
                Bukkit.dispatchCommand(Bukkit.getPlayerExact(p.getDisplayName()), "grave");
                p.closeInventory();
            }else if (e.getCurrentItem().getType().equals(Material.COMPASS)){
                Bukkit.dispatchCommand(Bukkit.getPlayerExact(p.getDisplayName()), "cords");
                p.closeInventory();
            }else if (e.getCurrentItem().getType().equals(Material.GRASS_BLOCK)){
                Bukkit.dispatchCommand(Bukkit.getPlayerExact(p.getDisplayName()), "overworld");
                p.closeInventory();
            }else if (e.getCurrentItem().getType().equals(Material.NETHERRACK)){
                Bukkit.dispatchCommand(Bukkit.getPlayerExact(p.getDisplayName()), "nether");
                p.closeInventory();
            }else if (e.getCurrentItem().getType().equals(Material.ENDER_PEARL)){
                p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "[CONCEALED]>> " + ChatColor.YELLOW +"Coming SOON!(Do Not Ask When)");
                p.closeInventory();
            }

        }
    }
}







