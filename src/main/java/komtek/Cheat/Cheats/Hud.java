package komtek.Cheat.Cheats;

import com.darkmagician6.eventapi.EventTarget;
import komtek.Cheat.Category;
import komtek.Cheat.Cheat;
import komtek.Client;
import komtek.Events.RenderOverlayEvent;
import komtek.Wrapper;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.input.Keyboard;
import java.util.List;
import java.util.stream.Collectors;

public class Hud extends Cheat {

    public Hud() {
        super("Hud", Keyboard.KEY_U, Category.HIDDEN);
        this.toggle();
    }

    @EventTarget
    public void onRender(RenderOverlayEvent event) {
        GlStateManager.pushMatrix();
        float scale = 1.0f;
        GlStateManager.scale(scale, scale, scale);
        Wrapper.fr().drawStringWithShadow("Client", 2, 2, 0xffffff);
        GlStateManager.popMatrix();

        List<Cheat> toRender = Client.getCheatManager().getCheats().stream().filter(cheat -> cheat.getCategory() != Category.HIDDEN).sorted((cheat1, cheat2) -> {
            if (Wrapper.fr().getStringWidth(cheat1.getName()) > Wrapper.fr().getStringWidth(cheat2.getName())) {
                return -1;
            } else if (Wrapper.fr().getStringWidth(cheat1.getName()) < Wrapper.fr().getStringWidth(cheat2.getName())) {
                return 1;
            }
            return 0;
        }).collect(Collectors.toList());

        int index = 0;

        ScaledResolution sr = new ScaledResolution(Wrapper.mc());

        for (Cheat cheat : toRender) {
            Wrapper.fr().drawStringWithShadow((cheat.isEnabled() ? "§a" : "§c") + cheat.getName() + " §f(" + Keyboard.getKeyName(cheat.getKeyCode()) + ")", sr.getScaledWidth() - Wrapper.fr().getStringWidth(cheat.getName() + " (A)") - 2, 2 + index * 12, 0xffffff);
            index++;
        }
    }

}
