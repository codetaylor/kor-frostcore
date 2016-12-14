package com.sudoplay.mc.korfrostcore.module.worldgen;

import com.google.common.eventbus.Subscribe;
import com.sudoplay.mc.kor.spi.IKorModule;
import com.sudoplay.mc.kor.spi.event.internal.OnRegisterEventHandlersEvent;
import com.sudoplay.mc.korfrostcore.module.worldgen.worldgen.EventHandlerWorldGen;

/**
 * Created by sk3lls on 12/14/2016.
 */
public class ModuleWorldGen implements
    IKorModule {

  public static final String MODULE_ID = "worldgen";

  @Override
  public String getKorModuleId() {
    return MODULE_ID;
  }

  @Subscribe
  public void onRegisterEventHandlersEvent(OnRegisterEventHandlersEvent event) {
    event.getRegistryService().register(

        new EventHandlerWorldGen()
    );
  }
}
