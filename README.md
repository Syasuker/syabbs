# syabbs

## 使用语言
JAVA
## 开发环境
eclipse+JDK1.8+Tomcat7+MySQL5+Maven
## 开发框架
SpringMVC+Mybatis+bootstrap
## 部署地址
[syabbs](http://syabbs.daoapp.io/syabbs) 

## 完成的部分

拟将贴子页写成静态页面做SEO优化;不出现get请求的标准写法;√
设计回帖界面 目前构思是做一个table   然后姓名和内容做成表格的不同部分参考[自由]等通用论坛 √

## 需求

用户权限完善
分页查询
看贴页面的回帖部分;
论坛板块的实现;
翻页使用#page-1等来实现
cn/sya/bbs/service/CommentServiceImpl.java   TODO
美化错误弹窗;
当用户是从页面登录;登录成功后应该跳转回登陆前页面
贴子搜索功能====>简单实现
List页面加载过慢或许考虑重构?????
session写个缓存;如果再次读取就不再读取了

思考:使用JSP是否不利于给手机APP提供接口;或许JSON统一后端接口是比较不错的选择;