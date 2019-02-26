package fr.elydria.race.listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.elydria.race.Main;

public class DwarfListener implements Listener {

	//MINING SPEED + AXE DMG
	Main plugin;
	
	public DwarfListener(Main plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	private void OnJoin(PlayerJoinEvent e) {
		if (plugin.getRace("" + e.getPlayer().getUniqueId() + ".race") == 3) {
			e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 9999999, 1, false, false));
		} else {
			for(PotionEffect po : e.getPlayer().getActivePotionEffects()) {
				if(po.getType() == PotionEffectType.FAST_DIGGING) {
					e.getPlayer().removePotionEffect(PotionEffectType.FAST_DIGGING);
				}
			}
		}
	}
	
	@EventHandler
	private void onEntityDamage(EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Player) {
			Player p = (Player) e.getDamager();
			if (plugin.getRace("" + p.getUniqueId() + ".race") == 3) {
				if (p.getInventory().getItemInMainHand().getType() == Material.DIAMOND_AXE
						|| p.getInventory().getItemInMainHand().getType() == Material.GOLDEN_AXE
						|| p.getInventory().getItemInMainHand().getType() == Material.IRON_AXE
						|| p.getInventory().getItemInMainHand().getType() == Material.STONE_AXE
						|| p.getInventory().getItemInMainHand().getType() == Material.WOODEN_AXE) {
					e.setDamage(e.getDamage() + 3.0D);
				}
			}
		}
	}
}
