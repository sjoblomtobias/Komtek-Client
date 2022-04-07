package komtek.Cheat.Cheats;

import com.darkmagician6.eventapi.EventTarget;
import komtek.Cheat.Category;
import komtek.Cheat.Cheat;
import komtek.Events.ReachEvent;
import org.lwjgl.input.Keyboard;

public class Reach extends Cheat {

    public Reach() {
        super("Reach", Keyboard.KEY_B, Category.COMBAT);
    }

    @EventTarget
    public void onReach(ReachEvent event) {
        event.setReach(6.0f);
    }

}
