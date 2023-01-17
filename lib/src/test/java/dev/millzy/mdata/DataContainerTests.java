package dev.millzy.mdata;

import dev.millzy.mdata.data.TestData;
import dev.millzy.mdata.data.TestDataContainer;
import org.junit.jupiter.api.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@DisplayName("DataContainer Tests")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DataContainerTests {
    private MData mData;

    @BeforeAll
    public void setup() {
        mData = MData.create("DataContainerTests").build();
    }

    @DisplayName("Load Null File")
    @Test
    @Order(1)
    public void loadNullTest() {
        try {
            TestDataContainer container = mData. loadDataInto(TestDataContainer.class);
            assert container != null;
            TestData data = container.getData();
            assert data == null;

        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @DisplayName("Try Load Null File")
    @Test
    @Order(2)
    public void tryLoadNullTest() {
        TestDataContainer container = mData.tryLoadDataInto(TestDataContainer.class);
        assert container != null;
        TestData data = container.getData();
        assert data == null;
    }

    @Test
    @Order(3)
    @DisplayName("Save To File")
    public void saveTest() {
        TestDataContainer container = new TestDataContainer(mData, new TestData());
        TestData data = container.getData();

        data.testString = "First Save";
        data.testString2 = "This is a first save.";

        try {
            mData.saveDataFrom(container);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        TestDataContainer loadedContainer = mData.tryLoadDataInto(TestDataContainer.class);
        assert loadedContainer != null;
        TestData loadedData = loadedContainer.getData();
        assert loadedData != null;
        assert loadedData.testString.equals("First Save");
        assert loadedData.testString2.equals("This is a first save.");
    }

    @Test
    @Order(4)
    @DisplayName("Try Save To File")
    public void trySaveTest() {
        TestDataContainer container = mData.tryLoadDataInto(TestDataContainer.class);
        TestData data = container.getData();

        data.testString = "Second Save";
        data.testString2 = "This is a second save.";

        boolean result = mData.trySaveDataFrom(container);
        assert result;

        TestDataContainer loadedContainer = mData.tryLoadDataInto(TestDataContainer.class);
        assert loadedContainer != null;
        TestData loadedData = loadedContainer.getData();
        assert loadedData != null;
        assert loadedData.testString.equals("Second Save");
        assert loadedData.testString2.equals("This is a second save.");
    }

    @AfterAll
    public void cleanup() {
        TestDataContainer container = new TestDataContainer(mData, null);

        File file = new File(container.getFilePath());
        file.deleteOnExit();

        File dir = new File(container.getDirectoryPath());
        dir.deleteOnExit();
    }

}
