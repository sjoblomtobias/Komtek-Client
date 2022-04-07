package komtek.Events;

import com.darkmagician6.eventapi.events.Event;

public class KeyboardEvent implements Event {

    private int keyCode;

    public KeyboardEvent(int keyCode) {
        this.keyCode = keyCode;
    }

    public int getKeyCode() {
        return this.keyCode;
    }

}
