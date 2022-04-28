package komtek.Cheat.Cheats;

import com.darkmagician6.eventapi.EventTarget;
import komtek.Cheat.Category;
import komtek.Cheat.Cheat;
import komtek.Events.CheatDisableEvent;
import komtek.Events.CheatEnableEvent;
import komtek.Wrapper;
import net.minecraft.block.Block;
import org.lwjgl.input.Keyboard;

import java.util.ArrayList;
import java.util.List;

public class Xray extends Cheat {

    public Xray() {
        super("Xray", Keyboard.KEY_X, Category.RENDER);
        addBlocks();
    }

    float oldGamma;
    public static boolean enabled = false;

    @EventTarget
    public void onEnable(CheatEnableEvent event) {
        if (event.getCheat() == this) {
            enabled = true;
            Wrapper.mc().renderGlobal.loadRenderers();
            oldGamma = Wrapper.mc().gameSettings.gammaSetting;
            Wrapper.mc().gameSettings.gammaSetting = 16f;
        }
    }

    @EventTarget
    public void onDisable(CheatDisableEvent event) {
        if (event.getCheat() == this) {
            enabled = false;
            Wrapper.mc().renderGlobal.loadRenderers();
            Wrapper.mc().gameSettings.gammaSetting = oldGamma;
        }
    }

    public static List<Block> blockList = new ArrayList<>();

    private void addBlocks() {
        blockList.add(Block.getBlockFromName("coal_ore"));
        blockList.add(Block.getBlockFromName("iron_ore"));
        blockList.add(Block.getBlockFromName("gold_ore"));
        blockList.add(Block.getBlockFromName("redstone_ore"));
        blockList.add(Block.getBlockById(74));
        blockList.add(Block.getBlockFromName("lapis_ore"));
        blockList.add(Block.getBlockFromName("diamond_ore"));
        blockList.add(Block.getBlockFromName("emerald_ore"));
        blockList.add(Block.getBlockFromName("quartz_ore"));
        blockList.add(Block.getBlockFromName("clay"));
        blockList.add(Block.getBlockFromName("glowstone"));
        blockList.add(Block.getBlockById(8));
        blockList.add(Block.getBlockById(9));
        blockList.add(Block.getBlockById(10));
        blockList.add(Block.getBlockById(11));
        blockList.add(Block.getBlockFromName("crafting_table"));
        blockList.add(Block.getBlockById(61));
        blockList.add(Block.getBlockById(62));
        blockList.add(Block.getBlockFromName("torch"));
        blockList.add(Block.getBlockFromName("ladder"));
        blockList.add(Block.getBlockFromName("tnt"));
        blockList.add(Block.getBlockFromName("coal_block"));
        blockList.add(Block.getBlockFromName("iron_block"));
        blockList.add(Block.getBlockFromName("gold_block"));
        blockList.add(Block.getBlockFromName("diamond_block"));
        blockList.add(Block.getBlockFromName("emerald_block"));
        blockList.add(Block.getBlockFromName("redstone_block"));
        blockList.add(Block.getBlockFromName("lapis_block"));
        blockList.add(Block.getBlockFromName("fire"));
        blockList.add(Block.getBlockFromName("mossy_cobblestone"));
        blockList.add(Block.getBlockFromName("mob_spawner"));
        blockList.add(Block.getBlockFromName("end_portal_frame"));
        blockList.add(Block.getBlockFromName("enchanting_table"));
        blockList.add(Block.getBlockFromName("bookshelf"));
        blockList.add(Block.getBlockFromName("command_block"));
    }


}
