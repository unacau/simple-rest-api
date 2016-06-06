package cz.buyorborrow.rest.service.item;

import cz.buyorborrow.rest.dto.item.ItemDto;
import cz.buyorborrow.rest.dto.item.ItemDtoToItemConverter;
import cz.buyorborrow.rest.dto.item.ItemToItemDtoConverter;
import cz.buyorborrow.rest.model.item.Category;
import cz.buyorborrow.rest.model.item.Item;
import cz.buyorborrow.rest.model.item.ItemState;
import cz.buyorborrow.rest.repo.ItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ekishigo on 1.4.16.
 */
@Service
public class ItemServiceImpl implements ItemService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ItemServiceImpl.class);
    private final ItemRepository itemRepository;
    private final ItemDtoToItemConverter toModelConverter = new ItemDtoToItemConverter();
    private final ItemToItemDtoConverter toDtoConverter = new ItemToItemDtoConverter();

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<ItemDto> getAll() {
        LOGGER.debug("Getting all items");
        return toDtoConverter.convertCollection(itemRepository.findAll());
    }

    @Override
    public Page<ItemDto> getItems(Category category, ItemState state, Pageable pageable) {
        LOGGER.debug("Getting items by category={}, state={}, pageable={}",
                category, state,pageable);
        return itemRepository.findByCategoryAndState(category, state, pageable).map(toDtoConverter);
    }

    @Override
    public Page<ItemDto> getItemsBelongsTo(String ownerID, Pageable pageable) {
        LOGGER.debug("Getting items belongs to user={}, pageable={}", ownerID, pageable);
        return itemRepository.findByOwnerId(ownerID, pageable).map(toDtoConverter);
    }

    @Override
    public ItemDto getItem(String id) {
        LOGGER.debug("Getting item, id={}", id);
        return new ItemToItemDtoConverter().convert(itemRepository.findOne(id));
    }

    @Override
    public ItemDto create(ItemDto item) {
        Date date = new Date(System.currentTimeMillis());
        LOGGER.debug("Creating new item={}, date={}", item, date);

        Item persisted = new ItemDtoToItemConverter().convert(item);
        persisted.setCreationDate(date);
        itemRepository.save(persisted);

        return toDtoConverter.convert(persisted);
    }

    @Override
    public ItemDto update(String id, ItemDto item) {
        LOGGER.debug("Updating item id={}", id);
        Item updated = itemRepository.findOne(id);

        updated.setTitle(item.getTitle());
        updated.setDescription(item.getDescription());
        updated.setPrice(item.getPrice());
        updated.setPhotoURLs(item.getPhotoURLs());
        updated.setState(item.getState());
        updated.setCategory(item.getCategory());

        itemRepository.save(updated);
        return toDtoConverter.convert(updated);
    }

    @Override
    public ItemDto delete(String id) {
        LOGGER.debug("Deleting item={}", id);
        Item deleted = itemRepository.findOne(id);
        itemRepository.delete(deleted);
        return toDtoConverter.convert(deleted);
    }
}
