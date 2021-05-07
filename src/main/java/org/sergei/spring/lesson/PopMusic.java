package org.sergei.spring.lesson;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;

public class PopMusic implements Music {

    @Override
    public String getSong() {
        return "POP : A-HA - Lifelines";
    }

    @Override
    public List getSongList() {
        List<String> list = new ArrayList<>();
        list.add("A-HA Lifelines");
        list.add("Duran Duran - Ordinary World");
        list.add("Depeche Mode - Behind the wheel");
        return list;
    }

    @Override
    @PostConstruct
    public void doInit() {
        System.out.println("pop music bean initialized " + this);
    }

    @Override
    @PreDestroy
    public void doDestroy() {
        System.out.println("pop music bean destroyed " + this);
    }
}
