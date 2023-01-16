package dev.millzy.mdata;

import java.util.HashMap;

public abstract class GroupedDataContainer<T extends GroupedData> extends DataContainer<T> {
    public GroupedDataContainer(MData mData) {
        super(mData);
    }

    @Override
    public void load(Class<T> clazz) {

    }

    @Override
    public void unload() {

    }
}
