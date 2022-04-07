package komtek.Cheat.Cheats;

import com.darkmagician6.eventapi.EventTarget;
import komtek.Cheat.Category;
import komtek.Cheat.Cheat;
import komtek.Events.PlayerMoveEvent;
import komtek.Wrapper;
import org.lwjgl.input.Keyboard;

public class NoFall extends Cheat {

    public NoFall() {
        super("NoFall", Keyboard.KEY_N, Category.PLAYER);
    }

    @EventTarget
    public void onMove(PlayerMoveEvent event) {
        if (!event.isOnGround() && Wrapper.player().fallDistance > 3.0f && !Wrapper.player().capabilities.isFlying) {
            event.setOnGround(true);
        }
    }

}
