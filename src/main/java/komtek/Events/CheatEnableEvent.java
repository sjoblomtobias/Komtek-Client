package komtek.Events;

import com.darkmagician6.eventapi.events.Event;
import komtek.Cheat.Cheat;

public class CheatEnableEvent implements Event {

    private Cheat cheat;

    public CheatEnableEvent(Cheat cheat) {
        this.cheat = cheat;
    }

    public Cheat getCheat() {
        return cheat;
    }
}
