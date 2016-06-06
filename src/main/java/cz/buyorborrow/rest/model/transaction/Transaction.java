package cz.buyorborrow.rest.model.transaction;

import cz.buyorborrow.rest.model.item.Item;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

import java.util.Date;

import static cz.buyorborrow.rest.utils.PreCondition.notNull;

/**
 * This class is a model for transaction.
 * Object of this class will be created after user click on BUY Button
 * then added to table in DB
 * also this Transaction should be added to User finisherId model
 * user finisherId should be updated in DB
 * Created by ekishigo on 31.3.16.
 */
public class Transaction {

    @Id
    private String id;
    private Item item;
    @CreatedBy
    private String initiatorId;
    private String finisherId;
    private TransactionState state;
    @CreatedDate
    private Date creationDate;

    public Transaction(String id,
                       Item item,
                       String initiator,
                       String finisher,
                       TransactionState state) {
        this.id = id;
        this.item = item;
        this.finisherId = finisher;
        this.initiatorId = initiator;
        this.state = state;
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
        notNull(item, "Item can't be null");
        this.item = item;
    }

    public String getFinisherId() {
        return finisherId;
    }

    public void setFinisherId(String finisherId) {
        notNull(finisherId, "Seller can't be null");
        this.finisherId = finisherId;
    }

    public String getInitiatorId() {
        return initiatorId;
    }

    public void setInitiatorId(String initiatorId) {
        notNull(initiatorId, "Byuer can't be null");
        this.initiatorId = initiatorId;
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
        return String.format("Transaction of %s. Buyer is %s and finisherId is %s", item, initiatorId, finisherId);
    }
}
