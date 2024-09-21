package com.example.demo.Service.imp;

//public class AuthorizeSeriveImpl implements AuthorizeService {
//@Resource
//    Usermapper usermapper;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
////        String username = authentication.getName();
////        String password = authentication.getCredentials().toString();
////        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
////        queryWrapper.eq("username", username);
////        User user = usermapper.selectOne(queryWrapper);
////
////        if (user == null) {
////            System.out.println("尚未注册");
////            throw new BadCredentialsException("尚未注册");
////        }
////
////        if (!user.getPassword().equals(password)) {
////            System.out.println("密码错误");
////            throw new BadCredentialsException("密码错误");
////        }
//
//        QueryWrapper<Account> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("username", username);
//        Account user = usermapper.selectOne(queryWrapper);
//           if(username==null)
//               throw new UsernameNotFoundException("尚未注册");
//
//        if(!user.getPassword().equals(password))
//            throw new UsernameNotFoundException("用户名或密码错误");
//        return User
//                .withUsername(account.get)
//                .builder();
//
//    }
//
//}




