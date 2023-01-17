package dev.millzy.mdata.data;

import dev.millzy.mdata.DataContainer;
import dev.millzy.mdata.MData;

import java.io.IOException;

public class TestDataContainer extends DataContainer<TestData> {
    /**
     * Creates a new container using an existing data instance.
     * @param data data to place in container.
     */
    public TestDataContainer(MData mData, TestData data) {
        super(mData, data);
    }

    public TestDataContainer(MData mData) throws IOException, ClassNotFoundException {
        super(mData);
    }

    @Override
    public String getDataId() {
        return "test_data";
    }
}
