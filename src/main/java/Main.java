import config.SpringConfig;
import org.sergei.spring.lesson.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);

        MusicPlayer musicPlayer1 = context.getBean(
                "musicPlayer", MusicPlayer.class);

        musicPlayer1.playMusic();

        context.close();
    }
}
