package komtek.Events;

import com.darkmagician6.eventapi.events.Event;

public class ChatEvent implements Event {

    private String message;
    private boolean cancelled;

    public ChatEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

}
