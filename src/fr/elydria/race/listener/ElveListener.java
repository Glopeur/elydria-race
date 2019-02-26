package fr.elydria.race.listener;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerExpChangeEvent;

import fr.elydria.race.Main;

public class ElveListener implements Listener {

	//DMG ARC + MORE EXP
	Main plugin;
	
	public ElveListener(Main plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	private void onExpChange(PlayerExpChangeEvent e) {
		if(plugin.getRace(e.getPlayer().getUniqueId() + ".race") == 2) {
			e.setAmount(e.getAmount() + 5);
		}
	}
	
	@EventHandler
	private void onArrowHit(EntityDamageByEntityEvent e) {
		if(e.getDamager() instanceof Arrow) {
			Arrow a = (Arrow) e.getDamager();
			if(a.getShooter() instanceof Player) {
				Player p = (Player) a.getShooter();
				if(plugin.getRace(p.getUniqueId() + ".race") == 2) {
					e.setDamage(e.getDamage() + 3.0D);
				}
			}
		}
	}
}
