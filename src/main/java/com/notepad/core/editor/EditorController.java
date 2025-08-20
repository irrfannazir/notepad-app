package com.notepad.core.editor;

public class EditorController {
    private TextDocument document;

    public EditorController(TextDocument document) {
        this.document = document;
    }

    public void updateContent(String text) {
        document.setContent(text);
    }

    public String fetchContent() {
        return document.getContent();
    }
}
