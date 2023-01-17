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

    /**
     * Builds a new MData instance.
     * @return Constructed MData instance.
     * @see MData
     */
    public MData build() {
        return new MData(id, baseDirectory, fileExtension);
    }

    /**
     * Sets a base directory where data will be stored in.
     * @param baseDirectory Absolute path for the base directory
     */
    public MDataBuilder withBaseDirectory(String baseDirectory) {
        this.baseDirectory = baseDirectory;
        return this;
    }

    /**
     * Sets a file extension for all created and read files to use.
     * @param fileExtension File extension without the '.' suffix (E.g. dat, ser)
     */
    public MDataBuilder withFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
        return this;
    }
}
