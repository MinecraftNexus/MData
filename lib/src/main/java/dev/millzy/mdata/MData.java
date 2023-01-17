package dev.millzy.mdata;

public class MData {
    private final String id;
    private final String baseDirectory;
    private final String fileExtension;

    protected MData(String id, String baseDirectory, String fileExtension) {
        this.id = id;
        this.baseDirectory = baseDirectory;
        this.fileExtension = fileExtension;
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

    public String getFileExtension() {
        return fileExtension;
    }
}
