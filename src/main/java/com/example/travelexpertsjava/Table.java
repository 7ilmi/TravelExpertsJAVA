package com.example.travelexpertsjava;

import java.util.ArrayList;

abstract class Table<O> {
    protected final String displayName;

    public Table(String displayName) {
        this.displayName = displayName;
    }

    public abstract ArrayList<O> getAll();

    public abstract void update(O object);

    public abstract void add(O object);

    public abstract void delete(O object);

    @Override
    public final String toString() {
        return displayName;
    }
}
