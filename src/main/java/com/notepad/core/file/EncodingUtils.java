package com.notepad.core.file;

import java.nio.charset.Charset;

public class EncodingUtils {
    public static Charset getDefaultEncoding() {
        return Charset.defaultCharset();
    }
}
