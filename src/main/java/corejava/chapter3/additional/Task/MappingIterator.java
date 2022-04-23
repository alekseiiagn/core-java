package corejava.chapter3.additional.Task;

import java.util.Iterator;
import java.util.function.Function;

public interface MappingIterator<T> extends Iterator<T> {

    static <T> MappingIterator<T> fromIterator(Iterator<T> iterator) {
        return new MappingIterator<>() {
            @Override
            public <TO> MappingIterator<TO> map(Function<T, TO> function) {
                return fromIterator(new Iterator<>() {
                    @Override
                    public boolean hasNext() {
                        return iterator.hasNext();
                    }

                    @Override
                    public TO next() {
                        return function.apply(iterator.next());
                    }
                });
            }

            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public T next() {
                return iterator.next();
            }
        };
    }

    <TO> MappingIterator<TO> map(Function<T, TO> function);
}
