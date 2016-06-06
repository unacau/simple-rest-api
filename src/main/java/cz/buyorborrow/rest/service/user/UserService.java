package cz.buyorborrow.rest.service.user;

import cz.buyorborrow.rest.dto.user.CreateForm;
import cz.buyorborrow.rest.dto.user.ProfileForm;
import cz.buyorborrow.rest.dto.user.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by ekishigo on 9.4.16.
 */
public interface UserService {

    UserDto create(CreateForm createForm);

    UserDto delete(String id);

    UserDto updateProfile(String id, ProfileForm profileForm);

    UserDto updateMyItemsIds(String id, String itemId);

    UserDto updateMyTransactionsIds(String id, String transactionId);

    UserDto getByUsername(String username);

    Page<UserDto> getAll(Pageable pageable);
}
