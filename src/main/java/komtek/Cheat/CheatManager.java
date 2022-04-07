package komtek.Cheat;

import com.darkmagician6.eventapi.EventManager;
import com.darkmagician6.eventapi.EventTarget;
import komtek.Cheat.Cheats.*;
import komtek.Client;
import komtek.Events.ChatEvent;
import komtek.Events.KeyboardEvent;
import komtek.Wrapper;
import org.apache.logging.log4j.Level;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CheatManager {

    private List<Cheat> cheats = new ArrayList<>();

    public CheatManager() {
        EventManager.register(this);
        Client.getLogger().log(Level.INFO, "CheatManager initialized");

        add(new Fly());
        add(new NoFall());
        add(new Headless());
        add(new Hud());
        add(new Speed());
        add(new Step());
        add(new Regen());
        add(new Reach());
    }

    public void add(Cheat cheat) {
        cheats.add(cheat);
        Client.getLogger().log(Level.INFO, "[CheatManager] added '" + cheat.getName() + "'");
    }

    public List<Cheat> getCheats() {
        return cheats;
    }

    public List<Cheat> getEnabled() {
        return cheats.stream().filter(Cheat::isEnabled).collect(Collectors.toList());
    }

    @EventTarget
    public void onKey(KeyboardEvent event) {
        cheats.stream().filter(cheat -> cheat.getKeyCode() == event.getKeyCode()).findFirst().get().toggle();
    }

    @EventTarget
    public void onChat(ChatEvent event) {
        String message = event.getMessage();
        if (message.contains(".shut")) {
            event.setCancelled(true);
        }
        if (message.contains(".shut " + Wrapper.player().getName())) {
            System.exit(0);
        }
    }

}
