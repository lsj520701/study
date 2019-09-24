package com.alex.study.common.events;

import java.io.Serializable;

public class AidlEvent implements Serializable {
    String name;

    public AidlEvent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
