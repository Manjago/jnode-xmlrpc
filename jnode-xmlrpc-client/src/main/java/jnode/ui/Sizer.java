package jnode.ui;

import java.awt.*;

/**
 * @author Kirill Temnenkov (ktemnenkov@intervale.ru)
 */
public final class Sizer {

    public static final int UNSET = 100;
    private static final int HEIGHT_INTERNAL_UNSET_MULT = 4;
    private static final int WIDTH_INTERNAL_UNSET_MULT = 3;

    private Sizer() {
    }

    public static Rectangle bigSize() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        return new Rectangle(UNSET, UNSET,
                screenSize.width - UNSET * 2,
                screenSize.height - UNSET * 2);
    }

    private static Rectangle internalRectangle() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        return new Rectangle(UNSET, UNSET, screenSize.width - UNSET * WIDTH_INTERNAL_UNSET_MULT, screenSize.height - UNSET * HEIGHT_INTERNAL_UNSET_MULT);
    }

    public static Point internalLocation() {
        return new Point(UNSET / 2, UNSET / 2);
    }

    public static Dimension internalSize() {
        Rectangle r = internalRectangle();
        return new Dimension((int) Math.round(r.getWidth()), (int) Math.round(r.getHeight()));
    }
}
