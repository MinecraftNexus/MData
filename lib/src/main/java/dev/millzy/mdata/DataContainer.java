package dev.millzy.mdata;

public abstract class DataContainer<T> {
    private T data;

    public abstract void getName();

    public T open() {
        return data;
    }

    public void contain(T data) {
        this.data = data;
    }

    public abstract void load();
    public abstract void unload();
}
