package org.sergei.spring.lesson;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;

//@Component
//@Scope("prototype")
public class JazzMusic implements Music {

    @Override
    public String getSong() {
        return "Take five";
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
