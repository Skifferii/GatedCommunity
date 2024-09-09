package gatedcommunity.service.interfaces;

import gatedcommunity.model.dto.UserRegisterDto;

public interface UserService  {

    void register(UserRegisterDto registerDto);
    String confirmationMailByCode(String code);
}