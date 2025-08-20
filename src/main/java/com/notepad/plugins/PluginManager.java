package com.notepad.plugins;

import java.util.ArrayList;
import java.util.List;

public class PluginManager {
    private final List<Object> plugins = new ArrayList<>();

    public void registerPlugin(Object plugin) {
        plugins.add(plugin);
    }
}
