package dev.millzy.mdata;

public abstract class DataContainer<T> {
    private T data;

    public DataContainer() {}

    public T open() {
        return data;
    }

    public void contain(T data) {
        this.data = data;
    }

    public abstract void load();
    public abstract void unload();
    public abstract String getName();
}
