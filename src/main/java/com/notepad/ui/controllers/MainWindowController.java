package com.notepad.ui.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class MainWindowController {
    @FXML
    private TextArea textArea;

    public void initialize() {
        textArea.setWrapText(true);
    }
}
