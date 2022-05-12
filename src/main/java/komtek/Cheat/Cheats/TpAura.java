package komtek.Cheat.Cheats;

import com.darkmagician6.eventapi.EventTarget;
import komtek.Cheat.Category;
import komtek.Cheat.Cheat;
import komtek.Events.PlayerMoveEvent;
import komtek.Events.ReachEvent;
import komtek.Wrapper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.network.play.client.C03PacketPlayer;
import org.lwjgl.input.Keyboard;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TpAura extends Cheat {

    public TpAura() {
        super("TpAura", Keyboard.KEY_M, Category.COMBAT);
    }

    @EventTarget
    public void onMove(PlayerMoveEvent event) {
        if (event.isOnGround()) {
            List<EntityLivingBase> entities = new ArrayList<>();

            for (Entity entity : Wrapper.world().loadedEntityList) {
                if (entity instanceof EntityLivingBase) {
                    EntityLivingBase entityLivingBase = (EntityLivingBase) entity;
                    if (entityLivingBase != Wrapper.player() && !entityLivingBase.isDead && Wrapper.player().getDistanceToEntity(entityLivingBase) <= 5.0f) {
                        entities.add(entityLivingBase);
                    }
                }
            }

            if (!entities.isEmpty()) {
                Entity entity = entities.get(0);

                Wrapper.player().sendQueue.addToSendQueue(new C03PacketPlayer.C04PacketPlayerPosition(entity.posX + Math.sin(entity.rotationYaw + 180), entity.posY, entity.posZ + Math.cos(entity.rotationYaw + 180), event.isOnGround()));
            }

            entities.forEach(entity -> {
                Wrapper.player().sendQueue.addToSendQueue(new C02PacketUseEntity(entity, C02PacketUseEntity.Action.ATTACK));
                Wrapper.player().swingItem();

                Wrapper.player().sendQueue.addToSendQueue(new C03PacketPlayer.C04PacketPlayerPosition(event.getX(), event.getY(), event.getZ(), event.isOnGround()));
            });
        }
    }

    @EventTarget
    public void onReach(ReachEvent event) {
        event.setReach(7.0f);
    }

}
