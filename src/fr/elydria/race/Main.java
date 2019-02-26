package fr.elydria.race;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.elydria.race.commands.Race;
import fr.elydria.race.listener.ChatListener;
import fr.elydria.race.listener.DwarfListener;
import fr.elydria.race.listener.ElveListener;
import fr.elydria.race.listener.HumanListener;
import fr.elydria.race.listener.LoginListener;
import fr.elydria.race.listener.OrcListener;

public class Main extends JavaPlugin {

	private File dataFile;
	private FileConfiguration data;
	private Race race = new Race(this);
	private LoginListener log = new LoginListener(this);
	private ChatListener chat = new ChatListener(this);
	private HumanListener human = new HumanListener(this);
	private ElveListener elve = new ElveListener(this);
	private DwarfListener dwarf = new DwarfListener(this);
	private OrcListener orc = new OrcListener(this);
	private PluginManager pm = this.getServer().getPluginManager();
	
	@Override
	public void onEnable() {
		startFile();
		commandList();
		tabCompleteList();
		listenerList(pm);
	}	
	
	@Override
	public void onDisable() {
		
	}
	
	private void commandList() {
		this.getCommand("elydriarace").setExecutor(race);
	}
	
	private void tabCompleteList() {
		this.getCommand("elydriarace").setTabCompleter(race);
	}
	
	private void listenerList(PluginManager pm) {
		Listener logListener = log;
		pm.registerEvents(logListener, this);
		
		Listener chatListener = chat;
		pm.registerEvents(chatListener, this);
		
		Listener humanListener = human;
		pm.registerEvents(humanListener, this);
		
		Listener elveListener = elve;
		pm.registerEvents(elveListener, this);
		
		Listener dwarfListener = dwarf;
		pm.registerEvents(dwarfListener, this);
		
		Listener orcListener = orc;
		pm.registerEvents(orcListener, this);
	}
	
	//DATA
	public int getRace(String s) {
		int ret = data.getInt(s);
		return ret;
	}
	
	public void setRace(String s, int i) {
		data.set(s, i);
		saveFile();
	}
	
	
	//FILE
	private void startFile() {
		dataFile = new File(getDataFolder(), "playerData.yml");
		try {
			checkFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
		data = new YamlConfiguration();
		loadFile();
	}
	
	private void checkFile() {
		if(!dataFile.exists()) {
			dataFile.getParentFile().mkdirs();
			copyFile(getResource("playerData.yml"), dataFile);
		}
	}
	
	private void copyFile(InputStream is, File file) {
		try {
			FileOutputStream out = new FileOutputStream(file);
			byte[] buf = new byte[1024];
			int len;
			while((len = is.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
			out.close();
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void loadFile() {
		try {
			data.load(dataFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void saveFile() {
		try {
			data.save(dataFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
