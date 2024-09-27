
增 post
删 delete
改 put
查 get
# user
## 登录
http://localhost:8080/Account/login
post
```json
{

     "username": "add",

     "password": "add",

     "number": ""

}
```

```json{

    "code": "200",

    "data": {

        "username": "add",

        "password": "add",

        "number": ""

    },

    "msg": "成功"

}
```

## 验证码
post
http://localhost:8080/Account/sendemail
```json
{
   "number": "xxxxxxx@qq.com"
}
```

```json
{

    "code": "200",

    "data": "发送成功",

    "msg": "成功"

}
```
## 注册
post
http://localhost:8080/Account/register
```json
{

     "username":"ad",

     "password":"addd",

     "number": "1017557616@qq.com",

     "code":"asdfasda"

}



```

```json
{

    "code": "200",

    "data": "注册成功",

    "msg": "成功"

}
```
## 忘记密码
http://localhost:8080/Account/login/findpassword/updatepassword
```json
{

    "username": "add",

     "password": "add"

}
```

```json
{

    "code": "404",

    "data": null,

    "msg": "用户名已存在"

}
```
## 退出
http://localhost:8080/Account/logout
```json
{

    "username": "add",

     "password": "add"

}
```

```json
{

    "code": "200",

    "data": "退出成功",

    "msg": "成功"

}
```

# 首页
http://localhost:8080/Homepage
无
```json
{

    "code": "200",

    "data": [

        {

            "id": -1655685118,

            "title": "cpdd",

            "content": "xxxxxx ",

            "authorid": "1",

            "publishDate": "2024-09-20T14:21:01.000+00:00",

            "tags": "cao",

            "likes": 0,

            "views": 0

        },

        {

            "id": 7,

            "title": "cpdd",

            "content": "xxxxxx ",

            "authorid": "1",

            "publishDate": "2024-09-20T05:05:58.000+00:00",

            "tags": null,

            "likes": 0,

            "views": 0

        },

        {

            "id": 22097921,

            "title": "cpdd",

            "content": "xxxxxx ",

            "authorid": "1",

            "publishDate": "2024-09-20T14:20:03.000+00:00",

            "tags": "cao",

            "likes": 0,

            "views": 0

        }

    ],

    "msg": "成功"

}
```
# 文章
## 增
http://localhost:8080/Article/insert
```json
{

    "title":"cpdd",

    "content":"xxxxxx ",

    "tags":"cao"

}
```

```json
{

    "code": "200",

    "data": "添加成功",

    "msg": "成功"

}
```
## 删
http://localhost:8080/Article/delete
```json
{

    "id":"2"
}
```

```
```json
{

    "code": "200",

    "data": "删除成功",

    "msg": "成功"

}
```
## 改
http://localhost:8080/Article/update
```json
{

    "id":"1",

    "title":"cpd",

    "content":"x ",

    "tag":"cao"

}
```

```json
{

    "code": "200",

    "data": "更新成功",

    "msg": "成功"

}
```
## 查
http://localhost:8080/Article/select
```json
{

  

"title":"cp"

}

```

```json
{

    "code": "200",

    "data": [

        {

            "id": 3,

            "title": "cpdd",

            "content": "xxxxxx ",

            "authorid": "1",

            "publishDate": "2024-09-19T07:31:02.000+00:00",

            "tags": null,

            "likes": 0,

            "views": 0

        }

    ],

    "msg": "成功"

}
```

# 评论
## 增
http://localhost:8080/Comments/insert
```json
{

"articleId":"3",

"accountId":"1",

"commentText":"xxxxx"

}
```

```json
{

    "code": "200",

    "data": "评论成功",

    "msg": "成功"

}
```

## 删
http://localhost:8080/Comments/delete
```json
{

"id":"1"

}
```

```json
{

    "code": "200",

    "data": "删除成功",

    "msg": "成功"

}
```
## 查
http://localhost:8080/Comments/select
```json
{

"articleId":"1"

}
```

```json
{

    "code": "200",

    "data": null,

    "msg": "成功"

}
```

# 收藏
## 增
http://localhost:8080/Collect/insert
```json
{

"accountId": "1",

"articleId":"3"

}
```

```json
{

    "code": "200",

    "data": "添加成功",

    "msg": "成功"

}
```

## 删
http://localhost:8080/Collect/delete
```json
{

"collectId": "5"

}
```

```json
{

    "code": "200",

    "data": "删除成功",

    "msg": "成功"

}
```
## 查
http://localhost:8080/Collect/select
```json
{

"accountId": "1"

}
```

```json
{

    "code": "200",

    "data": [

        {

            "collectId": null,

            "accountId": 1,

            "articleId": 3,

            "collectDate": "2024-09-19T15:47:25.000+00:00"

        },

        {

            "collectId": null,

            "accountId": 1,

            "articleId": 3,

            "collectDate": "2024-09-19T15:51:11.000+00:00"

        },

        {

            "collectId": null,

            "accountId": 1,

            "articleId": 3,

            "collectDate": "2024-09-19T15:52:04.000+00:00"

        },

        {

            "collectId": null,

            "accountId": 1,

            "articleId": 3,

            "collectDate": "2024-09-19T15:52:47.000+00:00"

        }

    ],

    "msg": "成功"

}
```

# 历史
## 增
http://localhost:8080/History/insert
```json
{

"accountId":"1",

"articleId":"3"

}
```

```json
{

    "code": "200",

    "data": "添加成功",

    "msg": "成功"

}
```

## 删
http://localhost:8080/History/delete
```json
{

"id":"1"

}
```

```json
{

    "code": "200",

    "data": "删除成功",

    "msg": "成功"

}
```
## 查
http://localhost:8080/Collect/select
```json
{

"accountId": "1"

}
```

```json
{

    "code": "200",

    "data": [

        {

            "id": null,

            "accountId": 1,

            "articleId": 3,

            "actionTime": "2024-09-20T01:40:44.000+00:00"

        }

    ],

    "msg": "成功"

}
```






# 标签
## 增
http://localhost:8080/Collect/insert
```json
{

  

"title":"cpdd",

  

"content":"xxxxxx ",

  

"tags":"cao"

  

}
```

```json
{

    "code": "200",

    "data": "添加成功",

    "msg": "成功"

}
```

## 查
http://localhost:8080/Tag/select
```json
{

  

"tagName":"cao"

  

}
```

```json
{

    "code": "200",

    "data": [

        {

            "id": -1655685118,

            "title": "cpdd",

            "content": "xxxxxx ",

            "authorid": "1",

            "publishDate": "2024-09-20T14:21:01.000+00:00",

            "tags": "cao",

            "likes": 0,

            "views": 0

        },

        {

            "id": 22097921,

            "title": "cpdd",

            "content": "xxxxxx ",

            "authorid": "1",

            "publishDate": "2024-09-20T14:20:03.000+00:00",

            "tags": "cao",

            "likes": 0,

            "views": 0

        }

    ],

    "msg": "成功"

}
```




# 粉丝

## 增
http://localhost:8080/Followers/insert
```json
{

"fanid":"2",

"idolid":"1"

  

}
```

```json
{

    "code": "200",

    "data": "添加成功",

    "msg": "成功"

}
```

## 删
http://localhost:8080/Followers/delete
```json
{

"fanid":"2",

"idolid":"1"

  

}
```

```json
{

    "code": "200",

    "data": "删除成功",

    "msg": "成功"

}
```
## 查
http://localhost:8080/Followers/select
```json
{

"fanid":"2"

  

} 
```

```json
{

    "code": "200",

    "data": [

        {

            "idolid": 1,

            "fanid": 2,

            "followdate": "2024-09-20T16:09:20.000+00:00"

        }

    ],

    "msg": "成功"

}
```
# 个人主页
## 编辑
http://localhost:8080/Account/personalpage/editor

```json
{

    "id":"1",

    "sex":"1",

    "year":"12",

    "introduce":"an acmer"

}
```


```json
{

    "code": "200",

    "data": "编辑成功",

    "msg": "成功"

}
```

## 查介绍
http://localhost:8080/Account/personalpage
```json
{

    "id":"1"

  

}
```

```json
{

    "code": "200",

    "data": {

        "sex": 1,

        "year": 12,

        "introduce": "an acmer"

    },

    "msg": "成功"

}
```


## 置顶
http://localhost:8080/Account/personalpage/updatetop
```json
{

    "id":"7"

}
```

```json
{

    "code": "200",

    "data": 1,

    "msg": "成功"

}
```


## 查写的文章
http://localhost:8080/Account/personalpage/selectpersonalarticle
```json
{

    "authorid":"1"

}
```

```json
{

    "code": "200",

    "data": [

        {

            "id": 7,

            "title": "cpdd",

            "content": "xxxxxx ",

            "authorid": 1,

            "publishDate": "2024-09-20T05:05:58.000+00:00",

            "tags": null,

            "likes": 0,

            "views": 0,

            "top": true

        },

        {

            "id": -1655685118,

            "title": "cpdd",

            "content": "xxxxxx ",

            "authorid": 1,

            "publishDate": "2024-09-20T14:21:01.000+00:00",

            "tags": "cao",

            "likes": 0,

            "views": 0,

            "top": false

        },

        {

            "id": 22097921,

            "title": "cpdd",

            "content": "xxxxxx ",

            "authorid": 1,

            "publishDate": "2024-09-20T14:20:03.000+00:00",

            "tags": "cao",

            "likes": 0,

            "views": 0,

            "top": false

        }

    ],

    "msg": "成功"

}
```

