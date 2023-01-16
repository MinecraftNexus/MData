package dev.millzy.mdata.data;

import dev.millzy.mdata.BespokeDataContainer;
import dev.millzy.mdata.MData;

import java.io.IOException;

public class BespokeTestDataContainer extends BespokeDataContainer<BespokeTestData> {
    public BespokeTestDataContainer(MData mData) throws IOException, ClassNotFoundException {
        super(mData);
    }

    @Override
    public String getDataId() {
        return "bespoke_test_data";
    }
}
