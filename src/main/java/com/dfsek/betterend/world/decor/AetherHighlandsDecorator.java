package com.dfsek.betterend.world.decor;

import com.dfsek.betterend.population.structures.EndStructure;
import org.bukkit.block.Biome;
import org.polydev.gaea.math.ProbabilityCollection;
import org.polydev.gaea.tree.Tree;
import org.polydev.gaea.biome.Decorator;

public class AetherHighlandsDecorator implements Decorator<EndStructure> {
    private final ProbabilityCollection<EndStructure> structures = new ProbabilityCollection<EndStructure>()
            .add(EndStructure.AETHER_RUIN, 75)
            .add(EndStructure.SPRUCE_WOOD_HOUSE, 12)
            .add(EndStructure.COBBLE_HOUSE, 12)
            .add(EndStructure.GOLD_DUNGEON, 1);
    private final ProbabilityCollection<Tree> trees = new ProbabilityCollection<Tree>()
            .add(Tree.SPRUCE, 80)
            .add(Tree.LARGE_SPRUCE, 20);

    @Override
    public ProbabilityCollection<EndStructure> getStructures() {
        return structures;
    }

    @Override
    public ProbabilityCollection<Tree> getTrees() {
        return trees;
    }

    @Override
    public int getTreeDensity() {
        return 6;
    }

    @Override
    public boolean overrideStructureChance() {
        return false;
    }
    
    @Override
    public boolean shouldGenerateSnow() {
        return true;
    }

    @Override
    public Biome getVanillaBiome() {
        return Biome.END_HIGHLANDS;
    }
}