import org.sergei.spring.lesson.ClassicalMusic;
import org.sergei.spring.lesson.JazzMusic;
import org.sergei.spring.lesson.MusicPlayer;
import org.springframework.context.annotation.*;


// ГЛАВНЫЙ КОНФИНУРАЦИОННЫЙ КЛАСС и АННОТАЦИИ где искать наши БИНЫ
@Configuration
@ComponentScan(basePackages = "org.sergei.spring.lesson")
@PropertySource("classpath:musicPlayer.properties")
public class SpringConfig {


    @Bean
    @Scope("prototype")
    public ClassicalMusic classicalMusic() {
        return ClassicalMusic.getClassicalMusic();
    }

    @Bean
    @Scope("prototype")
    public JazzMusic jazzMusic() {
        return new JazzMusic();
    }


    @Bean
    public MusicPlayer musicPlayer() {
        return new MusicPlayer(classicalMusic(), jazzMusic());
    }

}
