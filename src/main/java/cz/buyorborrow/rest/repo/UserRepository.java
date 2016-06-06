package cz.buyorborrow.rest.repo;

import cz.buyorborrow.rest.model.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import javax.jws.soap.SOAPBinding;

/**
 * Created by ekishigo on 9.4.16.
 */
public interface UserRepository extends MongoRepository<User, String> {

    User findByUsername(String username);

    Page<User> findAll(Pageable pageable);
}
