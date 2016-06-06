package cz.buyorborrow.rest.model.item;

/**
 * This class represents the enumeration of item categories for Item class.
 * Created by ekishigo on 30.3.16.
 */
public enum Category {
    ALL("All goods", 1),
    SPORT("Sport goods", 2),
    HOUSE("Goods for jouse", 3),
    ELEKTRO("Elektro goods", 4),
    FUN("Goods for fun", 5),
    OTHER("Other goods", 6);

    private final String name;
    private final int code;

    Category(String name, int code) {
        this.name = name;
        this.code = code;
    }

    @Override
    public String toString() {
        return name;
    }
}
