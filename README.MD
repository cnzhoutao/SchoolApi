**接口文档**
获取所有的省份数据：
```html
getAllProvin.html
```
根据省份的id获取对应非学校信息：
```html
getSchNameByPid.html?pId=1
```
用户注册api
```html
http://localhost:8080/reg.html?userName=南柯一梦&phoneNum=1515757603561&schoolName=&pwd=123456
```
用户登录api
```html
http://localhost:8080/login.html?phoneNum=1515757603561&pwd=123456
```
获取所有帖子的api
```html
http://localhost:8080/getAllInvi.html
```

获取所有帖子，按viewNum倒序排列
```html
http://localhost:8080/getAllInviHot.html
```
上传帖子的api
```html
http://localhost:8080/uploadInvi.html?type=1&title="测试"&content="标题"&detailImg=list&phoneNum=15157603361
```
根据类别请求帖子及其对应的细节图
```html
http://localhost:8080/getInviAndImg.html?type=4
```
上传不含细节图的api
```html
http://localhost:8080/uploadInviText.html?type=1&title="标题"&content="neibfdg"&phoneNum=1
```
帖子收藏的api
```html
http://localhost:8080/saveInvi.html?inviId=4&phoneNum=1
```
取消收藏帖子的api
```html
http://localhost:8080/cancelSave.html?inviId=4&phoneNum=1
```
点赞的api
```html
http://localhost:8080/like.html?inviId=4&phoneNum=1
```
取消点赞的api
```html
http://localhost:8080/cancelLike.html?inviId=4&phoneNum=1
```
根据inviId和phoneNum获取某条帖子的具体内容及该用户是否收藏过，点赞过
```html
http://localhost:8080/getInviById.html?inviId=19&phoneNum=1
```
用户根据类别请求自己的帖子
```html
http://localhost:8080/getInviByType.html?type=2&phoneNum=1
```
帖子评论api
```html
http://localhost:8080/juge.html?inviId=4&phoneNum=1&content=评论内容
```
获取用户个人收藏的帖子
```html
http://localhost:8080/getSave.html?phoneNum=1
```

修改年龄的api

```html
http://localhost:8080/updateAge.html?phoneNum=1&age=11
```
修改性别的api
```html
http://localhost:8080/updateGender.html?phoneNum=1&gender=%E5%A5%B3
```
修改个人信息的api
```html
http://localhost:8080/updateMsg.html?phoneNum=1&msg=个人简介
```
根据手机号获取个人信息的api
```html
http://localhost:8080/getInfoByPhone.html?phoneNum=1
```
更改头像api
```html
http://localhost:8080/updateIcon.html?phoneNum=1&icon=icon.png
```

更改头像的api
```html
http://localhost:8080/updateIcon.html?phoneNum=1&userName=用户名
```
删除个人发帖及其相关内容
```html
http://localhost:8080/deletePInviById.html?inviId=60
```


**表结构**
detailImg
```html
	id
	invild  //对应帖子的细节图
 imgUrl   
```
inviLike
```html
	id
	invild 
 userId
 username
 userIcon
 creTime
```

inviSave
```html
id
inviId
userId
username
userIcon
creTime
```
inviTation
```html
id
type 
title
content
likeNum    //用户点赞数
creTime
jugeNum   //用户评论数
userId
userName
userIcon   //用户头像
viewNum  //浏览量

```
jugeInvi
```html
id
inviId    //帖子id
username    //评论者名字
userId      //评论者id
userIcon    //评论者头像
content    //内容
creTime

```

province
```html
id
pName
```


schoolName
```html
id
pId
scName
```
stu
```html
id
username   //用户名
pwd        //密码
phoneNum   //手机号
icon      //用户头像
creTime   //注册时间
school    //学校名称
msg      //用户个人简介
age
gender	//性别
isAdmin  //0表示普通用户,1表示管理员
```




