package dev.millzy.mdata;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

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

    public abstract void load(Class<T> clazz) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException, ClassNotFoundException;
    public abstract void unload() throws IOException;
    public abstract String getName();
}
