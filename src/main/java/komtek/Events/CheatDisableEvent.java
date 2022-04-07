package komtek.Events;

import com.darkmagician6.eventapi.events.Event;
import komtek.Cheat.Cheat;

public class CheatDisableEvent implements Event {

    private Cheat cheat;

    public CheatDisableEvent(Cheat cheat) {
        this.cheat = cheat;
    }

    public Cheat getCheat() {
        return cheat;
    }

}
