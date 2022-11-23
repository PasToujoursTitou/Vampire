package fr.titou.Vampire;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{
	
	@Override
	public void onEnable() {
		System.out.println("[Vampire] Enabling...");
		saveDefaultConfig();
		getServer().getPluginManager().registerEvents(this, this);
	}
	
	@Override
	public void onDisable() {
		System.out.println("[Vampire] Disabling...");
	}

	@EventHandler
	public void onDeath(PlayerDeathEvent event) {
		
		Player player = event.getEntity().getKiller();
		Boolean msg = getConfig().getBoolean("msg");
		
		if(player.hasPermission("vampire.effect")) {
			if(player.getHealth() < 20) {			
				if(msg == true) {
					player.setHealth(20);
					player.sendMessage("§d[Vampire] health has been restored");
				}else {
					player.setHealth(20);
				}	
			}
		}
	}
}
