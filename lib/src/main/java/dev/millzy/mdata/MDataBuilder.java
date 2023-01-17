package dev.millzy.mdata;

public class MDataBuilder {
    private final String id;
    private String baseDirectory;

    protected MDataBuilder() {
        this("MData");
    }
    protected MDataBuilder(String id) {
        this.id = id;

        this.baseDirectory = System.getProperty("user.dir");
    }

    public MData build() {
        return new MData(id, baseDirectory);
    }

    public MDataBuilder withBaseDirectory(String baseDirectory) {
        this.baseDirectory = baseDirectory;
        return this;
    }
}
