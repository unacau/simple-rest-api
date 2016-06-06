package cz.buyorborrow.rest.model.item;

/**
 * This class represents the enumeration of states of a particular item for Item class.
 * Item can be either sold or not sold.
 * Created by ekishigo on 30.3.16.
 */
public enum ItemState {

    SOLD("Sold items", 1),
    NOT_SOLD("Available items", 2);

    private final String desc;
    private final int code;

    ItemState(String desc, int code) {
        this.desc = desc;
        this.code = code;
    }

    @Override
    public String toString() {
        return desc;
    }
}
