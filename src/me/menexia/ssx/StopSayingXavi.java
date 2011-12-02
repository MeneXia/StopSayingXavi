package me.menexia.ssx;
import java.util.logging.Logger;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
public class StopSayingXavi extends JavaPlugin {
	public static StopSayingXavi plugin;
	public final Logger logger = Logger.getLogger("Minecraft");
	@Override
	public void onDisable() {
		this.logger.info("StopSayingXavi disabled!");
	}
	@Override
	public void onEnable() {
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvent(Event.Type.PLAYER_CHAT, new playerListener(), Event.Priority.Monitor, this);
		PluginDescriptionFile pdf = this.getDescription();
		this.logger.info( pdf.getName() + " version" + pdf.getVersion() + " by MeneXia is enabled!" );
	}
	class playerListener extends PlayerListener {
		@Override
		public void onPlayerChat(PlayerChatEvent love) {
			if (love.isCancelled()) return;
		String message = love.getMessage();
		Player onlyyoumica = love.getPlayer();
		Location garcia = onlyyoumica.getLocation();
			if ((message.equalsIgnoreCase("xavi") && message.contains("xavi"))
					|| (message.equalsIgnoreCase("ablaza") && message.contains("ablaza"))) {
			love.setCancelled(true);
				if (onlyyoumica.getHealth() > 5) {
			garcia.getWorld().strikeLightningEffect(garcia);
			onlyyoumica.setHealth(5);
			onlyyoumica.sendMessage(ChatColor.RED + "Message blocked by MeneXia.");
			onlyyoumica.sendMessage(ChatColor.RED + "Don't make me send down lightning again!");
				} else {if (onlyyoumica.getHealth() <= 5) {onlyyoumica.sendMessage(ChatColor.RED + "Message blocked by MeneXia.");
				onlyyoumica.sendMessage(ChatColor.RED + "Don't make me send down lightning again!");}}
			}
		}
	}
}