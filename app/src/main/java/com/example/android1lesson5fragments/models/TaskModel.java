package com.example.android1lesson5fragments.models;

import java.io.Serializable;

public class TaskModel implements Serializable {
    private  String title;

    public TaskModel(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
