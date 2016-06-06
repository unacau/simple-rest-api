import cz.buyorborrow.rest.dto.item.ItemDto;
import cz.buyorborrow.rest.model.item.Category;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ekishigo on 7.4.16.
 */
public class ItemServiceTest {

    @Test
    public void testCreate() {
        ItemDto itemDto = new ItemDto();
        itemDto.setCategory(Category.ALL);
        assertEquals(Category.ALL, itemDto.getCategory());
    }

}
