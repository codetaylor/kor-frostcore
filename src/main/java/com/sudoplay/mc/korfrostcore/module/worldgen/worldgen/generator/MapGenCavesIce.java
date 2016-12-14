package com.sudoplay.mc.korfrostcore.module.worldgen.worldgen.generator;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.MapGenCaves;

/**
 * Created by sk3lls on 12/14/2016.
 */
public class MapGenCavesIce extends
    MapGenCaves {

  private static final IBlockState PACKED_ICE = Blocks.PACKED_ICE.getDefaultState();

  @Override
  protected void digBlock(ChunkPrimer data, int x, int y, int z, int chunkX, int chunkZ, boolean foundTop, IBlockState state, IBlockState up) {
    net.minecraft.world.biome.Biome biome = worldObj.getBiomeGenForCoords(new BlockPos(x + chunkX * 16, 0, z + chunkZ * 16));
    IBlockState top = biome.topBlock;
    IBlockState filler = biome.fillerBlock;

    if (this.canReplaceBlock(state, up) || state.getBlock() == top.getBlock() || state.getBlock() == filler.getBlock()) {
      if (y - 1 < 10) {
        data.setBlockState(x, y, z, PACKED_ICE);
      } else {
        data.setBlockState(x, y, z, BLK_AIR);

        if (foundTop && data.getBlockState(x, y - 1, z).getBlock() == filler.getBlock()) {
          data.setBlockState(x, y - 1, z, PACKED_ICE);
        }
      }
    }
  }
}
