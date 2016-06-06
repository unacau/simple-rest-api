package cz.buyorborrow.rest.dto.user;

import cz.buyorborrow.rest.model.user.User;
import org.springframework.core.convert.converter.Converter;

/**
 * Created by ekishigo on 9.4.16.
 */
public class UserToUserDtoConverter implements Converter<User, UserDto> {
    @Override
    public UserDto convert(User source) {
        UserDto ret = new UserDto();
        ret.setUsername(source.getUsername());
        ret.setPasswordHash(source.getPasswordHash());
        ret.setMyItemsIds(source.getMyItemsIds());
        ret.setProfile(source.getProfile());
        ret.setRole(source.getRole());
        ret.setTransactionsIds(source.getTransactionsIds());
        return ret;
    }
}
