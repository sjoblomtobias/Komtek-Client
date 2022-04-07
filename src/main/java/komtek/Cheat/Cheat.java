package komtek.Cheat;

import com.darkmagician6.eventapi.EventManager;
import komtek.Client;
import komtek.Events.CheatDisableEvent;
import komtek.Events.CheatEnableEvent;
import org.apache.logging.log4j.Level;

public class Cheat {

    private final String name;
    private int keyCode;
    private boolean enabled;
    private final Category category;

    public Cheat(String name, int keyCode, Category category) {
        this.name = name;
        this.keyCode = keyCode;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public int getKeyCode() {
        return keyCode;
    }

    public void setKeyCode(int keyCode) {
        this.keyCode = keyCode;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;

        if (this.isEnabled()) {
            EventManager.register(this);
            EventManager.call(new CheatEnableEvent(this));
        } else {
            EventManager.call(new CheatDisableEvent(this));
            EventManager.unregister(this);
        }
    }

    public Category getCategory() {
        return category;
    }

    public void toggle() {
        this.setEnabled(!this.isEnabled());
        Client.getLogger().log(Level.DEBUG, "'" + this.getName() + "' toggled (" + (this.isEnabled() ? "ON" : "OFF") + ")");
    }

}
