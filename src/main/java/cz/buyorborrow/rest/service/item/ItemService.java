package cz.buyorborrow.rest.service.item;

import cz.buyorborrow.rest.dto.item.ItemDto;
import cz.buyorborrow.rest.dto.user.UserDto;
import cz.buyorborrow.rest.model.item.Category;
import cz.buyorborrow.rest.model.item.ItemState;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by ekishigo on 1.4.16.
 */
public interface ItemService {

    List<ItemDto> getAll();

    Page<ItemDto> getItems(Category category, ItemState state, Pageable pageable);

    Page<ItemDto> getItemsBelongsTo(String ownerID, Pageable pageable);

    ItemDto getItem(String id);

    ItemDto create(ItemDto item);

    ItemDto update(String id, ItemDto itemDto);

    ItemDto delete(String id);
}
