package com.agileactors.converter;

import com.agileactors.domain.User;
import com.agileactors.dto.user.GetUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserToUserDtoConverter implements Converter<User, GetUserDto> {

  @Override
  public GetUserDto convert(User source) {
    return new GetUserDto(source.getId(), source.getEmail(), source.getName(), source.getLastName(),
        source.isActive(), source.getCreatedAt(),
        source.getRoles(), source.isProtected(), source.getUserType());
  }
}
