package cz.buyorborrow.rest.dto.transaction;

import cz.buyorborrow.rest.model.item.Item;
import cz.buyorborrow.rest.model.transaction.TransactionState;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by ekishigo on 16.4.16.
 */
public class TransactionDto {

    @NotNull
    private String id;
    @NotNull
    private Item item;
    @NotNull
    private String initiatorId;
    @NotNull
    private String finisherId;
    @NotNull
    private TransactionState state;
    @NotNull
    private Date creationDate;

    public TransactionDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getInitiatorId() {
        return initiatorId;
    }

    public void setInitiatorId(String initiatorId) {
        this.initiatorId = initiatorId;
    }

    public String getFinisherId() {
        return finisherId;
    }

    public void setFinisherId(String finisherId) {
        this.finisherId = finisherId;
    }

    public TransactionState getState() {
        return state;
    }

    public void setState(TransactionState state) {
        this.state = state;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "TransactionDto{" +
                "id='" + id + '\'' +
                ", item=" + item +
                ", initiatorId=" + initiatorId +
                ", finisherId=" + finisherId +
                ", state=" + state +
                ", creationDate=" + creationDate +
                '}';
    }
}
