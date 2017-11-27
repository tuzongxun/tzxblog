## 使用spring boot创建的博客小项目
### 项目说明
本项目旨在练习spring boot各知识点的应用，以java后端为主，某些地方可能会显得是为了应用而应用。<br/>
前端要求很低，只是像那么回事就行了，有兴趣学习spring boot的同学可以作为简单的参考。<br/>
同时，本项目尽量做成一个方便本地使用的文件管理系统，包含单不限于博客文章、pdf书籍阅读、资料管理等功能</br>

### 基础环境说明
>spring boot版本1.5.4<br/>
>java版本1.8<br/>
>maven版本3.2.5<br/>
>使用spring boot结合thymeleaf模板实现页面<br/>
>mysql5.6<br/>
>持久层使用jpa<br/>

### 涉及的后端具体关键技术点
>jpa操作数据库<br/>
>ServletRequestListener监听器实现访问量的增长<br/>
>spring boot做基本架构<br/>
>spring boot内嵌tomcat服务器<br/>
>thymeleaf模板渲染html填充数据<br/>
>引入showdown.min.js文件实现对markdown语法的支持

### 基础效果截图如下：
![页面布局截图](images/buju1.png)

### 历程及已实现功能
**2017-9-26:** 基础页面布局，初次提交到github</br>
**2017-9-28:** 后台基础代码编写和数据库设计</br>
**2017-9-29:** 前端页面增加对markdown语法的支持</br>
**2017-11-27:** 增加login页面，使用ajax请求，同时基础页面布局增加bootstrap支持</br>

### 预计功能说明
1. 实现类似博客的文章访问功能，如文章标题、内容
1. 实现文章统计功能，如字数、时间、分类
1. 实现pdf书籍阅读功能
1. 实现资料上传和下载、资料列表功能