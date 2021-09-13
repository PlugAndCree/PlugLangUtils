package it.plugandcree.langutils;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.plugin.java.JavaPlugin;

import it.plugandcree.langutils.config.CustomConfig;

public class LangUtils extends JavaPlugin {
	
	private static LangUtils instance;
	private CustomConfig centralizedLangConfig;
	
	@Override
	public void onEnable() {
		instance = this;
		
		setCentralizedLangConfig(createConfigFile("lang.yml"));
	}
	
	private CustomConfig createConfigFile(String name) {
		File fc = new File(getDataFolder(), name);
		if (!fc.exists()) {
			fc.getParentFile().mkdirs();
			saveResource(name, false);
		}

		CustomConfig configFile = new CustomConfig();
		try {
			configFile.load(fc);
			return configFile;
		} catch (IOException | InvalidConfigurationException e) {
			throw new RuntimeException(e);
		}
	}
	
	public LangUtils getInstance() {
		return instance;
	}

	public CustomConfig getCentralizedLangConfig() {
		return centralizedLangConfig;
	}

	public void setCentralizedLangConfig(CustomConfig centralizedLangConfig) {
		this.centralizedLangConfig = centralizedLangConfig;
	}
}
