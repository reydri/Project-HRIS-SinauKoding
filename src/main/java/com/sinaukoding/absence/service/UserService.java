package com.sinaukoding.absence.service;

import com.sinaukoding.absence.common.RestResult;
import com.sinaukoding.absence.common.StatusCode;
import com.sinaukoding.absence.entity.User;
import com.sinaukoding.absence.dao.BaseDAO;
import com.sinaukoding.absence.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class UserService extends BaseService<User> {

    @Autowired
    private UserDAO dao;

    @Autowired
    private JwtTokenService jwtTokenService;

    @Override
    protected BaseDAO<User> getDAO() {
        return dao;
    }

    @Autowired
    private BankService bankService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private PositionService positionService;

    @Autowired
    private DivisionService divisionService;

    @Transactional
    public User register(User param, User.Role role){
        User reference = dao.findOne(new User(param.getUsername()));

        if(reference != null){
            return null;
        }else {
            param.setRole(role);
            param.setPassword(BCrypt.hashpw(param.getPassword(), BCrypt.gensalt()));

            param.setBank(bankService.findByName(param.getBank()));
            param.setCompany(companyService.findByName(param.getCompany()));
            param.setPosition(positionService.findByName(param.getPosition()));
            param.setDivision(divisionService.findByName(param.getDivision()));

            return dao.save(param);
        }
    }

    @Transactional
    public RestResult login(User param){
        RestResult result = new RestResult(StatusCode.PASSWORD_OR_USER_NOT_REGISTERED);

        User currentUser = dao.findOne(param);

        if (currentUser == null){
            return result;
        }else if(currentUser.getPassword() != null && BCrypt.checkpw(param.getPassword(), currentUser.getPassword())){
            UserDetails userDetails = new org.springframework.security.core.userdetails.User(currentUser.getUsername(), currentUser.getPassword(), new ArrayList<>());

            currentUser.setToken(jwtTokenService.generateToken(userDetails));

            result.setData(currentUser);
            result.setStatus(StatusCode.LOGIN_SUCCESS);
        }else {
            result.setStatus(StatusCode.LOGIN_FAILED);
        }

        return result;
    }
}