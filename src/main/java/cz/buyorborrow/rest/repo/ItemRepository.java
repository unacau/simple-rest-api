package cz.buyorborrow.rest.repo;

import cz.buyorborrow.rest.model.item.Category;
import cz.buyorborrow.rest.model.item.Item;
import cz.buyorborrow.rest.model.item.ItemState;
import cz.buyorborrow.rest.model.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by ekishigo on 1.4.16.
 */
public interface ItemRepository extends MongoRepository<Item, String> {

    Page<Item> findByCategoryAndState(Category category, ItemState state, Pageable pageable);

    Page<Item> findByOwnerId(String ownerId, Pageable pageable);

    Item findOne(String id);
}
