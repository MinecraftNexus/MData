package dev.millzy.mdata;

import org.junit.jupiter.api.*;

@DisplayName("MData Tests")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MDataTests {
    @DisplayName("Default Build")
    @Test
    @Order(1)
    public void defaultBuildTest() {
        MData mData = MData.create("MDataTests").build();

        assert mData != null;
        assert mData.getId().equals("MDataTests");
        assert mData.getBaseDirectory().equals(System.getProperty("user.dir"));
    }

    @DisplayName("Non-Default Build")
    @Test
    @Order(2)
    public void nonDefaultBuildTest() {
        MData mData = MData.create("MDataTests").withBaseDirectory(System.getProperty("user.home")).withFileExtension("bin").build();

        assert mData != null;
        assert mData.getId().equals("MDataTests");
        assert mData.getBaseDirectory().equals(System.getProperty("user.home"));
        assert mData.getFileExtension().equals("bin");
    }
}
