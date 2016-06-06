package cz.buyorborrow.rest.model.user;

/**
 * Created by ekishigo on 8.4.16.
 */
public enum PragueCityParts {
    PRAHA_1("Praha 1", 1),
    PRAHA_2("Praha 2", 2),
    PRAHA_3("Praha 3", 3),
    PRAHA_4("Praha 4", 4),
    PRAHA_5("Praha 5", 5),
    PRAHA_6("Praha 6", 6),
    PRAHA_7("Praha 7", 7),
    PRAHA_8("Praha 8", 8),
    PRAHA_9("Praha 9", 9),
    PRAHA_10("Praha 10", 10);

    private final String name;
    private final int Code;

    PragueCityParts(String name, int code) {
        this.name = name;
        Code = code;
    }
}
