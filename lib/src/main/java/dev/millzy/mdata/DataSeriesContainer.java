package dev.millzy.mdata;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public abstract class DataSeriesContainer<E extends Serializable> extends DataContainer<ArrayList<E>> {
    public DataSeriesContainer(MData mData, ArrayList<E> data) {
        super(mData, data);
    }

    public DataSeriesContainer(MData mData) throws IOException, ClassNotFoundException {
        super(mData);
    }

    /**
     * {@link ArrayList#add(int, Object)}
     */
    public void add(int index, E element) {
        getData().add(index, element);
    }

    /**
     * {@link ArrayList#add(Object)}
     */
    public boolean add(E e) {
        return getData().add(e);
    }

    /**
     * {@link ArrayList#addAll(int, Collection)}
     */
    public boolean addAll(int index, Collection<? extends E> c) {
        return getData().addAll(index, c);
    }

    /**
     * {@link ArrayList#addAll(Collection)}
     */
    public boolean addAll(Collection<? extends E> c) {
        return getData().addAll(c);
    }

    /**
     * {@link ArrayList#clear()}
     */
    public void clear() {
        getData().clear();
    }

    /**
     * {@link ArrayList#contains(Object)}
     */
    @SuppressWarnings("all")
    public boolean contains(Object o) {
        return getData().contains(o);
    }

    /**
     * {@link ArrayList#ensureCapacity(int)}
     */
    public void ensureCapacity(int minCapacity) {
        getData().ensureCapacity(minCapacity);
    }

    /**
     * {@link ArrayList#forEach(Consumer)}
     */
    public void forEach(Consumer<? super E> action) {
        getData().forEach(action);
    }

    /**
     * {@link ArrayList#get(int)}
     */
    public E get(int index) {
        return getData().get(index);
    }

    /**
     * {@link ArrayList#indexOf(Object)}
     */
    @SuppressWarnings("all")
    public int indexOf(Object o) {
        return getData().indexOf(o);
    }

    /**
     * {@link ArrayList#isEmpty()}
     */
    public boolean isEmpty() {
        return getData().isEmpty();
    }

    /**
     * {@link ArrayList#iterator()}
     */
    public Iterator<E> iterator() {
        return getData().iterator();
    }

    /**
     * {@link ArrayList#lastIndexOf(Object)}
     */
    @SuppressWarnings("all")
    public int lastIndexOf(Object o) {
        return getData().indexOf(o);
    }

    /**
     * {@link ArrayList#listIterator()}
     */
    public ListIterator<E> listIterator() {
        return getData().listIterator();
    }

    /**
     * {@link ArrayList#listIterator(int)}
     */
    public ListIterator<E> listIterator(int index) {
        return getData().listIterator(index);
    }

    /**
     * {@link ArrayList#remove(int)}
     */
    public E remove(int index) {
        return getData().remove(index);
    }

    /**
     * {@link ArrayList#remove(Object)}
     */
    @SuppressWarnings("all")
    public boolean remove(Object o) {
        return getData().remove(o);
    }

    /**
     * {@link ArrayList#removeAll(Collection)}
     */
    public boolean removeAll(Collection<? extends E> c) {
        return getData().removeAll(c);
    }

    /**
     * {@link ArrayList#removeIf(Predicate)}
     */
    public boolean removeIf(Predicate<? super E> filter) {
        return getData().removeIf(filter);
    }

    /**
     * {@link ArrayList#retainAll(Collection)}
     */
    public boolean retainAll(Collection<? extends E> c) {
        return getData().retainAll(c);
    }

    /**
     * {@link ArrayList#set(int, Object)}
     */
    public E set(int index, E element) {
        return getData().set(index, element);
    }

    /**
     * {@link ArrayList#size()}
     */
    public int size() {
        return getData().size();
    }

    /**
     * {@link ArrayList#spliterator()}
     */
    public Spliterator<E> spliterator() {
        return getData().spliterator();
    }

    /**
     * {@link ArrayList#subList(int, int)}
     */
    public List<E> subList(int fromIndex, int toIndex) {
        return getData().subList(fromIndex, toIndex);
    }

    /**
     * {@link ArrayList#toArray()}
     */
    public Object[] toArray() {
        return getData().toArray();
    }

    /**
     * {@link ArrayList#toArray(Object[])}
     */
    public Serializable[] toArray(Serializable[] a) {
        return getData().toArray(a);
    }

    /**
     * {@link ArrayList#trimToSize()}
     */
    public void trimToSize() {
        getData().trimToSize();
    }
}
