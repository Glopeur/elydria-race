package fr.elydria.race.commands;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import fr.elydria.race.Main;

public class Race implements TabExecutor {

	Main plugin;

	public Race(Main plugin) {
		this.plugin = plugin;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (args.length == 0) {
				argHelp(sender);
			}

			else {
				if (args[0].equals("set")) {
					if (sender.hasPermission("elydria.race.set") || sender.hasPermission("elydria.race.*")
							|| sender.hasPermission("elydria.*") || sender.hasPermission("*") || sender.isOp()) {
						if (args.length >= 2) {
							switch (args[1]) {

							case "humain":
								if (args.length == 3) {
									Player o = Bukkit.getPlayer(args[2]);
									if (o != null) {
										if (o != sender) {
											argSet(sender, o, "" + o.getUniqueId(), 1);
										} else {
											argSet(sender, p, "" + p.getUniqueId(), 1);
										}
									} else {
										sender.sendMessage("§cErreur : Joueur hors-ligne ou inconnu.");
									}
								} else {
									argSet(sender, p, "" + p.getUniqueId(), 1);
								}
								break;

							case "elfe":
								if (args.length == 3) {
									if (args.length == 3) {
										Player o = Bukkit.getPlayer(args[2]);
										if (o != null) {
											if (o != sender) {
												argSet(sender, o, "" + o.getUniqueId(), 2);
											} else {
												argSet(sender, p, "" + p.getUniqueId(), 2);
											}
										} else {
											sender.sendMessage("§cErreur : Joueur hors-ligne ou inconnu.");
										}
									}
								} else {
									argSet(sender, p, "" + p.getUniqueId(), 2);
								}
								break;

							case "nain":
								if (args.length == 3) {
									if (args.length == 3) {
										Player o = Bukkit.getPlayer(args[2]);
										if (o != null) {
											if (o != sender) {
												argSet(sender, o, "" + o.getUniqueId(), 3);
											} else {
												argSet(sender, p, "" + p.getUniqueId(), 3);
											}
										} else {
											sender.sendMessage("§cErreur : Joueur hors-ligne ou inconnu.");
										}
									}
								} else {
									argSet(sender, p, "" + p.getUniqueId(), 3);
								}
								break;

							case "orc":
								if (args.length == 3) {
									if (args.length == 3) {
										Player o = Bukkit.getPlayer(args[2]);
										if (o != null) {
											if (o != sender) {
												argSet(sender, o, "" + o.getUniqueId(), 4);
											} else {
												argSet(sender, p, "" + p.getUniqueId(), 4);
											}
										} else {
											sender.sendMessage("§cErreur : Joueur hors-ligne ou inconnu.");
										}
									}
								} else {
									argSet(sender, p, "" + p.getUniqueId(), 4);
								}
								break;

							default:
								sender.sendMessage("§cErreur : Race valide -> humain / elfe / nain / orc");
								break;
							}
						}
					} else {
						sender.sendMessage("§cErreur : Vous n'avez pas la permission d'utiliser cette commande.");
					}
				}
				if (args[0].equals("info")) {
					if (args.length == 2) {
						if (Bukkit.getPlayer(args[1]) == null) {
							if (!Bukkit.getOfflinePlayer(args[1]).hasPlayedBefore()) {
								sender.sendMessage("§cErreur : Joueur inconnu.");
							} else {
								OfflinePlayer o = Bukkit.getOfflinePlayer(args[1]);
								argInfo(sender, o.getName(), "" + o.getUniqueId());
							}
						} else {
							Player o = Bukkit.getPlayer(args[1]);
							if (o != sender) {
								argInfo(sender, o.getName(), "" + o.getUniqueId());
							} else {
								argInfo(sender, p.getName(), "" + p.getUniqueId());
							}
						}
					} else {
						argInfo(sender, p.getName(), "" + p.getUniqueId());
					}
				}

				if (args[0].equals("help")) {
					argHelp(sender);
				}

				if (args[0].equals("version")) {
					argVersion(sender);
				}
			}
		} else {
			if (args.length == 0) {

			} else {
				if (args[0].equals("set")) {
					if (args.length >= 2) {
						if (args.length == 2) {
							System.out.println("Erreur : Indiquez un joueur cible.");
						} else {
							switch (args[1]) {
							case "humain":
								if (args.length == 3) {
									Player o = Bukkit.getPlayer(args[2]);
									if (o != null) {
										if (o != sender) {
											argSet(sender, o, "" + o.getUniqueId(), 1);
										}
									} else {
										System.out.println("§cErreur : Joueur hors-ligne ou inconnu.");
									}
								}
								break;

							case "elfe":
								if (args.length == 3) {
									if (args.length == 3) {
										Player o = Bukkit.getPlayer(args[2]);
										if (o != null) {
											if (o != sender) {
												argSet(sender, o, "" + o.getUniqueId(), 2);
											}
										} else {
											System.out.println("§cErreur : Joueur hors-ligne ou inconnu.");
										}
									}
								}
								break;

							case "nain":
								if (args.length == 3) {
									if (args.length == 3) {
										Player o = Bukkit.getPlayer(args[2]);
										if (o != null) {
											if (o != sender) {
												argSet(sender, o, "" + o.getUniqueId(), 3);
											}
										} else {
											System.out.println("§cErreur : Joueur hors-ligne ou inconnu.");
										}
									}
								}
								break;

							case "orc":
								if (args.length == 3) {
									if (args.length == 3) {
										Player o = Bukkit.getPlayer(args[2]);
										if (o != null) {
											if (o != sender) {
												argSet(sender, o, "" + o.getUniqueId(), 4);
											}
										} else {
											System.out.println("§cErreur : Joueur hors-ligne ou inconnu.");
										}
									}
								}
								break;

							default:
								System.out.println("Erreur : Race valide -> humain / elfe / nain / orc");
								break;
							}
						}
					}
				}
				if (args[0].equals("info")) {
					if(args.length == 2) {
						System.out.println("Erreur : Indiquez un joueur cible.");
					} else {
						if (Bukkit.getPlayer(args[1]) == null) {
							if (!Bukkit.getOfflinePlayer(args[1]).hasPlayedBefore()) {
								System.out.println("Erreur : Joueur inconnu.");
							} else {
								OfflinePlayer o = Bukkit.getOfflinePlayer(args[1]);
								argInfo(sender, o.getName(), "" + o.getUniqueId());
							}
						} else {
							Player o = Bukkit.getPlayer(args[1]);
							if (o != sender) {
								argInfo(sender, o.getName(), "" + o.getUniqueId());
							}
						}
					}
				}
			}
		}
		return true;
	}

	private void argSet(CommandSender sender, Player p, String s, int i) {
		if(sender instanceof Player) {
			plugin.setRace(s + ".race", i);
			sender.sendMessage("§aLe joueur §b" + p.getName() + " §aappartient désormais à la Race : §b"
					+ translateRace(plugin.getRace(s + ".race")));
		} else {
			if(plugin.getRace(s + ".changeable") == 1) {
				plugin.setRace(s + ".race", i);
				plugin.setRace(s + ".changeable", 99);
				System.out.println("Le joueur " + p.getName() + " appartient désormais à la Race : "
						+ translateRace(plugin.getRace(s + ".race")));
			} else {
				System.out.println("Erreur : Le joueur ne peut plus changer de Race.");
				p.sendMessage("§cErreur : Vous ne pouvez plus changer de Race.");
			}
		}
	}

	private void argInfo(CommandSender sender, String name, String s) {
		if(sender instanceof Player) {
			sender.sendMessage("§aLe joueur §b" + name + " §aappartient à la Race : §b" + translateRace(plugin.getRace(s + ".race")));
		} else {
			System.out.println("Le joueur " + name + " appartient à la Race : " + translateRace(plugin.getRace(s + ".race")));
		}
	}

	private void argVersion(CommandSender sender) {
		sender.sendMessage("§3---==={§aElydria Race§3}===---");
		sender.sendMessage("§7Version : " + plugin.getDescription().getVersion() + " by §o@Glopeur");
	}

	private void argHelp(CommandSender sender) {
		sender.sendMessage("§3---==={§aElydria Race§3}===---");
		if (sender.hasPermission("elydria.race.set") || sender.hasPermission("elydria.race.*")
				|| sender.hasPermission("elydria.*") || sender.hasPermission("*") || sender.isOp()) {
			sender.sendMessage("§b/erace set §3<joueur> §7| Affecte une Race à un joueur.");
		}
		sender.sendMessage("§b/erace info §3<joueur> §7| Affiche la Race d'un joueur.");
		sender.sendMessage("§b/erace help §7| Affiche cette page de commande.");
		sender.sendMessage("§b/erace version §7| Affiche la version du plugin.");
	}

	private String translateRace(int i) {
		String res = "";
		switch (i) {
		case 1:
			res = "Humain";
			break;
		case 2:
			res = "Elfe";
			break;
		case 3:
			res = "Nain";
			break;
		case 4:
			res = "Orc";
			break;
		case 99:
			res = "Aucune";
			break;
		}
		return res;
	}

	@Override
	public List<String> onTabComplete(CommandSender s, Command c, String l, String[] a) {
		List<String> res = new ArrayList<>();
		switch (a.length) {
		case 1:
			if (s.hasPermission("elydria.race.set") || s.hasPermission("elydria.race.*") || s.hasPermission("elydria.*")
					|| s.hasPermission("*") || s.isOp()) {
				res.add("set");
			}
			res.add("info");
			res.add("help");
			res.add("version");
			break;
		case 2:
			if (a[0].equals("set")) {
				res.add("humain");
				res.add("elfe");
				res.add("nain");
				res.add("orc");
			}
			if (a[0].equals("info")) {
				Collection<? extends Player> list = Bukkit.getOnlinePlayers();
				for (Player p : list) {
					res.add(p.getName());
				}
			}
			break;
		case 3:
			if (a[0].equals("set")) {
				Collection<? extends Player> list = Bukkit.getOnlinePlayers();
				for (Player p : list) {
					res.add(p.getName());
				}
			}
			break;
		}
		return res;
	}
}
