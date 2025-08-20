package com.notepad.core.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileService {
    public String openFile(Path path) throws IOException {
        return Files.readString(path);
    }

    public void saveFile(Path path, String content) throws IOException {
        Files.writeString(path, content);
    }
}
