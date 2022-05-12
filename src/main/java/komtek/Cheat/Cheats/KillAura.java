package komtek.Cheat.Cheats;

import com.darkmagician6.eventapi.EventTarget;
import komtek.Cheat.Category;
import komtek.Cheat.Cheat;
import komtek.Events.PlayerMoveEvent;
import komtek.Wrapper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.network.play.client.C02PacketUseEntity;
import org.lwjgl.input.Keyboard;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class KillAura extends Cheat {

    public KillAura() {
        super("KillAura", Keyboard.KEY_R, Category.COMBAT);
    }

    @EventTarget
    public void onMove(PlayerMoveEvent event) {
        List<EntityLivingBase> entities = new ArrayList<>();

        for (Entity entity : Wrapper.world().loadedEntityList) {
            if (entity instanceof EntityLivingBase) {
                EntityLivingBase entityLivingBase = (EntityLivingBase) entity;
                if (entityLivingBase != Wrapper.player() && !entityLivingBase.isDead && Wrapper.player().getDistanceToEntity(entityLivingBase) <= 10.0f) {
                    entities.add(entityLivingBase);
                }
            }
        }

        entities.forEach(entity -> {
            Wrapper.player().sendQueue.addToSendQueue(new C02PacketUseEntity(entity, C02PacketUseEntity.Action.ATTACK));
            Wrapper.player().swingItem();
        });
    }

}
