package cz.buyorborrow.rest.controller;

import cz.buyorborrow.rest.dto.item.ItemDto;
import cz.buyorborrow.rest.model.item.Category;
import cz.buyorborrow.rest.model.item.ItemState;
import cz.buyorborrow.rest.service.item.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by ekishigo on 1.4.16.
 */
@RestController
@RequestMapping("/items")
public class ItemController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ItemController.class);
    private final ItemService service;

    @Autowired
    public ItemController(ItemService service) {
        this.service = service;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    ItemDto create(@RequestBody @Valid ItemDto item, Principal principal) {
        String pr = principal.getName();
        LOGGER.debug("Creating item={}", item);
        return service.create(item);
    }


    @RequestMapping(value = "/search/all", method = RequestMethod.GET)
    List<ItemDto> getAll() {
        LOGGER.debug("Getting all items");
        return service.getAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search/stateAndCategory", params = {"state", "category"})
    Page<ItemDto> getItems(@RequestParam("category") Category category,
                           @RequestParam("state") ItemState state, Pageable pageable) {
        LOGGER.debug("Getting items with state={} and category={}", state, category);
        return service.getItems(category, state, pageable);
    }

    @RequestMapping(value = "search/id/{id}",method = RequestMethod.GET)
    ItemDto findById(@PathVariable String id) {
        LOGGER.debug("Getting item wit id={}", id);
        return service.getItem(id);
    }

    //Authority owner
    @RequestMapping(method = RequestMethod.GET, value = "search/ownerId", params = "ownerId")
    Page<ItemDto> findByOwner(@RequestParam("ownerId") String ownerId, Pageable pageable) {
        LOGGER.debug("Getting item of user with id={}", ownerId);
        return service.getItemsBelongsTo(ownerId, pageable);
    }


    @RequestMapping(method = RequestMethod.DELETE, value = "delete/id/{id}")
    ItemDto delete(@PathVariable String id) {
        LOGGER.debug("Deleting item with id={}", id);
        return service.delete(id);
    }

    @RequestMapping(value = "/update/id/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.CREATED)
    ItemDto update(@PathVariable String id, @RequestBody @Valid ItemDto item) {
        LOGGER.debug("Updating item id={}", id);
        return service.update(id, item);
    }

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNoSuchElementException(NoSuchElementException e) {
        return e.getMessage();
    }
}
