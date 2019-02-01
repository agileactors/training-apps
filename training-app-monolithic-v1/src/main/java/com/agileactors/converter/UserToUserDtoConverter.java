package com.agileactors.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.agileactors.date.DateProvider;
import com.agileactors.domain.User;
import com.agileactors.dto.user.UserDto;

@Component
public class UserToUserDtoConverter implements Converter<User, UserDto> {

    private final DateProvider dateProvider;

    @Autowired
    public UserToUserDtoConverter(DateProvider dateProvider) {
        this.dateProvider = dateProvider;
    }

    @Override
    public UserDto convert(User source) {
        return new UserDto(source.getId(), source.getEmail(), source.getName(), source.getLastName(),
            source.isActive(), dateProvider.toZonedDateTime(source.getCreatedAt()),
            source.getRoles(), source.isProtected(), source.getUserType());
    }
}