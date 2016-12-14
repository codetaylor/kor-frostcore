package com.sudoplay.mc.korfrostcore.module.worldgen.worldgen;

import com.sudoplay.mc.kor.spi.event.KorForgeEventSubscriber;
import com.sudoplay.mc.korfrostcore.module.worldgen.worldgen.generator.*;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.InitMapGenEvent;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Random;

/**
 * Created by sk3lls on 12/14/2016.
 */
public class EventHandlerWorldGen extends
    KorForgeEventSubscriber {

  private WorldGenLakes worldGenLakesIce = new WorldGenLakes(Blocks.ICE);

  public EventHandlerWorldGen() {
    MinecraftForge.TERRAIN_GEN_BUS.register(this);
  }

  @SubscribeEvent
  public void onInitMapGenEvent(InitMapGenEvent event) {
    InitMapGenEvent.EventType type = event.getType();

    switch (type) {
      case CAVE:
        event.setNewGen(new MapGenCavesIce());

      case STRONGHOLD:
        event.setNewGen(new MapGenStrongholdNoOp());
        break;

      case VILLAGE:
        event.setNewGen(new MapGenVillageNoOp());
        break;

      case MINESHAFT:
        event.setNewGen(new MapGenMineshaftNoOp());
        break;

      case SCATTERED_FEATURE:
        event.setNewGen(new MapGenScatteredFeatureNoOp());
        break;

      case OCEAN_MONUMENT:
        event.setNewGen(new StructureOceanMonumentNoOp());
        break;
    }
  }

  @SubscribeEvent
  public void onPopulateChunkEvent(PopulateChunkEvent.Populate event) {

    if (event.getType() == PopulateChunkEvent.Populate.EventType.LAKE) {
      Random rand = event.getRand();
      World world = event.getWorld();
      int x = event.getChunkX();
      int z = event.getChunkZ();

      BlockPos blockpos = new BlockPos(x * 16, 0, z * 16);
      int i1 = rand.nextInt(16) + 8;
      int j1 = rand.nextInt(256);
      int k1 = rand.nextInt(16) + 8;
      this.worldGenLakesIce.generate(world, rand, blockpos.add(i1, j1, k1));
      event.setResult(Event.Result.DENY);

    } else if (event.getType() == PopulateChunkEvent.Populate.EventType.FIRE) {
      event.setResult(Event.Result.DENY);

    } else if (event.getType() == PopulateChunkEvent.Populate.EventType.LAVA) {
      Random rand = event.getRand();
      World world = event.getWorld();
      int x = event.getChunkX();
      int z = event.getChunkZ();

      BlockPos blockpos = new BlockPos(x * 16, 0, z * 16);
      int i2 = rand.nextInt(16) + 8;
      int l2 = rand.nextInt(rand.nextInt(248) + 8);
      int k3 = rand.nextInt(16) + 8;

      if (l2 < world.getSeaLevel() || rand.nextInt(10) == 0) {
        this.worldGenLakesIce.generate(world, rand, blockpos.add(i2, l2, k3));
      }
      event.setResult(Event.Result.DENY);

    } else if (event.getType() == PopulateChunkEvent.Populate.EventType.DUNGEON) {
      event.setResult(Event.Result.DENY);

    } else if (event.getType() == PopulateChunkEvent.Populate.EventType.ANIMALS) {
      event.setResult(Event.Result.DENY);
    }

  }
}
