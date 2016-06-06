package cz.buyorborrow.rest.dto.item;

import cz.buyorborrow.rest.model.item.Item;
import org.springframework.core.convert.converter.Converter;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ekishigo on 8.4.16.
 */
public class ItemDtoToItemConverter implements Converter<ItemDto, Item> {
    @Override
    public Item convert(ItemDto source) {
        return Item.getItemBuilder(source.getTitle(), source.getPrice(), source.getDescription())
                .withCategory(source.getCategory())
                .withOwner(source.getOwnerId())
                .withPhotos(source.getPhotoURLs())
                .withState(source.getState()).build();
    }

    public List<Item> convertCollection(Collection<ItemDto> dtoCollection) {
        return dtoCollection.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }
}
