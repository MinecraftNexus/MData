package dev.millzy.mdata;

import java.nio.file.Path;

public class MData {
    private final String id;
    protected Path baseDirectory;

    protected MData() {
        this("MData");
    }
    protected MData(String id) {
        this.id = id;
    }

    public static MDataFactory create(String id) {
        return new MDataFactory(id);
    }

    public static MDataFactory createDefault() {
        return new MDataFactory();
    }


}
