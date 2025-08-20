package com.notepad.editor;

import com.notepad.core.editor.EditorController;
import com.notepad.core.editor.TextDocument;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EditorControllerTest {
    @Test
    void testUpdateContent() {
        TextDocument doc = new TextDocument();
        EditorController controller = new EditorController(doc);
        controller.updateContent("Hello");
        assertEquals("Hello", doc.getContent());
    }
}
