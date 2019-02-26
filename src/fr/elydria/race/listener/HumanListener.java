package fr.elydria.race.listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import fr.elydria.race.Main;

public class HumanListener implements Listener {

	//DMG HOE + MOVEMENT SPEED
	Main plugin;
	
	public HumanListener(Main plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	private void OnJoin(PlayerJoinEvent e) {
		if (plugin.getRace("" + e.getPlayer().getUniqueId() + ".race") == 1) {
			e.getPlayer().setWalkSpeed(0.25f);
		} else {
			e.getPlayer().setWalkSpeed(0.2f);
		}
	}
	
	@EventHandler
	private void onEntityDamage(EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Player) {
			Player p = (Player) e.getDamager();
			if (plugin.getRace("" + p.getUniqueId() + ".race") == 1) {
				if (p.getInventory().getItemInMainHand().getType() == Material.DIAMOND_HOE
						|| p.getInventory().getItemInMainHand().getType() == Material.GOLDEN_HOE
						|| p.getInventory().getItemInMainHand().getType() == Material.IRON_HOE
						|| p.getInventory().getItemInMainHand().getType() == Material.STONE_HOE
						|| p.getInventory().getItemInMainHand().getType() == Material.WOODEN_HOE) {
					e.setDamage(e.getDamage() + 3.0D);
				}
			}
		}
	}
}
