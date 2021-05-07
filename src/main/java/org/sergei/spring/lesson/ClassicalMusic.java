package org.sergei.spring.lesson;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;

public class ClassicalMusic implements Music {

    ///// ФАБРИЧНЫЙ МЕТОД - получаем объект с помощью СТАТИЧЕСКОГО МЕТОДА
    private ClassicalMusic(){}

    public static ClassicalMusic getClassicalMusic(){
        return new ClassicalMusic();
    }

    @Override
    public String getSong() {
        return "CLASSICAL : Bach - Air on G";
    }

    @Override
    public List getSongList() {
        List<String> list = new ArrayList<>();
        list.add("Bach - Air on G");
        list.add("Bach - Cello suite 1");
        list.add("Bach - Arioso");
        return list;
    }

    @Override
    @PostConstruct
    public void doInit() {
        System.out.println("classical music bean initialized " + this);
    }

    @Override
    @PreDestroy
    public void doDestroy() {
        System.out.println("classical music bean destroyed " + this);
    }
}
