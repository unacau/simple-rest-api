package cz.buyorborrow.rest.controller;

import cz.buyorborrow.rest.dto.transaction.TransactionDto;
import cz.buyorborrow.rest.model.transaction.TransactionState;
import cz.buyorborrow.rest.service.transaction.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by ekishigo on 16.4.16.
 */
@RestController
@RequestMapping("/trans")
public class TransactionController {

    public static final Logger LOGGER = LoggerFactory.getLogger(TransactionController.class);
    private TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    TransactionDto create(@RequestBody @Valid TransactionDto transaction) {
        return transactionService.create(transaction);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/update/{id}/", params = "state")
    TransactionDto update(@PathVariable String id, @RequestParam("state")TransactionState state) {
        return transactionService.updateState(id, state);
    }
}
