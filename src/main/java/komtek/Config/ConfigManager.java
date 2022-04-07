package komtek.Config;

import komtek.Wrapper;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class ConfigManager {

    private final File directory;
    private Set<Config> configs;

    public ConfigManager() {
        this.directory = new File(Wrapper.mc().mcDataDir + File.separator + "komtek");
        if (!directory.exists()) {
            directory.mkdirs();
        }
        this.configs = new HashSet<>();
    }

    public Set<Config> getConfigs() {
        return configs;
    }
}
