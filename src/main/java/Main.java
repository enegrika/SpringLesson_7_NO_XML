import org.sergei.spring.lesson.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        // получение контейнера(контекста) Спринга, в котором он хранит все объекты-бины
// класс для получения КОНТЕКСТА с помощью АННОТАЦИИ CONFIGURATION !!!!!!

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);

        MusicPlayer musicPlayer1 = context.getBean("musicPlayer", MusicPlayer.class);
        MusicPlayer musicPlayer2 = context.getBean("musicPlayer", MusicPlayer.class);

        musicPlayer1.playMusic(MusicGenre.CLASSICAL);
        musicPlayer1.playMusic(MusicGenre.JAZZ);

        ClassicalMusic classicalMusic1 = context.getBean("classicalMusic", ClassicalMusic.class);
        ClassicalMusic classicalMusic2 = context.getBean("classicalMusic", ClassicalMusic.class);

        System.out.println(classicalMusic1 == classicalMusic2);

        if (classicalMusic1 == classicalMusic2) {
            System.out.println("beans are equal - classicalMusic scope is SINGLETON");
        } else {
            System.out.println("beans are not equal - classicalMusic scope is PROTOTYPE");
        }

        System.out.println(musicPlayer1 == musicPlayer2);
        if (musicPlayer1 == musicPlayer2) {
            System.out.println("beans are equal - musicPlayer scope is SINGLETON");
        } else {
            System.out.println("beans are not equal - musicPlayer scope is PROTOTYPE");
        }


        context.close();
    }
}
