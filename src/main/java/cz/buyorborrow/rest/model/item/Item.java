package cz.buyorborrow.rest.model.item;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

import static cz.buyorborrow.rest.utils.PreCondition.isTrue;
import static cz.buyorborrow.rest.utils.PreCondition.notEmpty;
import static cz.buyorborrow.rest.utils.PreCondition.notNull;

/**
 * This class represents the model of a domain object Item.
 * Patter Builder is used here. So you is available to build the object with optional attributes.
 * This class is used as a model to be stored in a NoSQL Mongo Database.
 * Created by ekishigo on 30.3.16.
 */
public class Item {

    public static final int MAX_LENGTH_TITLE = 30;
    public static final int MAX_LENGTH_DESCRIPTION = 340;

    @Id
    private String id;
    private String title;
    private String description;
    private int price;                  // all prices will be integers
    private Category category;
    private ItemState state;
    @CreatedBy
    private String ownerId;
    private List<String> photoURLs;
    @CreatedDate
    private Date creationDate;

    public Item() {
    }

    private Item(ItemBuilder builder) {
        this.title = builder.title;
        this.description = builder.description;
        this.price = builder.price;
        this.category = builder.category;
        this.state = builder.state;
        this.ownerId = builder.owner;
        this.photoURLs = builder.photoURLs;
        this.creationDate = builder.creationDate;
        this.category = Category.SPORT;
    }

    /**
     * Returns the ID of this object.
     *
     * @return ID
     */
    public String getId() {
        return id;
    }

    /**
     * Set the ID of this object.
     *
     * @param id to be changed.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Returns the title of the object.
     *
     * @return the title of the object.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set the title of the object.
     *
     * @param title new title to be changed.
     * @throws IllegalArgumentException if title is empty or longer than specified size.
     */
    public void setTitle(String title) {
        checkTitle(title);
        this.title = title;
    }

    /**
     * Returns the price of the object.
     *
     * @return price ob the object.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Set the price of the object.
     *
     * @param price new price to be changed.
     * @throws IllegalArgumentException if price is negative.
     */
    public void setPrice(int price) {
        checkPrice(price);
        this.price = price;
    }

    /**
     * Returns the description of the object.
     *
     * @return description of the object.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set description of the object.
     *
     * @param description to be changed.
     * @throws IllegalArgumentException if description is longer than 350 chars.
     */
    public void setDescription(String description) {
        checkDescription(description);
        this.description = description;
    }

    /**
     * Returns the ownerId of the object.
     *
     * @return ownerId of the object.
     */
    public String getOwnerId() {
        return ownerId;
    }

    /**
     * Set the ownerId of the object.
     *
     * @param ownerId of the object.
     */
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    /**
     * Returns the {@link ItemState} of the object. Which can be SOLD or NOT_SOLD yet.
     *
     * @return state of the oject.
     */
    public ItemState getState() {
        return state;
    }

    /**
     * Set the {@link ItemState} of the object.
     *
     * @param state of the object.
     */
    public void setState(ItemState state) {
        this.state = state;
    }

    /**
     * Returns the {@link Category} of the object.
     *
     * @return cetegory of the object.
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Set {@link Category} of the object.
     *
     * @param category of the object to be set.
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * Returns {@link List} of strings, each of them is an URL to the picture of the object.
     *
     * @return list of URLs to photos.
     */
    public List<String> getPhotoURLs() {
        return photoURLs;
    }

    /**
     * Set the list of URLs, each URLs is a link to one picture for the object.
     *
     * @param photoURLs list of URLs to photos.
     */
    public void setPhotoURLs(List<String> photoURLs) {
        this.photoURLs = photoURLs;
    }

    //TODO Javadoc
    public Date getCreationDate() {
        return creationDate;
    }

    //TODO Javadoc
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Returns nice human-readable string, represents the object.
     *
     * @return string as a description of the object.
     */
    @Override
    public String toString() {
        return String.format("Item %s, price %s, category %s, belongs to %s", title, price, category, ownerId);
    }

    private void checkTitle(String title) {
        notNull(title, "Title can't be null.");
        notEmpty(title, "Title can't be empty.");
        isTrue(title.length() <= MAX_LENGTH_TITLE,
                "Title can't be longer than %d characters.",
                MAX_LENGTH_TITLE
        );
    }

    private void checkDescription(String description) {
        notNull(description, "Description can't be null.");
        notEmpty(description, "Description can't be empty.");
        isTrue(description.length() <= MAX_LENGTH_DESCRIPTION,
                "Description can't be longer than %d characters.",
                MAX_LENGTH_DESCRIPTION
        );
    }

    private void checkPrice(int price) {
        isTrue(price >= 0, "Price can't be less than zero.");
    }

    public static ItemBuilder getItemBuilder(String title, int price, String description) {
        return new ItemBuilder(title, price, description);
    }

    /**
     * This class is a builder for class Item.
     */
    public static class ItemBuilder {
        //required attributes
        private final String title;
        private final int price;
        private final String description;

        //optional attributes
        private Category category;
        private ItemState state;
        private String owner;
        private List<String> photoURLs;
        private Date creationDate;

        public ItemBuilder(String title, int price, String description) {
            this.title = title;
            this.price = price;
            this.description = description;
        }

//        public ItemBuilder withDescription(String desc) {
//            this.description = desc;
//            return this;
//        }

        /**
         * Set an optional {@link ItemState} attribute for the object.
         * Returns the instance of item builder with state.
         *
         * @param state to be set.
         * @return builder object.
         */
        public ItemBuilder withState(ItemState state) {
            this.state = state;
            return this;
        }

        public ItemBuilder withOwner(String owner) {
            this.owner = owner;
            return this;
        }

        public ItemBuilder withCategory(Category category) {
            this.category = category;
            return this;
        }

        public ItemBuilder withPhotos(List<String> photos) {
            this.photoURLs = photos;
            return this;
        }

        public ItemBuilder withDate(Date creationDate) {
            this.creationDate = creationDate;
            return this;
        }

        /**
         * Returns new {@link Item} object, constructed with this builder.
         *
         * @return new {@link Item} object.
         * @throws IllegalArgumentException if title is longer than specified (30 chars).
         * @throws IllegalArgumentException if title is empty.
         * @throws NullPointerException     if title is null.
         * @throws IllegalArgumentException if description is longer than specified (340 chars).
         * @throws IllegalArgumentException if description is null.
         * @throws NullPointerException     if description is null.
         * @throws IllegalArgumentException if price is negative.
         */
        public Item build() {
            Item build = new Item(this);
            build.checkTitle(build.getTitle());
            build.checkPrice(build.getPrice());
            build.checkDescription(build.getDescription());
            return build;
        }
    }
}
