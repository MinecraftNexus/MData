package dev.millzy.mdata;

public class MData {
    private final String id;
    private final String baseDirectory;

    protected MData(String id, String baseDirectory) {
        this.id = id;
        this.baseDirectory = baseDirectory;
    }

    public static MDataBuilder create(String id) {
        return new MDataBuilder(id);
    }

    public String getId() {
        return id;
    }

    public String getBaseDirectory() {
        return baseDirectory;
    }
}
