package jnode.ui.shared;

public interface Lambda<T, R> {
    R execute(T arg);
}
