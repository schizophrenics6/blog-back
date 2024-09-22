package com.example.demo.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.Common.ResultJson;
import com.example.demo.entity.mysql.Account;

public interface UserService extends IService <Account>
{
ResultJson login(Account account);

ResultJson register(Account account);

ResultJson sendemail(Account account);

ResultJson updatePassword(Account account);

ResultJson updateaccountpersonal(Account account);

ResultJson selectpersonalpage(Account account);

ResultJson logout(Account account);


}
