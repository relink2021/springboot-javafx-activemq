package com.relink.chat.dao;

import com.relink.chat.core.util.ReturnNo;
import com.relink.chat.core.util.ReturnObject;
import com.relink.chat.mapper.UserPoMapper;
import com.relink.chat.model.po.UserPo;
import com.relink.chat.model.po.UserPoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserDao {

    @Autowired
    private UserPoMapper userPoMapper;

    /**
     * 用户注册
     */
    public ReturnObject register(String username, String password, String check) {
        if(!password.equals(check)) {
            return new ReturnObject<>(ReturnNo.PWD_CHECK_ERROR, "两次输入的密码不一致");
        }
        UserPoExample example = new UserPoExample();
        example.createCriteria().andUsernameEqualTo(username);
        try {
            List<UserPo> userPos = userPoMapper.selectByExample(example);
            if(userPos.size() == 1) {
                return new ReturnObject<>(ReturnNo.USER_IS_EXIST, "用户名已被使用");
            }
            UserPo newPo = new UserPo();
            newPo.setUsername(username);
            newPo.setPassword(password);
            newPo.setAvatar(null);
            userPoMapper.insertSelective(newPo);
            return new ReturnObject<>();
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnObject<>(ReturnNo.INTERNAL_SERVER_ERR);
        }
    }

    /**
     * 用户登录
     */
    public ReturnObject login(String username, String password) {
        UserPoExample example = new UserPoExample();
        example.createCriteria().
                andUsernameEqualTo(username).
                andPasswordEqualTo(password);
        try {
            List<UserPo> userPos = userPoMapper.selectByExample(example);
            if(userPos.size() == 0) {
                return new ReturnObject<>(ReturnNo.LOGIN_IS_FAILED, "用户名不存在或密码错误");
            }
            return new ReturnObject<>();
        } catch (Exception e) {
            return new ReturnObject<>(ReturnNo.INTERNAL_SERVER_ERR);
        }
    }
}
