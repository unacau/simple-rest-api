package cz.buyorborrow.rest.service.transaction;

import cz.buyorborrow.rest.dto.transaction.TransactionDto;
import cz.buyorborrow.rest.dto.transaction.TransactionToTransactionDtoConverter;
import cz.buyorborrow.rest.model.transaction.Transaction;
import cz.buyorborrow.rest.model.transaction.TransactionState;
import cz.buyorborrow.rest.model.user.User;
import cz.buyorborrow.rest.repo.TransactionRepository;
import cz.buyorborrow.rest.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by ekishigo on 16.4.16.
 */
@Service
public class TransactionServiceImpl implements TransactionService {

    private TransactionRepository transactionRepository;
    private UserService userService;
    private TransactionToTransactionDtoConverter converterToDto = new TransactionToTransactionDtoConverter();
    public static final Logger LOGGER = LoggerFactory.getLogger(TransactionServiceImpl.class);

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository, UserService userService) {
        this.userService = userService;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public TransactionDto create(TransactionDto transaction) {
        LOGGER.debug("Creating transaction={}", transaction);
        Date date = new Date(System.currentTimeMillis());
        Transaction persisted = new Transaction(transaction.getId(),
                transaction.getItem(), transaction.getInitiatorId(), transaction.getInitiatorId(),
                transaction.getState());
        persisted.setCreationDate(date);
        transactionRepository.save(persisted);
        // we want to update users too
        userService.updateMyTransactionsIds(transaction.getFinisherId(), transaction.getId());
        userService.updateMyTransactionsIds(transaction.getInitiatorId(), transaction.getId());

        return converterToDto.convert(persisted);
    }

    @Override
    public TransactionDto updateState(String id, TransactionState state) {
        Transaction updated = transactionRepository.findOne(id);
        LOGGER.debug("Updating transaction={}, state={}",updated, state);
        updated.setState(state);
        transactionRepository.save(updated);
        return converterToDto.convert(updated);
    }
}
