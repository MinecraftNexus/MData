package dev.millzy.mdata;

import java.io.File;

public class MDataFactory {
    private final MData mData;

    private String baseDirectory = null;

    protected MDataFactory(String id) {
        mData = new MData(id);
    }

    protected MDataFactory() {
        mData = new MData();
    }


    public MDataFactory withBaseDirectory(String path) {
        baseDirectory = path;
        return this;
    }

    public MData build() {
        if (baseDirectory == null)
            baseDirectory = System.getProperty("user.dir");

        mData.baseDirectory = baseDirectory;

        new File(baseDirectory).mkdirs();

        return mData;
    }
}
