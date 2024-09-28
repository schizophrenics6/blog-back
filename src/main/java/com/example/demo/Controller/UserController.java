package com.example.demo.Controller;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.Common.ResultJson;
import com.example.demo.Service.UserService;
import com.example.demo.Service.imp.ArticleServiceImpl;
import com.example.demo.Service.imp.UserServiceImpl;
import com.example.demo.entity.mysql.Account;
import com.example.demo.entity.email;
import com.example.demo.entity.Rigister;
import com.example.demo.entity.mysql.Article;
import com.example.demo.mapper.Usermapper;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.lang.RandomStringUtils;

@RestController
public class UserController
{
    @Resource
    Usermapper usermapper;
    @Resource
    JavaMailSender sender;
    @Resource
    UserServiceImpl userServiceimpl;

    @Resource
    ArticleServiceImpl articleServiceimpl;
    //    @PostMapping("/Account/login")
//    @ResponseBody
//    public ResultJson login(@RequestBody Account account) {
//        String username = account.getUsername();
//        String password = account.getPassword();
//
//        QueryWrapper<Account> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("username", username);
//        Account u = usermapper.selectOne(queryWrapper);
//        if (u == null) {
//            return ResultJson.error("尚未注册");
//        }
//        if (!u.getPassword().equals(password)) {
//            return ResultJson.error("密码错误");
//        }
//
//        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();
//        session.setAttribute("user", u.getUsername());
//
//        return ResultJson.success(account);
//    }
@PostMapping("/Account/login")
    @ResponseBody
   public ResultJson login(HttpSession session,  @RequestBody Account account)
    {
        String username = account.getUsername();
        String password = account.getPassword();
        QueryWrapper<Account> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        Account u = usermapper.selectOne(queryWrapper);
        if(u == null) //wu
        {
            System.out.println("尚未注册");
            return ResultJson.error("尚未注册");
        }
        if(!u.getPassword().equals(password))
        {
            System.out.println("密码错误");
            return ResultJson.error("密码错误");
        }

        session.setAttribute("account", u.getUsername()); // 在会话中设置属
        //request.setAttribute("account", u.getUsername());
        System.out.println("登陆成功");

//        if (session != null) {
//            Object attributeValue = session.getAttribute("account");
//            System.out.println("Value of attribute: " + attributeValue);
//        }

//        LocalDateTime now = LocalDateTime.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        String formattedDateTime = now.format(formatter);
//        System.out.println("登陆成功，当前时间：" + formattedDateTime);
        return  ResultJson.success(account);
     // return userServiceImpl.login(account);

    }


    @PostMapping("/Account/register")
    @ResponseBody
    public ResultJson<String> register(HttpSession session,@RequestBody Rigister r)
    {
        String sessionCode = (String) session.getAttribute("code");
        String sessionnumber= (String) session.getAttribute("number");

        String username = r.getUsername();
        String password = r.getPassword();
        String number = r.getNumber();
        String code = r.getCode();
        QueryWrapper<Account> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("email", number);
        Account u = usermapper.selectOne(queryWrapper);
        if (u != null)
        {
            return ResultJson.error("该qq邮箱已被注册");
        }
        QueryWrapper<Account> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.eq("username", username);
        Account s = usermapper.selectOne(queryWrapper1);
        if (s != null) {
            return ResultJson.error("用户名已存在");
        }
        if (password == null || password.length() < 3) {
            return ResultJson.error("密码格式错误");
        }
// 验证码是否为空

        if (sessionCode == null) {
            return ResultJson.error("请先获取验证码", "400");
        }
// 验证用户提交的验证码是否与会话中的验证码一致
        if (!sessionCode.equals(code)) {
            System.out.println(sessionCode);
            System.out.println(code);
            return ResultJson.error("验证码不正确", "400");
        }
// 验证用户提交的电子邮件地址是否与会话中的电子邮件地址一致
        if (!sessionnumber.equals(r.getNumber())) {
            return ResultJson.error("验证码不正确", "401");
        }
//删
//        mapper.deleteUserByEmail(email);
//  创建用户
        usermapper.createUser(username,password, number);
        System.out.println("注册成功");
        return ResultJson.success("注册成功");
    }

    @PostMapping("/Account/sendemail")
    @ResponseBody
        public ResultJson<String> sendemail(@RequestBody email e, HttpSession session)
    {
        System.out.println(e.getNumber());
        SimpleMailMessage message = new SimpleMailMessage();
        String randomString = RandomStringUtils.randomAlphanumeric(10);
        session.setAttribute("number", e.getNumber());
        session.setAttribute("code", randomString);
        message.setSubject("你的验证码");
        message.setText(randomString);
        message.setTo(e.getNumber()); // 设置邮件发送给谁，可以多个
        message.setFrom("17537709956@163.com"); // 邮件发送者，这里要与配置文件中的保持一致
        sender.send(message);
        System.out.println("发送成功");
        return ResultJson.success("发送成功");
    }


    @PostMapping("/Account/login/findpassword/updatepassword")
    @ResponseBody
    public ResultJson updatepassword(@RequestBody Account account,HttpSession session)
    {
        String sessionnumber= (String) session.getAttribute("number");
        usermapper.deleteUserByEmail(sessionnumber);
        String username = account.getUsername();
        String password = account.getPassword();
        QueryWrapper<Account> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.eq("username", username);
        Account s = usermapper.selectOne(queryWrapper1);
        if (s != null) {
            return ResultJson.error("用户名已存在");
        }
        if (password == null || password.length() < 3) {
            return ResultJson.error("密码格式错误");
        }
        usermapper.createUser(username,password,sessionnumber);
        System.out.println("注册成功");
        return ResultJson.success("注册成功");
    }

    @PostMapping("/Account/personalpage/editor")
    @ResponseBody
    public ResultJson updateaccountpersonal(@RequestBody Account account)
    {
        return userServiceimpl.updateaccountpersonal(account);
    }

    @GetMapping("/Account/personalpage")
    @ResponseBody
    public ResultJson selectpersonalpage(@RequestBody Account account)
    {
return userServiceimpl.selectpersonalpage(account);
    }

    @PutMapping("/Account/personalpage/updatetop")
    @ResponseBody
    public ResultJson inserttop(@RequestBody Article article)
    {
        return articleServiceimpl.updatetop(article);
    }

    @GetMapping("/Account/personalpage/selectpersonalarticle")
    @ResponseBody
    public ResultJson selectpersonalarticle(@RequestBody Article article)
    {
        return userServiceimpl.selectpersonalarticle(article);
    }
    @PostMapping("/Account/logout")
    @ResponseBody
    public ResultJson<String> logout(HttpSession session)
    {
        session.removeAttribute("account");
        return ResultJson.success("退出成功");
    }
}
