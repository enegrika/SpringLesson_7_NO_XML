package org.sergei.spring.lesson;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;


public class JazzMusic implements Music {

    @Override
    public String getSong() {
        return "JAZZ :  Dizzie Gillespie - Take five";
    }

    @Override
    public List getSongList() {
        List<String> list = new ArrayList<>();
        list.add("Take five");
        list.add("Watermelon Man");
        list.add("Unforgettable");
        return list;
    }

    @Override
    @PostConstruct
    public void doInit() {
        System.out.println("jazz music bean initialized " + this);

    }

    @Override
    @PreDestroy
    public void doDestroy() {
        System.out.println("jazz music bean destroyed " + this);

    }
}
