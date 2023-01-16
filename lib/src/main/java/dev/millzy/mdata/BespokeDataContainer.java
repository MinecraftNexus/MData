package dev.millzy.mdata;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Paths;

public abstract class BespokeDataContainer<T extends Data> extends DataContainer<T> {
    private MData mData;

    public BespokeDataContainer(MData mData) {
        super(mData);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void load(Class<T> clazz) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException, ClassNotFoundException {
        File file = new File(getFilename());
        if (!file.exists()) {
            contain(clazz.getConstructor().newInstance());
        }
        else {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            contain((T) ois.readObject());

            ois.close();
            fis.close();
        }

        if (open() == null) {
            contain(clazz.getConstructor().newInstance());
        }
    }

    @Override
    @SuppressWarnings("unused")
    public void unload() throws IOException {
        File file = new File(getFilename());

        boolean __ = file.mkdirs();
        boolean ___ =file.createNewFile();

        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(open());

        oos.close();
        fos.close();
    }

    public String getFilename() {
        return Paths.get(mData.baseDirectory, getName() + ".dat").toString();
    }
}
