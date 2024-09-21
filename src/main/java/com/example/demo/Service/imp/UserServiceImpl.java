package com.example.demo.Service.imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.Common.ResultJson;
import com.example.demo.Service.UserService;
import com.example.demo.entity.mysql.Account;
import com.example.demo.mapper.Usermapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<Usermapper, Account> implements UserService {
@Resource
  Usermapper usermapper;

 public ResultJson login(Account account)
 {
  return null;
}
  public ResultJson register(Account account) {
      return null;
  }
  public ResultJson sendemail(Account account) {
      return null;
  }
  public ResultJson updatePassword(Account account) {
      return null;
  }
  public ResultJson logout(Account account) {
      return null;
  }

}
