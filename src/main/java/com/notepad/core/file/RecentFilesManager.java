package com.notepad.core.file;

import java.util.LinkedList;
import java.util.List;

public class RecentFilesManager {
    private final List<String> recentFiles = new LinkedList<>();

    public void addFile(String path) {
        recentFiles.add(0, path);
    }

    public List<String> getRecentFiles() {
        return recentFiles;
    }
}
