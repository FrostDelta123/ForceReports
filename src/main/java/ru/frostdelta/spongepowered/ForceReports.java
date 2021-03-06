package ru.frostdelta.spongepowered;

import com.google.inject.Inject;
import org.slf4j.Logger;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.plugin.Plugin;
import ru.frostdelta.spongepowered.config.ConfigManager;

import java.io.IOException;

@Plugin(
        id = "forcereports",
        name = "ForceReports",
        version = "1.0-SNAPSHOT",
        description = "Report plugin for sponge. BungeeReports port.",
        authors = {
                "FrostDelta123"
        }
)
public class ForceReports {

    @Inject
    private static Logger logger;

    public static Logger getLogger() {
        return logger;
    }

    @Listener
    public void onServerStart(GameStartedServerEvent event) {
        logger.info("Developed by FrostDelta123");
        try {
            ConfigManager.loadConfig();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
