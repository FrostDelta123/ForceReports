package ru.frostdelta.spongepowered.config;

import com.google.inject.Inject;
import ninja.leaping.configurate.ConfigurationNode;
import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.hocon.HoconConfigurationLoader;
import ninja.leaping.configurate.loader.ConfigurationLoader;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.config.ConfigDir;
import org.spongepowered.api.config.DefaultConfig;
import ru.frostdelta.spongepowered.ForceReports;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;

public class ConfigManager {

    @Inject
    @DefaultConfig(sharedRoot = true)
    private Path defaultConfig;

    @Inject
    @DefaultConfig(sharedRoot = true)
    private static ConfigurationLoader<CommentedConfigurationNode> loader;

    @Inject
    @ConfigDir(sharedRoot = false)
    private Path privateConfigDir;

    public static void loadConfig() throws IOException {
        ConfigurationNode rootNode;
        rootNode = loader.load();
        if (!rootNode.hasMapChildren()) {
            ForceReports.getLogger().info("No config found - loading default");
            URL jarConfigFile = Sponge.getAssetManager().getAsset("config.conf").get().getUrl();
            ConfigurationLoader<CommentedConfigurationNode> defaultLoader =
                    HoconConfigurationLoader.builder().setURL(jarConfigFile).build();
            rootNode = defaultLoader.load();
        }
    }
}
