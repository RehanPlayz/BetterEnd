package org.polydev.gaea.profiler;

import org.bukkit.ChatColor;
import org.bukkit.World;

import java.util.HashMap;
import java.util.Map;

public class WorldProfiler {
    private boolean isProfiling;
    private final Map<String, Measurement> measures = new HashMap<>();
    private final World world;

    public WorldProfiler(World w) {
        isProfiling = false;
        this.world = w;
    }

    public String getResultsFormatted() {
        if(!isProfiling) return "Profiler is not currently running.";
        StringBuilder result = new StringBuilder(ChatColor.GOLD + "Gaea World Profiler Results:\n");
        for(Map.Entry<String, Measurement> e : measures.entrySet()) {
            result.append(ChatColor.GOLD)
                    .append(e.getKey())
                    .append(": Avg ")
                    .append(e.getValue().getDataHolder().getFormattedData(e.getValue().average()))
                    .append(ChatColor.GOLD)
                    .append(", Min ")
                    .append(e.getValue().getDataHolder().getFormattedData(e.getValue().getMin()))
                    .append(ChatColor.GOLD)
                    .append(", Max ")
                    .append(e.getValue().getDataHolder().getFormattedData(e.getValue().getMax()))
                    .append(ChatColor.GOLD)
                    .append(", Std Dev ")
                    .append(ChatColor.GREEN)
                    .append((double) Math.round((e.getValue().getStdDev()/1000000)*100D)/100D)
                    .append("ms")
                    .append(ChatColor.GOLD)
                    .append("\n");
        }
        return result.toString();
    }

    public void reset() {
        for(Map.Entry<String, Measurement> e : measures.entrySet()) {
            e.getValue().reset();
        }
    }

    public WorldProfiler addMeasurement(Measurement m, String name) {
        measures.put(name, m);
        return this;
    }

    public boolean setMeasurement(String id, long value) {
        if(isProfiling) measures.get(id).record(value);
        return isProfiling;
    }

    public ProfileFuture measure(String id) {
        if(isProfiling) return measures.get(id).beginMeasurement();
        else return null;
    }

    public void setProfiling(boolean enabled) {
        this.isProfiling = enabled;
    }

    public World getWorld() {
        return world;
    }
}