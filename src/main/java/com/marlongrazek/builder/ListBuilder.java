package com.marlongrazek.builder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

interface Iterator<E> {

    ListBuilder<E> add(E e);

    ListBuilder<E> add(Collection<? extends E> e);

    ListBuilder<E> add(E e, int index);

    ListBuilder<E> add(Collection<? extends E> e, int index);

    ListBuilder<E> clear();

    boolean contains(E e);

    boolean contains(Collection<? extends E> e);

    E get(int index);

    int indexOf(E e);

    ListBuilder<E> remove(E e);

    ListBuilder<E> removeAt(int index);

    ListBuilder<E> removeIf(Predicate<? super E> filter);

    ListBuilder<E> set(Collection<? extends E> e);

    ListBuilder<E> set(E e, int indexFrom, int indexTo);

    ListBuilder<E> set(Collection<? extends E> e, int indexFrom, int indexTo);

    int size();

    ListBuilder<E> sort();

    List<E> subList(int indexFrom, int indexTo);

    Object[] toArray();

    List<E> toList();

    ArrayList<E> toArrayList();
}

public class ListBuilder<E> implements Iterator<E> {

    List<E> list = new ArrayList<>();

    @Override
    public ListBuilder<E> add(E e) {
        list.add(e);
        return this;
    }

    @Override
    public ListBuilder<E> add(Collection<? extends E> e) {
        list.addAll(e);
        return this;
    }

    @Override
    public ListBuilder<E> add(E e, int index) {
        ListBuilder<E> builder = new ListBuilder<>();
        builder.add(list.subList(0, index)).add(e).add(list.subList(index + 1, size()));
        list = builder.toList();
        return this;
    }

    @Override
    public ListBuilder<E> add(Collection<? extends E> e, int index) {
        ListBuilder<E> builder = new ListBuilder<>();
        builder.add(list.subList(0, index)).add(e).add(list.subList(index + 1, size()));
        list = builder.toList();
        return this;
    }

    @Override
    public ListBuilder<E> clear() {
        list.clear();
        return this;
    }

    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    @Override
    public boolean contains(Collection<? extends E> e) {
        return list.containsAll(e);
    }

    @Override
    public E get(int index) {
        return list.get(index);
    }

    @Override
    public int indexOf(E e) {
        return list.indexOf(e);
    }

    @Override
    public ListBuilder<E> remove(E e) {
        list.remove(e);
        return this;
    }

    @Override
    public ListBuilder<E> removeAt(int index) {
        E e = list.get(index);
        list.remove(e);
        return this;
    }

    @Override
    public ListBuilder<E> removeIf(Predicate<? super E> filter) {
        list.removeIf(filter);
        return this;
    }

    @Override
    public ListBuilder<E> set(Collection<? extends E> e) {
        return null;
    }

    @Override
    public ListBuilder<E> set(E e, int indexFrom, int indexTo) {
        List<E> sublist = list.subList(indexFrom, indexTo);
        sublist.clear();
        sublist.add(e);
        List<E> sublist0 = list.subList(0, indexFrom);
        List<E> sublist1 = list.subList(indexFrom + 1, size() + 1);
        ListBuilder<E> builder = new ListBuilder<>();
        builder.add(sublist0).add(sublist).add(sublist1);
        list = builder.toList();
        return this;
    }

    @Override
    public ListBuilder<E> set(Collection<? extends E> e, int indexFrom, int indexTo) {
        List<E> sublist = list.subList(indexFrom, indexTo);
        sublist.clear();
        sublist.addAll(e);
        List<E> sublist0 = list.subList(0, indexFrom);
        List<E> sublist1 = list.subList(indexFrom + sublist.size(), size() + sublist.size());
        ListBuilder<E> builder = new ListBuilder<>();
        builder.add(sublist0).add(sublist).add(sublist1);
        list = builder.toList();
        return this;
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public ListBuilder<E> sort() {
        return this;
    }

    @Override
    public List<E> subList(int indexFrom, int indexTo) {
        return list.subList(indexFrom, indexTo);
    }

    @Override
    public Object[] toArray() {
        return list.toArray();
    }

    @Override
    public List<E> toList() {
        return list;
    }

    @Override
    public ArrayList<E> toArrayList() {
        return new ArrayList<>(list);
    }
}
