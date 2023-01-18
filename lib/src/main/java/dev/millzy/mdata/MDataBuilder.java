package dev.millzy.mdata;

/**
 * Constructs a new {@link MData} instance.
 * @since 0.1.0
 */
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
     * @since 0.1.0
     */
    public MData build() {
        return new MData(id, baseDirectory, fileExtension);
    }

    /**
     * Sets a base directory where data will be stored in.
     * @param baseDirectory Absolute path for the base directory.
     * @since 0.1.0
     */
    public MDataBuilder withBaseDirectory(String baseDirectory) {
        this.baseDirectory = baseDirectory;
        return this;
    }

    /**
     * Sets a file extension for all created and read files to use.
     * @param fileExtension File extension without the '.' suffix (E.g. dat, ser)
     * @since 0.1.0
     */
    public MDataBuilder withFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
        return this;
    }
}
