package com.notepad.config;

import java.util.Properties;

public class PreferencesManager {
    private Properties preferences = new Properties();

    public void setPreference(String key, String value) {
        preferences.setProperty(key, value);
    }

    public String getPreference(String key) {
        return preferences.getProperty(key);
    }
}
