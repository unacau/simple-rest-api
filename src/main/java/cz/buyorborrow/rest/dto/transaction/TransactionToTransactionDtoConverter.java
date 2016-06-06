package cz.buyorborrow.rest.dto.transaction;

import cz.buyorborrow.rest.model.transaction.Transaction;
import org.springframework.core.convert.converter.Converter;

/**
 * Created by ekishigo on 16.4.16.
 */
public class TransactionToTransactionDtoConverter implements Converter<Transaction, TransactionDto> {
    @Override
    public TransactionDto convert(Transaction source) {
        TransactionDto ret = new TransactionDto();
        ret.setCreationDate(source.getCreationDate());
        ret.setFinisherId(source.getFinisherId());
        ret.setId(source.getId());
        ret.setInitiatorId(source.getInitiatorId());
        ret.setItem(source.getItem());
        ret.setState(source.getState());
        return ret;
    }
}
