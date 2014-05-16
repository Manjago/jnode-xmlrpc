package jnode.ui.shared;

public final class SharedUtils {
    private SharedUtils() {

    }

    public static boolean isEmptyStr(String s){
        return s == null || s.length() == 0;
    }
}
