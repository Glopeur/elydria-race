package fr.elydria.race.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import fr.elydria.race.Main;

public class ChatListener implements Listener {

	Main plugin;
	
	public ChatListener(Main plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void playerChat(AsyncPlayerChatEvent e) {
		String n = e.getPlayer().getName();
		switch(plugin.getRace("" + e.getPlayer().getUniqueId() + ".race")) {
		case 1: //NINGEN
			e.getPlayer().setDisplayName("§7[§6Humain§7]§r " + n);
			break;
		case 2: //ELFE
			e.getPlayer().setDisplayName("§7[§bElfe§7]§r " + n);
			break;
		case 3: //NAIN
			e.getPlayer().setDisplayName("§7[§8Nain§7]§r " + n);
			break;
		case 4: //ORC
			e.getPlayer().setDisplayName("§7[§4Orc§7]§r " + n);
			break;
		case 99:
			e.getPlayer().setDisplayName(n);
			break;
		}
	}
}
