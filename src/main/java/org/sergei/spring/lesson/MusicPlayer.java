package org.sergei.spring.lesson;

import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.Random;


public class MusicPlayer {

    @Value("${musicPlayer.name}")
    private String name;
    @Value("${musicPlayer.volume}")
    private int volume;

    private List<Music> musicList;

    public MusicPlayer(List<Music> musicList) {
        this.musicList = musicList;
    }

    public void playMusic() {
        int rand = new Random().nextInt(musicList.size());
        System.out.println(name + " playing : "
                + musicList.get(rand).getSong() + " at volume = " + volume);
    }

}
