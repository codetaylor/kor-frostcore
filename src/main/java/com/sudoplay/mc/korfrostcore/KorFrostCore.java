package com.sudoplay.mc.korfrostcore;

import com.sudoplay.mc.kor.spi.Kor;
import com.sudoplay.mc.korfrostcore.module.worldgen.ModuleWorldGen;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by sk3lls on 12/14/2016.
 */
@Mod(
    modid = KorFrostCore.MOD_ID,
    version = KorFrostCore.VERSION,
    name = KorFrostCore.NAME
    //@@DEPENDENCIES@@
)
public class KorFrostCore extends
    Kor {

  public static final String MOD_ID = "ctkorfrostcore";
  public static final String VERSION = "@@VERSION@@";
  public static final String NAME = "CTKor FrostCore";
  public static final double JSON_CONFIGS_VERSION = 1.0;

  @SuppressWarnings("unused")
  @Mod.Instance
  public static KorFrostCore INSTANCE;

  @Override
  public String getModId() {
    return MOD_ID;
  }

  @Override
  public String getModVersion() {
    return VERSION;
  }

  @Override
  public String getModName() {
    return NAME;
  }

  @Override
  public double getJsonConfigsVersion() {
    return JSON_CONFIGS_VERSION;
  }

  @Override
  @Mod.EventHandler
  protected void onPreInitialization(FMLPreInitializationEvent event) {

    this.registerModules(
        new ModuleWorldGen()
    );

    super.onPreInitialization(event);
  }

  @Override
  @Mod.EventHandler
  protected void onInitialization(FMLInitializationEvent event) {
    super.onInitialization(event);
  }

  @Override
  @Mod.EventHandler
  protected void onPostInitialization(FMLPostInitializationEvent event) {
    super.onPostInitialization(event);
  }
}