package komtek;

import com.darkmagician6.eventapi.EventManager;
import com.darkmagician6.eventapi.EventTarget;
import komtek.Cheat.CheatManager;
import komtek.Events.StartEvent;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Client {

    private static Logger logger;
    private static CheatManager cheatManager;

    public Client() {
        Thread.currentThread().setName("KomTek");
        EventManager.register(this);
        EventManager.call(new StartEvent());
    }

    @EventTarget
    public void onStart(StartEvent event) {
        logger = LogManager.getLogger();
        logger.log(Level.INFO, "Client started");
        cheatManager = new CheatManager();
    }

    public static Logger getLogger() {
        return logger;
    }

    public static CheatManager getCheatManager() {
        return cheatManager;
    }
}
