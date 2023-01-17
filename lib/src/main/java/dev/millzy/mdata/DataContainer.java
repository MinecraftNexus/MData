package dev.millzy.mdata;

import java.io.*;
import java.nio.file.Paths;

public abstract class DataContainer<V extends Serializable> {
    private V data;
    private MData mData;

    public DataContainer(V data) {
        this.data = data;
    }

    @SuppressWarnings("unchecked")
    protected DataContainer(MData mData) throws IOException, ClassNotFoundException {
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

        ois.readObject();
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

    public V getData() {
        return data;
    }

    public String getFileName() {
        return String.format("%s.%s", getDataId(), mData.getFileExtension());
    }

    public String getDirectoryPath() {
        return Paths.get(mData.getBaseDirectory(), mData.getId()).toString();
    }

    public String getFilePath() {
        return Paths.get(getDirectoryPath(), getFileName()).toString();
    }

    public abstract String getDataId();
}
