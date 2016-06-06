package cz.buyorborrow.rest.repo;

import cz.buyorborrow.rest.model.transaction.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by ekishigo on 16.4.16.
 */
public interface TransactionRepository extends MongoRepository<Transaction, String> {
}
