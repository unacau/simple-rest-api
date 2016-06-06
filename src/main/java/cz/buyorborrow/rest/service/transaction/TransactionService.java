package cz.buyorborrow.rest.service.transaction;

import cz.buyorborrow.rest.dto.transaction.TransactionDto;
import cz.buyorborrow.rest.model.transaction.TransactionState;

/**
 * Created by ekishigo on 16.4.16.
 */
public interface TransactionService {

    TransactionDto create(TransactionDto transaction);

    TransactionDto updateState(String id, TransactionState state);
}
