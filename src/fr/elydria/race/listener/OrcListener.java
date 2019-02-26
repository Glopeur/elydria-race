package fr.elydria.race.listener;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import fr.elydria.race.Main;

public class OrcListener implements Listener {

	// +2HP + BOOST DMG SWORD

	Main plugin;

	public OrcListener(Main plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	private void OnJoin(PlayerJoinEvent e) {
		if (plugin.getRace("" + e.getPlayer().getUniqueId() + ".race") == 4) {
			e.getPlayer().getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(22.0D);
		} else {
			e.getPlayer().getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(20.0D);
		}
	}

	@EventHandler
	private void onEntityDamage(EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Player) {
			Player p = (Player) e.getDamager();
			if (plugin.getRace("" + p.getUniqueId() + ".race") == 4) {
				if (p.getInventory().getItemInMainHand().getType() == Material.DIAMOND_SWORD
						|| p.getInventory().getItemInMainHand().getType() == Material.GOLDEN_SWORD
						|| p.getInventory().getItemInMainHand().getType() == Material.IRON_SWORD
						|| p.getInventory().getItemInMainHand().getType() == Material.STONE_SWORD
						|| p.getInventory().getItemInMainHand().getType() == Material.WOODEN_SWORD) {
					e.setDamage(e.getDamage() + 3.0D);
				}
			}
		}
	}
}
