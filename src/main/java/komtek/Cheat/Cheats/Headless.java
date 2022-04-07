package komtek.Cheat.Cheats;

import com.darkmagician6.eventapi.EventTarget;
import komtek.Cheat.Category;
import org.lwjgl.input.Keyboard;
import komtek.Cheat.Cheat;
import komtek.Events.PlayerMoveEvent;

public class Headless extends Cheat {

    public Headless() {
        super("Headless", Keyboard.KEY_H, Category.PLAYER);
    }

    @EventTarget
    public void onMove(PlayerMoveEvent event) {
        event.setPitch(180);
    }

}
