package dev.millzy.mdata;

import java.io.IOException;
import java.util.ArrayList;

public abstract class DataSeriesContainer<V> extends DataContainer<ArrayList<V>> {
    public DataSeriesContainer(MData mData, ArrayList<V> data) {
        super(mData, data);
    }

    public DataSeriesContainer(MData mData) throws IOException, ClassNotFoundException {
        super(mData);
    }


}
