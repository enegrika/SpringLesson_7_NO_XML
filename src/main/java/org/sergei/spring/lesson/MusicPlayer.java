package org.sergei.spring.lesson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Scope("singleton")
public class MusicPlayer {

    private Music music1;
    private Music music2;

    // value name case sensitive!

    @Value("${musicPlayer.name}")
    private String name;
    @Value("${musicPlayer.volume}")
    private int volume;

    @Autowired
// we use annotation QUALIFIER to inject dependency with specific classname start from LowCase Letter
    public MusicPlayer(@Qualifier("classicalMusic") Music music1,
                       @Qualifier("jazzMusic") Music music2) {
        this.music1 = music1;
        this.music2 = music2;
    }

    public void playMusic(MusicGenre musicGenre) {
        int index;
        if (musicGenre.equals(MusicGenre.CLASSICAL)) {
            index = new Random().nextInt(music1.getSongList().size());
            System.out.println(name + " Playing : " + music1.getSongList().get(index) + " at volume = " + volume);

        } else if (musicGenre.equals(MusicGenre.JAZZ)) {
            index = new Random().nextInt(music2.getSongList().size());
            System.out.println(name + " Playing : " + music2.getSongList().get(index) + " at volume = " + volume);

        }
    }

}
