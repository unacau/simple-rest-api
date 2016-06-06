package cz.buyorborrow.rest.service.user;

import cz.buyorborrow.rest.dto.user.CreateForm;
import cz.buyorborrow.rest.dto.user.ProfileForm;
import cz.buyorborrow.rest.dto.user.UserDto;
import cz.buyorborrow.rest.dto.user.UserToUserDtoConverter;
import cz.buyorborrow.rest.model.user.Profile;
import cz.buyorborrow.rest.model.user.User;
import cz.buyorborrow.rest.repo.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by ekishigo on 9.4.16.
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    private UserRepository userRepository;
    private UserToUserDtoConverter toDtoConverter = new UserToUserDtoConverter();

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto create(CreateForm createForm) {
        LOGGER.debug("Creating user ={}", createForm);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String passwordHash = encoder.encode(createForm.getPassword()); //we want to say passwordHash hash!

        User persisted = User.getUserBuilder(createForm.getUsername(), passwordHash)
                .withRole(createForm.getRole())
                .build();
        userRepository.save(persisted);
        return toDtoConverter.convert(persisted);
    }

    @Override
    public UserDto delete(String id) {
        LOGGER.debug("Delleting user id={}", id);
        User deleted = userRepository.findOne(id);
        userRepository.delete(deleted);
        return toDtoConverter.convert(deleted);
    }

    @Override
    public UserDto updateProfile(String id, ProfileForm profileForm) {
        LOGGER.debug("Updating user id={} with profile={}", id, profileForm);
        User updated = userRepository.findOne(id);
        Profile profile = new Profile(profileForm.getNickname(), profileForm.getPhone(), profileForm.getLocality());
        updated.setProfile(profile);
        userRepository.save(updated);
        return toDtoConverter.convert(updated);
    }

    @Override
    public UserDto updateMyItemsIds(String id, String itemId) {
        LOGGER.debug("Updating user id={} with item id={}", id, itemId);
        User updated = userRepository.findOne(id);
        updated.putItem(itemId);
        userRepository.save(updated);
        return toDtoConverter.convert(updated);
    }

    @Override
    public UserDto updateMyTransactionsIds(String id, String transactionId) {
        LOGGER.debug("Updating user id={} with transaction id={}", id, transactionId);
        User updated = userRepository.findOne(id);
        updated.putTransaction(transactionId);
        userRepository.save(updated);
        return toDtoConverter.convert(updated);
    }


    @Override
    public UserDto getByUsername(String username) {
        LOGGER.debug("Getting user with login={}", username);
        User user = userRepository.findByUsername(username);
        if (user != null) {
            return toDtoConverter.convert(user);
        } else {
            return null;
        }
    }

    @Override
    public Page<UserDto> getAll(Pageable pageable) {
        LOGGER.debug("Getting all users");
        Page<UserDto> users = userRepository.findAll(pageable).map(toDtoConverter);
        return users;
    }
}
