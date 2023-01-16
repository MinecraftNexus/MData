package dev.millzy.mdata;

import java.nio.file.Path;

public class MDataFactory {
    private MData mData;

    private Path baseDirectory = null;

    protected MDataFactory(String id) {
        mData = new MData(id);
    }

    protected MDataFactory() {
        mData = new MData();
    }

    public MDataFactory withBaseDirectory(Path path) {
        baseDirectory = path;
        return this;
    }

    public MDataFactory withBaseDirectory(String path) {
        baseDirectory = Path.of(path);
        return this;
    }

    public MData build() {
        if (baseDirectory == null)
            baseDirectory = Path.of(System.getProperty("user.dir"));

        mData.baseDirectory = baseDirectory;

        return mData;
    }
}
