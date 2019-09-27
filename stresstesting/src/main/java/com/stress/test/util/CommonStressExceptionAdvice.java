package com.stress.test.util;

import com.fenyun.base.base.exception.BaseExceptionAdvice;
import com.fenyun.base.base.response.EmErrorMsg;
import com.fenyun.base.base.response.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@Repository
@RestControllerAdvice
public class CommonStressExceptionAdvice extends BaseExceptionAdvice {


    @ExceptionHandler(LockedAccountException.class)
    public RestResponse handleLockedAccountException(LockedAccountException e) {
        return failResponse(EmErrorMsg.FAILNOTLOGINNAMELOCK);
    }

    @ExceptionHandler(IncorrectCredentialsException.class)
    public RestResponse handleIncorrectCredentialsException(IncorrectCredentialsException e) {
        return failResponse(EmErrorMsg.FAILLOGIN);
    }

    @ExceptionHandler(UnknownAccountException.class)
    public RestResponse handleUnknownAccountException(UnknownAccountException e) {
        return failResponse(EmErrorMsg.FAILLOGINNAMENOTEXEIT);
    }

    @ExceptionHandler(UnauthenticatedException.class)
    public RestResponse handleUnauthenServiceException(UnauthenticatedException e) {
        return failResponse(EmErrorMsg.FAILNOTLOGIN);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public RestResponse handleUnauthenServiceException(UnauthorizedException e) {
        return failResponse(EmErrorMsg.FAILACCESS);
    }

}
