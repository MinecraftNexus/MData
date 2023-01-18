package dev.millzy.mdata;

import java.io.*;
import java.nio.file.Paths;

/**
 * Class to represent a container storing a single object.
 * @param <V> Object type that is contained in this container.
 * @since 0.1.0
 */
public abstract class DataContainer<V extends Serializable> {
    private V data;
    private final MData mData;

    /**
     * Creates a new container using an existing data instance.
     * @param data data to place in container.
     * @since 0.1.0
     */
    public DataContainer(MData mData, V data) {
        this.mData = mData;
        this.data = data;
    }

    /**
     * Loads already stored data into the constructed container. Data will be null if data is not stored.
     * @throws IOException Any of the usual Input/Output-related exceptions.
     * @throws ClassNotFoundException If the object is unable to be deserialized. Most likely due to data not implementing {@link Serializable}.
     * @since 0.1.0
     */
    @SuppressWarnings("unchecked")
    public DataContainer(MData mData) throws IOException, ClassNotFoundException {
        this.mData = mData;

        File dir = new File(getDirectoryPath());
        dir.mkdirs();

        File file = new File(getFilePath());
        if (!file.exists()) {
            data = null;
            return;
        }

        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);

        data = (V) ois.readObject();

        ois.close();
        fis.close();
    }

    protected void save() throws IOException {
        File dir = new File(getDirectoryPath());
        dir.mkdirs();

        File file = new File(getFilePath());
        if (!file.exists())
            file.createNewFile();

        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(data);

        oos.close();
        fos.close();
    }

    /**
     * @return The data contained by this DataContainer
     * @since 0.1.0
     */
    public V getData() {
        return data;
    }

    /**
     * Sets the data that this DataContainer contains.
     * @param value Data to set.
     * @since 0.1.0
     */
    public void setData(V value) {
        data = value;
    }

    /**
     * @return The name of the file saved data will be written to (including extension).
     * @since 0.1.0
     */
    public String getFileName() {
        return String.format("%s.%s", getDataId(), mData.getFileExtension());
    }

    /**
     * @return The path to the directory that saved data will be written to.
     * @since 0.1.0
     */
    public String getDirectoryPath() {
        return Paths.get(mData.getBaseDirectory(), mData.getId()).toString();
    }

    /**
     * @return The full path of the file that saved data will be written to.
     * @since 0.1.0
     */
    public String getFilePath() {
        return Paths.get(getDirectoryPath(), getFileName()).toString();
    }

    /**
     * @return The data ID of this container.
     * @since 0.1.0
     */
    public abstract String getDataId();
}
