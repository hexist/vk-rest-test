package com.gusev.vkresttest.services;

import java.util.ArrayList;
import java.util.List;

public class ApiHelper {
    // Generic class to transform collections
    private abstract static class CollectionTransformer<E, F> {

        abstract F transform(E e);

        public List<F> transform(List<E> list) {
            List<F> newList = new ArrayList<F>();
            for (E e : list) {
                newList.add(transform(e));
            }
            return newList;
        }
    }

    // Method that transform Integer to String
// this override the transform method to specify the transformation
    public static <T> List<T> mapObjectToClassCollection(List<Object> list, Class<T> clazz) {

        CollectionTransformer transformer = new CollectionTransformer<Object, T>() {
            @Override
            T transform(Object o) {
                return (T) o;
            }
        };

        return transformer.transform(list);
    }

}
