package com.example.XML_WS_auth_backend.services;

import com.example.XML_WS_auth_backend.DTOs.AuthTokenDTO;
import com.example.XML_WS_auth_backend.DTOs.LoginDTO;
import com.example.XML_WS_auth_backend.configs.Settings;
import com.example.XML_WS_auth_backend.custom_exceptions.AuthFailedException;
import com.example.XML_WS_auth_backend.custom_exceptions.CredsNotValidException;
import com.example.XML_WS_auth_backend.custom_exceptions.UserNotFoundException;
import com.example.XML_WS_auth_backend.models.User;
import com.example.XML_WS_auth_backend.repositories.UserRepository;
import com.example.XML_WS_auth_backend.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class AuthenticationService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenUtils tokenUtils;

    public AuthTokenDTO loginUser(LoginDTO loginDTO) {
        User user = userRepository.getByEmail(loginDTO.getEmail());
        if (user == null)
            throw new UserNotFoundException();

        if (!user.getEmail().equals(loginDTO.getEmail()) || !user.getPassword().equals(loginDTO.getPassword()))
            throw new CredsNotValidException();

        String userRole = user.getRole();
        return new AuthTokenDTO(tokenUtils.generateToken(user.getEmail(), userRole), userRole);
    }

    public void authRegularUser(HttpServletRequest request) {
        if (!verifyUserByRole(request, Settings.ROLE_REGULAR))
            throw new AuthFailedException();
    }

    public void authOfficialUser(HttpServletRequest request) {
        if (verifyUserByRole(request, Settings.ROLE_OFFICIAL))
            return;
        throw new AuthFailedException();
    }

    public void authAdmin(HttpServletRequest request) {
        if (verifyUserByRole(request, Settings.ROLE_ADMIN))
            return;
        throw new AuthFailedException();
    }

    private boolean verifyUserByRole(HttpServletRequest request, String role) {
        tokenUtils.getIssuedAtDateFromToken(request);
        String headerEmail = tokenUtils.getEmailDirectlyFromHeader(request);
        String headerRole = tokenUtils.getRoleDirectlyFromHeader(request);
        if (headerEmail == null || headerRole == null)
            return false;

        User user = userRepository.getByEmail(headerEmail);
        return !(user == null || !headerRole.equals(role) || !user.getRole().equals(headerRole));
    }

}
