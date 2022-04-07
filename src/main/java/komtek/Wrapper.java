package komtek;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.multiplayer.WorldClient;

public class Wrapper {

    public static Minecraft mc() {
        return Minecraft.getMinecraft();
    }

    public static FontRenderer fr() {
        return mc().fontRendererObj;
    }

    public static EntityPlayerSP player() {
        return mc().thePlayer;
    }

    public static WorldClient world() {
        return mc().theWorld;
    }

}
