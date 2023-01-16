package dev.millzy.mdata;

import com.google.j2objc.annotations.ReflectionSupport;

import java.io.*;
import java.nio.file.Paths;

public abstract class BespokeDataContainer<T extends Data> {
    T data;

    @SuppressWarnings("unchecked")
    public BespokeDataContainer(MData mData) throws IOException, ClassNotFoundException {
        String filename = getDataId() + ".dat";
        String directoryPath = Paths.get(mData.getBasePath(), mData.getId()).toString();

        File dir = new File(directoryPath);
        dir.mkdirs();

        File file = new File(Paths.get(directoryPath, filename).toString());

        if (!file.exists()) {
            data = null;
            return;
        }

        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);

        data = (T) ois.readObject();

        ois.close();
        fis.close();
    }

    public void save(MData mData) throws IOException {
        String filename = getDataId() + ".dat";
        String directoryPath = Paths.get(mData.getBasePath(), mData.getId()).toString();

        File dir = new File(directoryPath);
        dir.mkdirs();

        File file = new File(Paths.get(directoryPath, filename).toString());

        if (!file.exists()) {
            file.createNewFile();
        }

        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(data);

        oos.close();
        fos.close();
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public abstract String getDataId();
}
