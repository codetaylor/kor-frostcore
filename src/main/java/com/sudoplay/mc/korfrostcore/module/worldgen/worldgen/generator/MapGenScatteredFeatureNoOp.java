package com.sudoplay.mc.korfrostcore.module.worldgen.worldgen.generator;

import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.structure.MapGenScatteredFeature;

import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by sk3lls on 12/14/2016.
 */
public class MapGenScatteredFeatureNoOp extends
    MapGenScatteredFeature {

  @Override
  public void generate(World worldIn, int x, int z, ChunkPrimer primer) {
    //
  }

  @Override
  public synchronized boolean generateStructure(World worldIn, Random randomIn, ChunkPos chunkCoord) {
    return false;
  }

  @Override
  protected boolean canSpawnStructureAtCoords(int chunkX, int chunkZ) {
    return false;
  }

  @Override
  public List<Biome.SpawnListEntry> getScatteredFeatureSpawnList() {
    return Collections.emptyList();
  }
}
