package dev.millzy.mdata;

public class MDataBuilder {
    private final String id;
    private String baseDirectory;
    private String fileExtension;

    protected MDataBuilder() {
        this("MData");
    }
    protected MDataBuilder(String id) {
        this.id = id;
        this.baseDirectory = System.getProperty("user.dir");
        this.fileExtension = "dat";
    }

    public MData build() {
        return new MData(id, baseDirectory, fileExtension);
    }

    public MDataBuilder withBaseDirectory(String baseDirectory) {
        this.baseDirectory = baseDirectory;
        return this;
    }

    public MDataBuilder withFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
        return this;
    }
}
