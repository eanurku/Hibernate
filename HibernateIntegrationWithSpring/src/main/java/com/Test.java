package com;

import org.springframework.stereotype.Component;

@Component
public class Test {

    String id;
    public Test() {
    }

    public String getId() {
        return id==null?"is is null":id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
