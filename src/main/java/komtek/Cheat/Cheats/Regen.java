package komtek.Cheat.Cheats;

import com.darkmagician6.eventapi.EventTarget;
import komtek.Cheat.Category;
import komtek.Cheat.Cheat;
import komtek.Events.PlayerMoveEvent;
import komtek.Wrapper;
import net.minecraft.network.play.client.C03PacketPlayer;
import org.lwjgl.input.Keyboard;

public class Regen extends Cheat {

    public Regen() {
        super("Regen", Keyboard.KEY_L, Category.PLAYER);
    }

    @EventTarget
    public void onMove(PlayerMoveEvent event) {
        if (Wrapper.player().getHealth() < 20.0f && !Wrapper.player().getFoodStats().needFood()) {
            for (int i = 0; i < 50; i++) {
                Wrapper.player().sendQueue.addToSendQueue(new C03PacketPlayer(true));
            }
        }
    }

}
