package komtek.Cheat.Cheats;

import com.darkmagician6.eventapi.EventTarget;
import komtek.Cheat.Category;
import komtek.Cheat.Cheat;
import komtek.Events.CheatDisableEvent;
import komtek.Events.CheatEnableEvent;
import komtek.Wrapper;
import org.lwjgl.input.Keyboard;

public class Step extends Cheat {

    public Step() {
        super("Step", Keyboard.KEY_V, Category.MOVEMENT);
    }

    @EventTarget
    public void onEnable(CheatEnableEvent event) {
        Wrapper.player().stepHeight = 2.0f;
    }

    @EventTarget
    public void onDisable(CheatDisableEvent event) {
        Wrapper.player().stepHeight = 0.5f;
    }

}
