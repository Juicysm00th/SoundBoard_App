package com.example.soundboardapp;

public class Sound {
   String soundName;
   int soundFile;

    public Sound(String soundName, int soundFile) {
        this.soundName = soundName;
        this.soundFile = soundFile;
    }

    public String getSoundName() {
        return soundName;
    }

    public void setSoundName(String soundName) {
        this.soundName = soundName;
    }

    public int getSoundFile() {
        return soundFile;
    }

    public void setSoundFile(int soundFile) {
        this.soundFile = soundFile;
    }
}
