package dev.millzy.mdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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
        ObjectInputStream oin = new ObjectInputStream(fis);

        data = (T) oin.readObject();

        oin.close();
        fis.close();
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public abstract String getDataId();
}
