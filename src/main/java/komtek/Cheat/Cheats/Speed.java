package komtek.Cheat.Cheats;

import com.darkmagician6.eventapi.EventTarget;
import komtek.Cheat.Category;
import komtek.Cheat.Cheat;
import komtek.Events.PlayerMoveEvent;
import komtek.Wrapper;
import org.lwjgl.input.Keyboard;

public class Speed extends Cheat {

    public Speed() {
        super("Speed", Keyboard.KEY_G, Category.MOVEMENT);
    }

    @EventTarget
    public void onMove(PlayerMoveEvent event) {
        if (Wrapper.player().moveForward != 0.0f || Wrapper.player().moveStrafing != 0.0f) {
            if (Wrapper.player().isSprinting()) {
                Wrapper.player().setSprinting(true);
            }

            if (Wrapper.player().onGround) {
                Wrapper.mc().timer.timerSpeed = 1.0f;
                Wrapper.player().jump();
            } else {
                Wrapper.mc().timer.timerSpeed = 1.2f;
                Wrapper.player().motionX *= 1.01f;
                Wrapper.player().motionZ *= 1.01f;
            }
        }
    }

}
