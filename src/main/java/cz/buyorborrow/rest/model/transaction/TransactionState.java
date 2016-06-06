package cz.buyorborrow.rest.model.transaction;

/**
 * Created by ekishigo on 1.4.16.
 */
public enum TransactionState {
    ACCEPTED("Accepted transaction.", 1),
    NOT_ACCEPTED("Not accepted transaction.", 2);

    private final String name;
    private final int code;

    TransactionState(String name, int code) {
        this.name = name;
        this.code = code;
    }
}
