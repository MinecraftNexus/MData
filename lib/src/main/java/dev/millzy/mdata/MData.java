package dev.millzy.mdata;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Management and configuration class for {@link DataContainer}s.
 * @since 0.1.0
 */
public class MData {
    private final String id;
    private final String baseDirectory;
    private final String fileExtension;

    protected MData(String id, String baseDirectory, String fileExtension) {
        this.id = id;
        this.baseDirectory = baseDirectory;
        this.fileExtension = fileExtension;
    }

    /**
     * Creates a new MDataBuilder for creating an MData instance
     * @param id ID to use for data storage (Influences directory storage name. E.g. ~/m_data_id/)
     * @return MDataBuilder instance created.
     * @see MDataBuilder
     * @since 0.1.0
     */
    public static MDataBuilder create(String id) {
        return new MDataBuilder(id);
    }

    /**
     * Loads data into a container. Only a specific container type can hold a specific piece of stored data.
     * @param clazz Class of container.
     * @return Created container with data loaded into it.
     * @param <T> Data type.
     * @param <R> DataContainer type.
     * @throws NoSuchMethodException If the container's constructor cannot be found.
     * @throws InvocationTargetException If the container's constructor throws an exception.
     * @throws InstantiationException If the class that declares the underlying constructor represents an abstract class.
     * @throws IllegalAccessException If the container's Constructor object is enforcing Java language access control and the underlying constructor is inaccessible.
     * @see DataContainer
     * @see Serializable
     * @since 0.1.0
     */
    public <T extends Serializable, R extends DataContainer<T>> R loadDataInto(@NotNull Class<R> clazz)
            throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
         Constructor<R> ctor = clazz.getConstructor(MData.class);
         return ctor.newInstance(this);
    }

    /**
     * Safely loads data into a container. Only a specific container type can hold a specific piece of stored data.
     * @param clazz Class of container.
     * @return Created container with data loaded into it or null if an exception was thrown.
     * @param <T> Data type.
     * @param <R> DataContainer type.
     * @see DataContainer
     * @see Serializable
     * @since 0.1.0
     */
    public <T extends Serializable, R extends DataContainer<T>> R tryLoadDataInto(@NotNull Class<R> clazz) {
        try {
            return loadDataInto(clazz);
        } catch (InvocationTargetException | NoSuchMethodException | InstantiationException | IllegalAccessException e) {
            return null;
        }
    }

    /**
     * Writes data in a container to a file to be loaded later.
     * @param dataContainer Container to save data from.
     * @param <T> Data type.
     * @param <R> DataContainer type.
     * @see DataContainer
     * @see Serializable
     * @since 0.1.0
     */
    public <T extends Serializable, R extends DataContainer<T>> void saveDataFrom(R dataContainer) throws IOException {
        dataContainer.save();
    }

    /**
     * Safely writes data in a container to a file to be loaded later.
     * @param dataContainer Container to save data from.
     * @return True if data was saved successfully. False otherwise.
     * @param <T> Data type
     * @param <R> DataContainer type
     * @see DataContainer
     * @see Serializable
     * @since 0.1.0
     */
    public <T extends Serializable, R extends DataContainer<T>> boolean trySaveDataFrom(R dataContainer) {
        try {
            saveDataFrom(dataContainer);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * @return The ID of the MData instance.
     * @since 0.1.0
     */
    public String getId() {
        return id;
    }

    /**
     * @return The base directory of the MData instance.
     * @since 0.1.0
     */
    public String getBaseDirectory() {
        return baseDirectory;
    }

    /**
     * @return The desired file extension of the MData instance.
     * @since 0.1.0
     */
    public String getFileExtension() {
        return fileExtension;
    }
}
