package config;

import org.sergei.spring.lesson.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import java.util.Arrays;
import java.util.List;


// ГЛАВНЫЙ КОНФИНУРАЦИОННЫЙ КЛАСС и АННОТАЦИИ где искать наши БИНЫ
@Configuration
//@ComponentScan(basePackages = "org.sergei.spring.lesson")
// annotation for Values file
@PropertySource("classpath:musicPlayer.properties")
public class SpringConfig {

    @Bean
    @Scope("prototype")
    // creating bean with FABRIC PATTERN
    public ClassicalMusic classicalMusic() {
        return ClassicalMusic.getClassicalMusic();
    }

    @Bean
    @Scope("prototype")
    public JazzMusic jazzMusic() {
        return new JazzMusic();
    }

    @Bean
    @Scope("prototype")
    public PopMusic popMusic(){
        return new PopMusic();
    }

    @Bean
    @Scope("singleton")
    // CREATING BEAN with a LIST of the MUSIC genres
    public List<Music> musicList(){
        return Arrays.asList(classicalMusic(),jazzMusic(),popMusic());

    }

    @Bean
    @Scope("singleton")
    public MusicPlayer musicPlayer() {
        return new MusicPlayer(musicList());
    }

}
