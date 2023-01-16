package dev.millzy.mdata;

import dev.millzy.mdata.data.BespokeTestData;
import dev.millzy.mdata.data.BespokeTestDataContainer;
import org.junit.jupiter.api.*;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MDataTests {
    @Test
    @Order(1)
    @DisplayName("MData Builder Test")
    public void builderTest() {
        MData mData = MData.create("MDataTests").build();

        assert(mData != null);
        assert(Objects.equals(mData.getId(), "MDataTests"));
        assert(Objects.equals(mData.getBasePath(), System.getProperty("user.dir")));
    }

    @Test
    @Order(2)
    @DisplayName("Loading Bespoke Data Test")
    public void bespokeDataLoadTest() {
        MData mData = MData.create("MDataTests").build();

        assert mData != null;
        assert Objects.equals(mData.getId(), "MDataTests");
        assert Objects.equals(mData.getBasePath(), System.getProperty("user.dir"));

        BespokeTestDataContainer dataContainer = mData.loadBespokeData(BespokeTestDataContainer.class);

        assert(dataContainer != null);
        assert(dataContainer.getData() == null);
    }

    @Test
    @Order(3)
    @DisplayName("Saving Bespoke Data Test")
    public void bespokeDataSaveTest() {
        MData mData = MData.create("MDataTests").build();
        BespokeTestDataContainer dataContainer = mData.loadBespokeData(BespokeTestDataContainer.class);

        assert dataContainer.getData() == null;

        dataContainer.setData(new BespokeTestData());

        assert dataContainer.getData() != null;

        BespokeTestData data = dataContainer.getData();
        data.testString = "Modified Test String";
        data.testInt = 35;
        data.testBoolean = false;

        mData.saveBespokeData(dataContainer);

        String filename = dataContainer.getDataId() + ".dat";
        String directoryPath = Paths.get(mData.getBasePath(), mData.getId()).toString();
        File file = new File(Paths.get(directoryPath, filename).toString());

        assert file.exists();

        BespokeTestDataContainer modifiedDataContainer = mData.loadBespokeData(BespokeTestDataContainer.class);
        BespokeTestData modifiedData = modifiedDataContainer.getData();

        assert Objects.equals(modifiedData.testString, "Modified Test String");
        assert data.testInt == 35;
        assert !data.testBoolean;

        /// CLEANUP
        file.deleteOnExit();
    }
}
