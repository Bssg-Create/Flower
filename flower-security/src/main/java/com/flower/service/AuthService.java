package com.flower.service;

import com.flower.dto.Result;
import com.flower.dto.UserLoginDTO;
import com.flower.dto.UserRegisterDTO;

public interface AuthService {

    Result<String> login(UserLoginDTO loginDTO);

    Result<Void> register(UserRegisterDTO registerDTO);
}
