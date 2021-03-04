package LoginSys.cmds;

import LoginSys.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class LanguageCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (sender.hasPermission("LoginSys.setLang")) {
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("de")) {
                    Main.main.fm.cfgDELang.set("currentLang", "DE");
                    Main.main.fm.cfgDELang.set("1", "§7[§6§lLoginSystem§7]: §6Du §cmusst §6dich noch einloggen§7! §7/§6login §7[§6Passwort§7]");
                    Main.main.fm.cfgDELang.set("2", "§7[§6§lLoginSystem§7]: §aDu bist bereits eingeloggt§7!");
                    Main.main.fm.cfgDELang.set("3", "§7[§6§lLoginSystem§7]: §aErfolgreich eingeloggt§7!");
                    Main.main.fm.cfgDELang.set("4", "§7[§6§lLoginSystem§7]: §aErfolgreich Registriert§7!");
                    Main.main.fm.cfgDELang.set("5", "§7[§6§lLoginSystem§7]: §6Du §cmusst §6dich noch Registrieren§7! §7/§6register §7[§6Passwort§7] [§6Passwort§7]");
                    Main.main.fm.cfgDELang.set("6", "§7[§6§lLoginSystem§7]: §6Du bist §afrei§7, §6da du dich im Gamemode 3 befindest§7!");
                    Main.main.fm.cfgDELang.set("7", "§7[§6§lLoginSystem§7]: §6Du kannst dich §cnur §6im Gamemode 3 bewegen§7!");
                    Main.main.fm.saveCfg();

                    return true;
                }
                if (args[0].equalsIgnoreCase("en")) {
                    Main.main.fm.cfgDELang.set("currentLang", "EN");
                    Main.main.fm.cfgENLang.set("1", "§7[§6§lLoginSystem§7]: §6You §cneed §6to login§7! §7/§6login §7[§6Passwort§7]");
                    Main.main.fm.cfgENLang.set("2", "§7[§6§lLoginSystem§7]: §aYou are already logged in§7!");
                    Main.main.fm.cfgENLang.set("3", "§7[§6§lLoginSystem§7]: §aSuccessfully logged in§7!");
                    Main.main.fm.cfgENLang.set("4", "§7[§6§lLoginSystem§7]: §aSuccessfully registered§7!");
                    Main.main.fm.cfgENLang.set("5", "§7[§6§lLoginSystem§7]: §6You §cneed §6to register§7! §7/§6register §7[§6Passwort§7] [§6Passwort§7]");
                    Main.main.fm.cfgENLang.set("6", "§7[§6§lLoginSystem§7]: §6You are §afree§7, §6because you are in Gamemode 3§7!");
                    Main.main.fm.cfgENLang.set("7", "§7[§6§lLoginSystem§7]: §6You can §conly §6move in Gamemode 3§7!");
                    Main.main.fm.saveCfg();

                    return true;
                }
                if (args[0].equalsIgnoreCase("ru")) {
                    Main.main.fm.cfgDELang.set("currentLang", "RU");
                    Main.main.fm.cfgRULang.set("1", "§7[§6§lLoginSystem§7]: §6Вы §cдолжны §6войти§7! §7/§6login §7[§6Пароль§7]");
                    Main.main.fm.cfgRULang.set("2", "§7[§6§lLoginSystem§7]: §aВы уже вошли§7!");
                    Main.main.fm.cfgRULang.set("3", "§7[§6§lLoginSystem§7]: §aУспешных вход§7!");
                    Main.main.fm.cfgRULang.set("4", "§7[§6§lLoginSystem§7]: §aУспешная регистрация§7!");
                    Main.main.fm.cfgRULang.set("5", "§7[§6§lLoginSystem§7]: §6Вы §cдолжны §6зарегистрироваться§7! §7/§6register §7[§6Пароль§7] [§6Пароль§7]");
                    Main.main.fm.cfgRULang.set("6", "§7[§6§lLoginSystem§7]: §6Вы §aсвободны§7, §6потому что вы в Gamemode 3§7!");
                    Main.main.fm.cfgRULang.set("7", "§7[§6§lLoginSystem§7]: §6Вы §cтолько §6можите двигаться в Gamemode 3§7!");
                    Main.main.fm.cfgRULang.set("8", "§7[§6§lLoginSystem§7]: §6Вас §cвыгнали §6из соображений безопасности§7!");
                    Main.main.fm.saveCfg();

                    return true;
                }
            }else {
                sender.sendMessage("§4Use §7/§6language §7[§6de§7/§6en§7/§6ru§7]!");
                return false;
            }
        }else {
            sender.sendMessage("§4You´re not allowed to do that§7!");
            return false;
        }
        return true;
    }
}
