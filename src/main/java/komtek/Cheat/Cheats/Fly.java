package komtek.Cheat.Cheats;

import com.darkmagician6.eventapi.EventTarget;
import komtek.Cheat.Category;
import komtek.Events.PlayerMoveEvent;
import komtek.Wrapper;
import org.lwjgl.input.Keyboard;
import komtek.Cheat.Cheat;
import komtek.Events.CheatDisableEvent;

public class Fly extends Cheat {

    public Fly() {
        super("Fly", Keyboard.KEY_F, Category.MOVEMENT);
    }

    @EventTarget
    public void onMove(PlayerMoveEvent event) {
        if (!Wrapper.player().capabilities.isFlying) {
            Wrapper.player().capabilities.isFlying = true;
        }
        event.setOnGround(true);
    }

    @EventTarget
    public void onDisable(CheatDisableEvent event) {
        if (event.getCheat() == this) {
            Wrapper.player().capabilities.isFlying = false;
        }
    }

}
