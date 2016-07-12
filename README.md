# ExSample
ExLibrary's Sample~

##项目架构

采用全新的架构[MVP模式](https://github.com/bboyfeiyu/android-tech-frontier/tree/master/androidweekly/%E4%B8%80%E7%A7%8D%E5%9C%A8android%E4%B8%AD%E5%AE%9E%E7%8E%B0MVP%E6%A8%A1%E5%BC%8F%E7%9A%84%E6%96%B0%E6%80%9D%E8%B7%AF)，降低耦合度

    优点：
     1. 降低耦合度
     2. 模块职责划分明显
     3. 利于测试驱动开发
     4. 代码复用
     5. 隐藏数据
     6. 代码灵活性

    缺点：
      学习成本


View不直接与Model交互，而是通过与Presenter交互来与Model间接交互
Presenter与View的交互是通过接口来进行的，更有利于添加单元测试
通常View与Presenter是一对一的，但复杂的View可能绑定多个Presenter来处理逻辑 

##常用封装
	
	QQ空间，微信，微博，facebook分享；
	支付宝，微信，paypal ,信用卡支付；
	

## 参考优秀开源框架
响应式编程:

   * RxJava[RxJava文档中文版] <https://github.com/ReactiveX/RxJava>
   * RxAndroid <https://github.com/ReactiveX/RxAndroid>
   * Google agera <https://github.com/google/agera>

     **[RxJava 文档中文版本](https://mcxiaoke.gitbooks.io/rxdocs/content/)**
     
   **[RxJava 与 Retrofit 结合的最佳实践](http://gank.io/post/56e80c2c677659311bed9841)**
   
   **[深入浅出 Retrofit，这么牛逼的框架你们还不来看看？](https://mp.weixin.qq.com/s?__biz=MzA3NTYzODYzMg==&mid=2653577186&idx=1&sn=1a5f6369faeb22b4b68ea39f25020d28&scene=1&srcid=0605oJ1NiiihvcW5jF8iy3n6&key=f5c31ae61525f82e38a1a943febc987278275256a5df936f1119c6514ebc78df82fc229de80607e2372e4c0f1451e4db&ascene=0&uin=Mjc3OTU3Nzk1&devicetype=iMac+MacBookPro10%2C1+OSX+OSX+10.10.5+build%2814F1808%29&version=11020201&pass_ticket=Yfzg8hN3fuLjjXoQDSG%2BBKWgRxryyVOFVwGFzsu7nB%2FgSZp9gdXJS%2FudxKZSNLan)**


网络请求： 
				
   * VolleyPlus <https://github.com/DWorkS/VolleyPlus> 
   * OkHttp  <https://github.com/square/okhttp>
   * Retrofit <http://square.github.io/retrofit/>

图片处理：
   
   * freso <https://github.com/facebook/fresco>
   * Glide <https://github.com/bumptech/glide> 
   **[Glide和Picasso的比较](https://github.com/bboyfeiyu/android-tech-frontier/tree/master/others/Google%E6%8E%A8%E8%8D%90%E7%9A%84%E5%9B%BE%E7%89%87%E5%8A%A0%E8%BD%BD%E5%BA%93Glide%E4%BB%8B%E7%BB%8D)**
   * picasso <http://square.github.io/picasso/>
   * Android-Universal-Image-Loader <https://github.com/nostra13/Android-Universal-Image-Loader>
   * RoundedImageView[圆角处理] <https://github.com/vinc3m1/RoundedImageView>
   * PhotoView[放大] <https://github.com/chrisbanes/PhotoView>
   * 超大，超长图片的浏览 <https://github.com/davemorrissey/subsampling-scale-image-view>
   * 图片加Tag标签 <https://github.com/saiwu-bigkoo/Android-PictureTagView>

Json解析 ：

   * Gson  <https://github.com/google/gson>
   * fastGson <https://github.com/alibaba/fastjson>

数据库ORM：

   * squidb <https://github.com/yahoo/squidb>
   * ormlite <http://ormlite.com/>
   * greenDAO <https://github.com/greenrobot/greenDAO>

事件发布，订阅：

   * EventBus <https://github.com/greenrobot/EventBus>
   * AndroidEventBus
   * otto <http://square.github.io/otto/>

动画：

   * Facebook rebound <https://github.com/facebook/rebound>
   * NineOldAndroids <http://nineoldandroids.com/>

多点下载：

   * MultiThreadDownloader <https://github.com/AigeStudio/MultiThreadDownloader>

插件化&热修复:
   
   * 微信TinKer
   * react-native <https://github.com/facebook/react-native>
   * RocooFix<https://github.com/dodola/RocooFix>
   * 支付宝AndFix<https://github.com/alibaba/AndFix>
   * Small <https://github.com/wequick/Small>
   * DroidPlugin <https://github.com/DroidPluginTeam/DroidPlugin>

高性能数据传递：

* FlatBuffers <https://google.github.io/flatbuffers/>
* thrift  <https://github.com/apache/thrift>

其它：

   * butterknife <http://jakewharton.github.io/butterknife/>
   * dagger2.0 <https://github.com/google/dagger/>
   * ViewPagerIndicator <http://viewpagerindicator.com/>
   * Android-PullToRefresh <https://github.com/chrisbanes/Android-PullToRefresh>
   *  v3-utility-library <https://github.com/googlemaps/v3-utility-library>



##异常捕获&性能分析&测试

  * LeakCanary  <https://github.com/square/leakcanary/>
  * infe <https://github.com/facebook/infer>


##伟大的组织和个人

  * Square  <http://square.github.io/> 
  * facebook <https://github.com/facebook>
  * JakeWharton <https://github.com/JakeWharton> 
  * greenrobot <https://github.com/greenrobot>
  * Yalantis <https://github.com/Yalantis>
		


##推荐
  
  依赖库引用 <http://www.appbrain.com/stats/libraries>



##优秀的参考引用框架

其它Demo集合 <https://github.com/Tim9Liu9/TimLiu-Android> 


RecyclerView made simple <https://github.com/lucasr/twoway-view>

<https://github.com/chrisbanes/Android-PullToRefresh>

<https://github.com/chrisbanes/ActionBar-PullToRefresh>

MVP模式 <https://github.com/richardradics/MVPAndroidBootstrap>

CommonAdapter通用的Adapter <https://github.com/tianzhijiexian/CommonAdapter>



自定义切换Loading，empty，error <https://github.com/vlonjatg/progress-activity>
![icon]()

自定义Dialog <https://github.com/orhanobut/dialogplus>

 ![Icon](https://github.com/orhanobut/dialogplus/blob/master/art/dialogplus.gif)

相册图片单选，多选模式 <https://github.com/wqandroid/wqgallery>

![icon](https://github.com/wqandroid/wqgallery/raw/master/app/screenshort/wqgallert1.gif)



自定义图片形状 <https://github.com/siyamed/android-shape-imageview>

![icon](https://github.com/ShareSofa/android-shape-imageview/raw/master/images/all-samples.png)




Fragment 动画 <https://github.com/DesarrolloAntonio/FragmentTransactionExtended>

![icon](https://github.com/DesarrolloAntonio/FragmentTransactionExtended/raw/master/fragmentTransactionExample/cap2.gif)


<https://github.com/daimajia/AndroidSwipeLayout>

![icon](https://camo.githubusercontent.com/878e29e5defd2c64db4a5ec93119e133cab00807/687474703a2f2f7777322e73696e61696d672e636e2f6d773639302f36313064633033346a7731656a6f706c6170777471673230386e3065373464782e676966)

<https://github.com/pedant/sweet-alert-dialog>

![Icon](https://github.com/pedant/sweet-alert-dialog/raw/master/change_type.gif)

<https://github.com/Quinny898/PersistentSearch>

![icon](https://raw.githubusercontent.com/Quinny898/PersistentSearch/master/resources/search.gif)

<https://github.com/Yalantis/Taurus>

![icon](https://camo.githubusercontent.com/3a24e22eb3f8338573dba0701c089c12f6b70f11/68747470733a2f2f6431337961637572716a676172612e636c6f756466726f6e742e6e65742f75736572732f3132353035362f73637265656e73686f74732f313632333133312f746f7572732d70756c6c2d616972706c616e655f322d322d332e676966)

<https://github.com/alexvasilkov/FoldableLayout>

[![Demo video](http://img.youtube.com/vi/-_QcWMh-O5g/0.jpg)](http://www.youtube.com/watch?v=-_QcWMh-O5g)
	
Material Design Instagram <https://github.com/frogermcs/InstaMaterial>

[![App showcase](http://img.youtube.com/vi/VpLP__Vupxw/0.jpg)](http://www.youtube.com/watch?v=VpLP__Vupxw)

<https://github.com/Yalantis/Euclid>

![icon](https://camo.githubusercontent.com/b01a910b14ef3573c9e75ce150ef76e155cbbe98/68747470733a2f2f6431337961637572716a676172612e636c6f756466726f6e742e6e65742f75736572732f3132353035362f73637265656e73686f74732f313734343135372f39396d696c65732d7573657270726f66696c652d616e696d6174696f6e5f312d312d332e676966)

自定义字体<https://github.com/norbsoft/android-typeface-helper>

![icon](https://camo.githubusercontent.com/b8e7d4f4ab84ff96a3919ea264e2a83aca46e04e/68747470733a2f2f7261772e6769746875622e636f6d2f6e6f7262736f66742f616e64726f69642d74797065666163652d68656c7065722f6d61737465722f726561646d655f73637265656e2e706e67)

GoogleMusic <https://github.com/googlesamples/android-UniversalMusicPlayer>

![icon](https://github.com/googlesamples/android-UniversalMusicPlayer/raw/master/screenshots/phone.png)
![icon](https://github.com/googlesamples/android-UniversalMusicPlayer/raw/master/screenshots/phone_lockscreen.png)
![icon](https://github.com/googlesamples/android-UniversalMusicPlayer/raw/master/screenshots/phone_lockscreen.png)
![icon](https://github.com/googlesamples/android-UniversalMusicPlayer/raw/master/screenshots/android_auto.png)

Airbnb提供的地图解决方案，支持多个本地地图提供者包括谷歌地图V2和亚马逊地图V2。如果设备没有任何受支持的本地地图提供者,AirMapView会回退到基于web的地图提供者(目前谷歌地图) <https://github.com/airbnb/AirMapView>

![icon](https://github.com/airbnb/AirMapView/raw/master/screenshots/google_maps_v2.png)


![icon](https://github.com/airbnb/AirMapView/raw/master/screenshots/google_web_maps.png)



MaterialSpinner  <https://github.com/ganfra/MaterialSpinner>
![icon](https://github.com/ganfra/MaterialSpinner/blob/master/screenshots/screenshot.gif)

































