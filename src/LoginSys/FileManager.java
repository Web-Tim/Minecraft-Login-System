package LoginSys;

import com.sun.swing.internal.plaf.basic.resources.basic_fr;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.libs.org.ibex.nestedvm.util.Seekable;

import java.io.*;

public class FileManager {

    public File f = new File(Main.main.getDataFolder(), "Passwords.yml");
    public FileConfiguration cfg = YamlConfiguration.loadConfiguration(f);

    public File fDE = new File(Main.main.getDataFolder(), "lang/DE.yml");
    public File fEN = new File(Main.main.getDataFolder(), "lang/EN.yml");
    public File fRU = new File(Main.main.getDataFolder(), "lang/RU.yml");
    public FileConfiguration cfgDELang = YamlConfiguration.loadConfiguration(fDE);
    public FileConfiguration cfgENLang = YamlConfiguration.loadConfiguration(fEN);
    public FileConfiguration cfgRULang = YamlConfiguration.loadConfiguration(fRU);

    public boolean isRegistered(String uuid) {
        if (cfg.contains(uuid)) {
            return true;
        }
        return false;
    }

    public void saveCfg() {
        try {
            cfg.save(f);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            cfgDELang.save(fDE);
            cfgENLang.save(fEN);
            cfgRULang.save(fRU);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
