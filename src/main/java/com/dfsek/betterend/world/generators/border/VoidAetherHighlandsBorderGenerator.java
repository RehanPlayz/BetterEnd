package com.dfsek.betterend.world.generators.border;

import org.polydev.gaea.math.ProbabilityCollection;
import org.polydev.gaea.biome.BiomeTerrain;
import org.polydev.gaea.world.palette.BlockPalette;
import org.polydev.gaea.math.FastNoise;
import org.bukkit.Material;

public class VoidAetherHighlandsBorderGenerator extends BiomeTerrain {
    private final BlockPalette palette;
    public VoidAetherHighlandsBorderGenerator() {
        super();
        this.palette = new BlockPalette()
                .add(new ProbabilityCollection<Material>()
                        .add(Material.GRASS_BLOCK, 50)
                        .add(Material.COARSE_DIRT, 10)
                        .add(Material.GRAVEL, 15)
                        .add(Material.PODZOL, 25), 1)
                .add(Material.DIRT, 2)
                .add(Material.STONE, 1);
    }

    @Override
    public double getNoise(FastNoise gen, int x, int z) {
        return gen.getSimplexFractal(x, z)*0.5f;
    }

    @Override
    public BlockPalette getPalette() {
        return this.palette;
    }
}