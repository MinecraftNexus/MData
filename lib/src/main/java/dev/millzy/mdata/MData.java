package dev.millzy.mdata;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class MData {
    private final String id;
    private final String basePath;

    private MData(MDataBuilder builder) {
        this.id = builder.id;
        this.basePath = builder.basePath;
    }

    public static MDataBuilder create(String id) {
        return MDataBuilder.create(id);
    }

    public String getId() {
        return id;
    }

    public String getBasePath() {
        return basePath;
    }

    public <T extends Data, R extends BespokeDataContainer<T>> R loadBespokeData(@NotNull Class<R> clazz) {
        try {
            return clazz.getConstructor(MData.class).newInstance(this);
        } catch (InvocationTargetException | IllegalAccessException | InstantiationException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public <T extends Data, R extends BespokeDataContainer<T>> void saveBespokeData(R container) {
        try {
            container.save(this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static class MDataBuilder {
        private final String id;
        private String basePath;

        public MDataBuilder(String id) {
            this.id = id;
            this.basePath = System.getProperty("user.dir");
        }

        @Contract("_ -> new")
        private static @NotNull MDataBuilder create(String id) {
            return new MDataBuilder(id);
        }

        public MDataBuilder withBasePath(String basePath) {
            this.basePath = basePath;
            return this;
        }

        public MData build() {
            return new MData(this);
        }
    }
}
