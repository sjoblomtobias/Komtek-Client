package komtek.Cheat.Cheats;

import com.darkmagician6.eventapi.EventTarget;
import komtek.Cheat.Category;
import komtek.Cheat.Cheat;
import komtek.Events.PlayerMoveEvent;
import komtek.Wrapper;
import org.lwjgl.input.Keyboard;

public class Sprint extends Cheat {

    public Sprint() {
        super("Sprint", Keyboard.KEY_Y, Category.MOVEMENT);
    }

    @EventTarget
    public void onMove(PlayerMoveEvent event) {
        if (!Wrapper.player().isSprinting()) {
            Wrapper.player().setSprinting(true);
        }
    }

}
