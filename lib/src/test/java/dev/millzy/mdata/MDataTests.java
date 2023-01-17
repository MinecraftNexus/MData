package dev.millzy.mdata;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MDataTests {
    @Test
    @Order(1)
    public void defaultBuildTest() {
        MData mData = MData.create("MDataTests").build();

        assert mData != null;
        assert mData.getId().equals("MDataTests");
        assert mData.getBaseDirectory().equals(System.getProperty("user.dir"));
    }

    @Test
    @Order(2)
    public void nonDefaultBuildTest() {
        MData mData = MData.create("MDataTests").withBaseDirectory(System.getProperty("user.home")).build();

        assert mData != null;
        assert mData.getId().equals("MDataTests");
        assert mData.getBaseDirectory().equals(System.getProperty("user.home"));
    }
}
