package dev.millzy.mdata;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;

public class MData {
    private final String id;
    protected String baseDirectory;

    protected MData() {
        this("MData");
    }
    protected MData(String id) {
        this.id = id;
    }

    public static MDataFactory create(String id) {
        return new MDataFactory(id);
    }

    public static MDataFactory createDefault() {
        return new MDataFactory();
    }

    public <T extends DataContainer> T loadInto(Class<T> clazz) {
        try {
            T container = clazz.getConstructor().newInstance();

            Class<?> dataTypeClass = (Class<?>) ((ParameterizedType) clazz
                    .getGenericSuperclass()).getActualTypeArguments()[0];

            container.load(dataTypeClass);
            return container;
        } catch (InstantiationException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public void unloadFrom(DataContainer container) {
        container.unload();
    }
}
