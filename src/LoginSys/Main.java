package LoginSys;

import LoginSys.cmds.LanguageCommand;
import LoginSys.listener.Events;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.libs.org.ibex.nestedvm.util.Seekable;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static LoginSys.listener.Events.*;

public class Main extends JavaPlugin {

    public static Main main;
    public static String lang = "LoginSys/lang/DE.txt";
    public ArrayList<String> waiting = new ArrayList<>();
    public FileManager fm;
    public HashMap<Player, Location> wait = new HashMap<Player, Location>();

    @Override
    public void onEnable() {
        System.out.println("  [Login-System]: Enabling...");
        main = Main.this;
        fm = new FileManager();
        fm.saveCfg();
        Bukkit.getPluginManager().registerEvents(new Events(), this);
        getCommand("language").setExecutor(new LanguageCommand());
    }

    @Override
    public void onDisable() {
        if (!Bukkit.getOnlineMode()) {
            for (String all : waiting) {
                if (fm.cfgDELang.get("currentLang").toString().equals("DE")) {
                    Bukkit.getPlayer(all).kickPlayer(fm.cfgDELang.get("8").toString());
                }
                if (fm.cfgDELang.get("currentLang").toString().equals("EN")) {
                    Bukkit.getPlayer(all).kickPlayer(fm.cfgDELang.get("8").toString());
                }
                if (fm.cfgDELang.get("currentLang").toString().equals("RU")) {
                    Bukkit.getPlayer(all).kickPlayer(fm.cfgDELang.get("8").toString());
                }
                if (fm.cfgDELang.get("currentLang").toString().equals("")) {
                    fm.cfgDELang.set("currentLang", "DE");
                }
            }
        }
        System.out.println("  [Login-System]: Disabling...");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!Bukkit.getOnlineMode()) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (cmd.getName().equalsIgnoreCase("login")) {
                    if (args.length == 1) {
                        if (!waiting.contains(player.getName())) {
                            if (fm.cfgDELang.get("currentLang").toString().equals("")) {
                                fm.cfgDELang.set("currentLang", "DE");
                            }
                            if (fm.cfgDELang.get("currentLang").toString().equals("DE")) {
                                player.sendMessage(fm.cfgDELang.get("2").toString());
                            }
                            if (fm.cfgDELang.get("currentLang").toString().equals("EN")) {
                                player.sendMessage(fm.cfgENLang.get("2").toString());
                            }
                            if (fm.cfgDELang.get("currentLang").toString().equals("RU")) {
                                player.sendMessage(fm.cfgRULang.get("2").toString());
                            }
                            return true;
                        }
                        if (fm.isRegistered(player.getUniqueId().toString())) {
                            String pw = args[0];
                            if (fm.cfg.get(player.getUniqueId().toString()).equals(pw)) {
                                waiting.remove(player.getName());
                                if (fm.cfgDELang.get("currentLang").toString().equals("")) {
                                    fm.cfgDELang.set("currentLang", "DE");
                                }
                                if (fm.cfgDELang.get("currentLang").toString().equals("DE")) {
                                    player.sendMessage(fm.cfgDELang.get("3").toString());
                                }
                                if (fm.cfgDELang.get("currentLang").toString().equals("EN")) {
                                    player.sendMessage(fm.cfgENLang.get("3").toString());
                                }
                                if (fm.cfgDELang.get("currentLang").toString().equals("RU")) {
                                    player.sendMessage(fm.cfgRULang.get("3").toString());
                                }
                            }
                        }else {
                            if (fm.cfgDELang.get("currentLang").toString().equals("")) {
                                fm.cfgDELang.set("currentLang", "DE");
                            }
                            if (fm.cfgDELang.get("currentLang").toString().equals("DE")) {
                                player.sendMessage(fm.cfgDELang.get("5").toString());
                            }
                            if (fm.cfgDELang.get("currentLang").toString().equals("EN")) {
                                player.sendMessage(fm.cfgENLang.get("5").toString());
                            }
                            if (fm.cfgDELang.get("currentLang").toString().equals("RU")) {
                                player.sendMessage(fm.cfgRULang.get("5").toString());
                            }
                        }
                    }
                }else if (cmd.getName().equalsIgnoreCase("register")) {
                    if (args.length == 2) {
                        if (args[0].equals(args[1])) {
                            fm.cfg.set(player.getUniqueId().toString(), args[0]);
                            fm.saveCfg();
                            if (fm.cfgDELang.get("currentLang").toString().equals("")) {
                                fm.cfgDELang.set("currentLang", "DE");
                            }
                            if (fm.cfgDELang.get("currentLang").toString().equals("DE")) {
                                player.sendMessage(fm.cfgDELang.get("4").toString());
                            }
                            if (fm.cfgDELang.get("currentLang").toString().equals("EN")) {
                                player.sendMessage(fm.cfgENLang.get("4").toString());
                            }
                            if (fm.cfgDELang.get("currentLang").toString().equals("RU")) {
                                player.sendMessage(fm.cfgRULang.get("4").toString());
                            }
                            waiting.remove(player.getName());
                        }else {
                            if (fm.cfgDELang.get("currentLang").toString().equals("")) {
                                fm.cfgDELang.set("currentLang", "DE");
                            }
                            if (fm.cfgDELang.get("currentLang").toString().equals("DE")) {
                                player.sendMessage(fm.cfgDELang.get("5").toString());
                            }
                            if (fm.cfgDELang.get("currentLang").toString().equals("EN")) {
                                player.sendMessage(fm.cfgENLang.get("5").toString());
                            }
                            if (fm.cfgDELang.get("currentLang").toString().equals("RU")) {
                                player.sendMessage(fm.cfgRULang.get("5").toString());
                            }
                        }
                    }else {
                        if (fm.cfgDELang.get("currentLang").toString().equals("")) {
                            fm.cfgDELang.set("currentLang", "DE");
                        }
                        if (fm.cfgDELang.get("currentLang").toString().equals("DE")) {
                            player.sendMessage(fm.cfgDELang.get("5").toString());
                        }
                        if (fm.cfgDELang.get("currentLang").toString().equals("EN")) {
                            player.sendMessage(fm.cfgENLang.get("5").toString());
                        }
                        if (fm.cfgDELang.get("currentLang").toString().equals("RU")) {
                            player.sendMessage(fm.cfgRULang.get("5").toString());
                        }
                    }
                }
            }
        }
        return false;
    }
}
