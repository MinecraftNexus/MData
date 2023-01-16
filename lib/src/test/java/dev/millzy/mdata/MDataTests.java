package dev.millzy.mdata;

import dev.millzy.mdata.data.BespokeTestData;
import dev.millzy.mdata.data.BespokeTestDataContainer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Objects;

public class MDataTests {
    @Test
    @DisplayName("MData Builder Test")
    public void builderTest() {
        MData mData = MData.create("MDataTests").build();

        assert(mData != null);
        assert(Objects.equals(mData.getId(), "MDataTests"));
        assert(Objects.equals(mData.getBasePath(), System.getProperty("user.dir")));
    }

    @Test
    @DisplayName("Loading Bespoke Data Test")
    public void bespokeDataLoadTest() {
        MData mData = MData.create("MDataTests").build();

        assert(mData != null);
        assert(Objects.equals(mData.getId(), "MDataTests"));
        assert(Objects.equals(mData.getBasePath(), System.getProperty("user.dir")));

        BespokeTestDataContainer dataContainer = mData.loadBespokeData(BespokeTestDataContainer.class);

        assert(dataContainer != null);
        assert(dataContainer.getData() == null);
    }
}
