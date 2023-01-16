package dev.millzy.mdata;

public abstract class DataContainer<T> {
    private T data;
    protected MData mData;

    public DataContainer(MData mData) {
        this.mData = mData;
    }

    public T open() {
        return data;
    }

    public void contain(T data) {
        this.data = data;
    }

    public abstract void load(Class<T> clazz);
    public abstract void unload();
    public abstract String getName();
}
