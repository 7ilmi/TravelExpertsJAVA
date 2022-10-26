package com.example.travelexpertsjava;

import javafx.collections.ObservableList;

public abstract class AbstractDAO<O> {
    public abstract ObservableList<O> getAll();

    public abstract void update(O object);

    public abstract void add(O object);

    public abstract void delete(int index);
}
