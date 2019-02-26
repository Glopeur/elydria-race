package fr.elydria.race.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import fr.elydria.race.Main;

public class LoginListener implements Listener {

	Main plugin;
	
	public LoginListener(Main plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	private void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		String uid = "" + p.getUniqueId() + ".race";

		if(plugin.getRace(uid) == 0) {
			regPlayer(p);
		}
	}
	
	private void regPlayer(Player p) {
		plugin.setRace("" + p.getUniqueId() + ".race", 99);
		plugin.setRace("" + p.getUniqueId() + ".changeable", 1);
	}
}
