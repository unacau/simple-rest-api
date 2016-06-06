package cz.buyorborrow.rest.dto.item;

import cz.buyorborrow.rest.model.item.Item;
import org.springframework.core.convert.converter.Converter;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ekishigo on 8.4.16.
 */
public class ItemToItemDtoConverter implements Converter<Item, ItemDto> {
    @Override
    public ItemDto convert(Item source) {
        ItemDto ret = new ItemDto();
        ret.setId(source.getId());
        ret.setTitle(source.getTitle());
        ret.setDescription(source.getDescription());
        ret.setPrice(source.getPrice());
        ret.setOwnerId(source.getOwnerId());
        ret.setCategory(source.getCategory());
        ret.setState(source.getState());
        ret.setPhotoURLs(source.getPhotoURLs());
        ret.setCreationDate(source.getCreationDate());
        return ret;
    }

    public List<ItemDto> convertCollection(Collection<Item> itemCollection) {
        return itemCollection.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }
}
