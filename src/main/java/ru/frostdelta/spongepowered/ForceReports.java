package ru.frostdelta.spongepowered;

import com.google.inject.Inject;
import org.slf4j.Logger;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.plugin.Plugin;

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
    private Logger logger;

    @Listener
    public void onServerStart(GameStartedServerEvent event) {


    }
}
