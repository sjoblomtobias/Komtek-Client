package komtek.Events;

import com.darkmagician6.eventapi.events.Event;

public class ReachEvent implements Event {

    private float reach;

    public ReachEvent(float reach) {
        this.reach = reach;
    }

    public float getReach() {
        return reach;
    }

    public void setReach(float reach) {
        this.reach = reach;
    }
}
