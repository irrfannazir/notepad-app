package com.notepad.core.search;

public class SearchService {
    public int find(String text, String query) {
        return text.indexOf(query);
    }
}
