package cz.buyorborrow.rest.dto.item;

import cz.buyorborrow.rest.model.item.Category;
import cz.buyorborrow.rest.model.item.Item;
import cz.buyorborrow.rest.model.item.ItemState;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 * Created by ekishigo on 1.4.16.
 */
public class ItemDto {

    private String          id;
    @NotEmpty
    @Size(max = Item.MAX_LENGTH_TITLE)
    private String          title;
    @NotEmpty
    @Size(max = Item.MAX_LENGTH_DESCRIPTION)
    private String          description;
    @Digits(integer = 6, fraction = 0)
    private int             price;                  // all prices will be integers
    @NotNull
    private Category        category;
    @NotNull
    private ItemState       state;
    //@NotNull
    private String ownerId;
    @NotNull
    private List<String>    photoURLs;

    private Date creationDate;

    public ItemDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public ItemState getState() {
        return state;
    }

    public void setState(ItemState state) {
        this.state = state;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public List<String> getPhotoURLs() {
        return photoURLs;
    }

    public void setPhotoURLs(List<String> photoURLs) {
        this.photoURLs = photoURLs;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "ItemDto{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", category=" + category +
                ", state=" + state +
                ", ownerId=" + ownerId +
                ", photoURLs=" + photoURLs +
                ", creationDate=" + creationDate +
                '}';
    }
}
