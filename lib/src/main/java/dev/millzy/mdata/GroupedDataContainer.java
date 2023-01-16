package dev.millzy.mdata;

import java.util.HashMap;

public abstract class GroupedDataContainer<T> extends DataContainer<HashMap<String, T>> {
    public GroupedDataContainer(MData mData) {
        super(mData);
    }

    @Override
    public void load(Class<HashMap<String, T>> clazz) {

    }

    @Override
    public void unload() {

    }
}
