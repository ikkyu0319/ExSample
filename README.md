# ExSample
ExLibrary's Sample~


采用全新的架构MVP模式，降低耦合度
优点：
     (1)降低耦合度
     (2)模块职责划分明显
     (3)利于测试驱动开发
     (4)代码复用
     (5)隐藏数据
     (6)代码灵活性
缺点：学习成本

View不直接与Model交互，而是通过与Presenter交互来与Model间接交互
Presenter与View的交互是通过接口来进行的，更有利于添加单元测试
通常View与Presenter是一对一的，但复杂的View可能绑定多个Presenter来处理逻辑 


网络请求： Volley + OkHttp

图片处理：freso  or ImageLoader or picasso

图片放大处理：PhotoView

Json解析 ：Gson or fastGson

数据库ORM：ormlite

事件发布，订阅：EventBus

其它：butterknife








































