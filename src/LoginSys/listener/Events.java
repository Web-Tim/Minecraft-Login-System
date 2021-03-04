package LoginSys.listener;

import LoginSys.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Events implements Listener {

    public static String de = "LoginSys/lang/DE.txt", en = "LoginSys/lang/EN.txt", ru = "LoginSys/lang/RU.txt";

    public static boolean allowedToMove(Player p) {
        if (p.getGameMode().equals(GameMode.SPECTATOR)) {
            if (Main.main.waiting.contains(p.getName())) {
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        if (!Bukkit.getOnlineMode()) {
            if (!Main.main.waiting.contains(e.getPlayer().getName())) {
                Main.main.waiting.add(e.getPlayer().getName());
                Main.main.wait.put(e.getPlayer(), e.getPlayer().getLocation());
            }

            if (Main.main.fm.isRegistered(e.getPlayer().getUniqueId().toString())) {
                if (Main.main.fm.cfgDELang.get("currentLang").toString().equals("")) {
                    Main.main.fm.cfgDELang.set("currentLang", "DE");
                    Main.main.fm.saveCfg();
                }
                if (Main.main.fm.cfgDELang.get("currentLang").toString().equals("DE")) {
                    e.getPlayer().sendMessage(Main.main.fm.cfgDELang.get("1").toString());
                }
                if (Main.main.fm.cfgDELang.get("currentLang").toString().equals("EN")) {
                    e.getPlayer().sendMessage(Main.main.fm.cfgENLang.get("1").toString());
                }
                if (Main.main.fm.cfgDELang.get("currentLang").toString().equals("RU")) {
                    e.getPlayer().sendMessage(Main.main.fm.cfgRULang.get("1").toString());
                }

                return;
            }
            if (Main.main.fm.cfgDELang.get("currentLang").toString().equals("")) {
                Main.main.fm.cfgDELang.set("currentLang", "DE");
            }
            if (Main.main.fm.cfgDELang.get("currentLang").toString().equals("DE")) {
                e.getPlayer().sendMessage(Main.main.fm.cfgDELang.get("5").toString());
            }
            if (Main.main.fm.cfgDELang.get("currentLang").toString().equals("EN")) {
                e.getPlayer().sendMessage(Main.main.fm.cfgENLang.get("5").toString());
            }
            if (Main.main.fm.cfgDELang.get("currentLang").toString().equals("RU")) {
                e.getPlayer().sendMessage(Main.main.fm.cfgRULang.get("5").toString());
            }

        }
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        if (!Bukkit.getOnlineMode()) {
            if (Main.main.waiting.contains(e.getPlayer().getName()) && !allowedToMove(e.getPlayer())) {
                int nowX = e.getPlayer().getLocation().getBlockX();
                int nowZ = e.getPlayer().getLocation().getBlockZ();
                if (Main.main.wait.containsKey(e.getPlayer())) {
                    int x = Main.main.wait.get(e.getPlayer()).getBlockX();
                    int z = Main.main.wait.get(e.getPlayer()).getBlockZ();
                    if (z != nowZ || x != nowX) {
                        e.getPlayer().teleport(Main.main.wait.get(e.getPlayer()));
                    }
                }
                for(Player players : Bukkit.getOnlinePlayers()) {
                    players.hidePlayer(e.getPlayer());
                }
            }else {
                for(Player players : Bukkit.getOnlinePlayers()) {
                    players.showPlayer(e.getPlayer());
                }
            }
        }
    }

    @EventHandler
    public void onInteract(PlayerInteractEntityEvent e) {
        if (!Bukkit.getOnlineMode()) {
            if (Main.main.waiting.contains(e.getPlayer().getName())) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onPickUp(PlayerPickupItemEvent e) {
        if (!Bukkit.getOnlineMode()) {
            if (Main.main.waiting.contains(e.getPlayer().getName())) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent e) {
        if (!Bukkit.getOnlineMode()) {
            if (Main.main.waiting.contains(e.getPlayer().getName())) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onGameModeChanged(PlayerGameModeChangeEvent e) {
        if (!Bukkit.getOnlineMode()) {
            if (Main.main.waiting.contains(e.getPlayer().getName())) {
                if (e.getNewGameMode() == GameMode.SPECTATOR && allowedToMove(e.getPlayer())) {
                    if (Main.main.fm.cfgDELang.get("currentLang").toString().equals("")) {
                        Main.main.fm.cfgDELang.set("currentLang", "DE");
                    }
                    if (Main.main.fm.cfgDELang.get("currentLang").toString().equals("DE")) {
                        e.getPlayer().sendMessage(Main.main.fm.cfgDELang.get("6").toString());
                    }
                    if (Main.main.fm.cfgDELang.get("currentLang").toString().equals("EN")) {
                        e.getPlayer().sendMessage(Main.main.fm.cfgENLang.get("6").toString());
                    }
                    if (Main.main.fm.cfgDELang.get("currentLang").toString().equals("RU")) {
                        e.getPlayer().sendMessage(Main.main.fm.cfgRULang.get("6").toString());
                    }

                }else {
                    if (Main.main.fm.cfgDELang.get("currentLang").toString().equals("")) {
                        Main.main.fm.cfgDELang.set("currentLang", "DE");
                    }
                    if (Main.main.fm.cfgDELang.get("currentLang").toString().equals("DE")) {
                        e.getPlayer().sendMessage(Main.main.fm.cfgDELang.get("7").toString());
                    }
                    if (Main.main.fm.cfgDELang.get("currentLang").toString().equals("EN")) {
                        e.getPlayer().sendMessage(Main.main.fm.cfgENLang.get("7").toString());
                    }
                    if (Main.main.fm.cfgDELang.get("currentLang").toString().equals("RU")) {
                        e.getPlayer().sendMessage(Main.main.fm.cfgRULang.get("7").toString());
                    }

                }
            }
        }
    }
}