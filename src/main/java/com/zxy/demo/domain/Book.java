package com.zxy.demo.domain;

import java.io.Serializable;

/**
 * Created by Donghua.Chen on 2018/6/20.
 */
public class Book implements Serializable {
    private static final long serialVersionUID = -2164058270260403154L;
//id
    private String id;
        // name
    private String name;
                //use git commmit -a
    public Book() {
    }

    public Book(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


