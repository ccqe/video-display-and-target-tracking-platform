前端部分：VScode Vue

后端部分：eclipse SSM

第一部分，为以用户角色来运行系统的结果，如下所述。

用户注册模块运行结果，如图6.4。该模块的运行流程是打开系统地址，选择注册，跳转到注册界面，进行用户注册，发送axios的POST请求，获取到本地8090后台端口的adduser.action的Json数据，并且注册成功。

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml7416\wps1.jpg) 

图6.4 用户注册模块运行结果

用户登录模块运行结果，如图6.5。该模块的运行流程是点击返回登陆，进行用户登录，发送axios的POST请求，获取到本地8090后台端口的login.action的Json数据，登录成功并且跳转到系统主界面。

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml7416\wps2.jpg) 

图6.5 用户登录模块运行结果

视频监控模块运行结果，如图6.6。该模块的运行流程是点击“跨视频监控”侧栏项目，页面在创建该业务组件时，发送axios的GET请求，获取到本地8090后台端口的rtmp.action的Json数据，再进行页面渲染，从而使页面显示出摄像头名称和摄像头所对应视频流的播放。

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml7416\wps3.jpg) 

图6.6 视频监控模块运行结果

地图显示模块运行结果，如图6.7。点击“地图显示”侧栏项目，页面在创建该业务组件时，发送axios的GET请求，获取到本地8090后台端口的camera.action的Json数据，再进行地图呈现、创建标点和添加标点属性，从而使页面可以显示出摄像头标点的同时，还可以在当鼠标覆盖标点时显示实时摄像头人数和车辆数信息。

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml7416\wps4.jpg) 

图6.7 地图显示模块运行结果

视频回放模块运行结果，如图6.8。点击“视频回放”侧栏项目，页面再创建该业务组件后，先显示一个form表单，填写表单内容，点击查找，则页面发送axios的POST请求并携带表单填写的数据，获取到本地8090后台端口的video.action的Json数据，若拿到了数据，则数据复制给组件隐藏的<video-player>的视频地址属性，并将视频播放显示出来。

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml7416\wps5.jpg) 

图6.8 视频回放模块运行结果

数据统计模块运行结果，如图6.9，分别为表单提交前和表单提交后的运行结果 。点击“数据统计”侧栏项目，页面再创建该业务组件后，先显示一个form表单的一个图表，此时图表没有数据，所以图表只有一个大致的框，当填写表单内容，点击查找，则页面发送axios的POST请求并携带表单填写的数据，获取到本地8090后台端口的data.action的Json数据，若拿到了数据，则将数据赋值给图表的data数据属性，从而图表有数据显示。

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml7416\wps6.jpg) 

图6.9 数据统计模块运行结果

403异常处理部分，如图6.10所示。当普通用户想要打开摄像头管理或者用户管理时，因为没有权限就会跳转到403异常页面。

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml7416\wps7.jpg) 

图6.10 403异常模块运行结果

第二部分，为以管理员角色来运行系统的结果，管理员角色也可以完成用户角色的视频监控、视频回放、地图显示和数据统计业务模块，不再演示。管理员角色对于摄像头管理和用户管理的运行结果，如下所述。

管理员登录模块运行结果，如图6.11。该模块的运行流程是点击返回登陆，进行用户登录，发送axios的POST请求，获取到本地8090后台端口的login.action的Json数据，登录成功并且跳转到系统主界面。

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml7416\wps8.jpg) 

图6.11 管理员登录模块运行结果

摄像头管理模块中，摄像头列表显示部分运行结果，如图6.12和6.13，分别为不查询和查询摄像头列表显示运行结果。该部分的运行流程是点击“摄像头管理”侧栏项目中摄像头列表，页面在创建该业务组件时，发送axios的POST请求，获取到本地8090后台端口的cameralist.action的Json数据，再进行页面渲染，从而得到摄像头列表，也可以根据摄像头名称查询后，发送axios的POST请求，获取到本地8090后台端口的cameralist.action的Json数据，再进行页面渲染，从而得到相关用户列表。

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml7416\wps9.jpg) 

图6.12 不查询时摄像头列表显示部分运行结果

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml7416\wps10.jpg) 

图6.13 查询时摄像头列表显示部分运行结果

摄像头编辑部分运行结果，如图6.14。该部分的运行流程是在摄像头列表中点击编辑，完成编辑后，发送axios的POST请求，获取到本地8090后台端口的updatecamera. action的Json数据，并修改成功。

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml7416\wps11.jpg) 

图6.14 摄像头编辑部分运行结果

摄像头删除部分运行结果，如图6.15。该部分的运行流程是在摄像头列表中点击删除，确认删除后，发送axios的POST请求，获取到本地8090后台端口的deletecamera. action的Json数据，并删除成功。

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml7416\wps12.jpg) 

图6.15 摄像头删除部分运行结果

摄像头添加部分运行结果，如图6.16。该部分的运行流程是点击“摄像头管理”侧栏项目中摄像头添加，编辑添加的用户信息，点击提交后，发送axios的POST请求，获取到本地8090后台端口的addcamera.action的Json数据，并添加成功。

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml7416\wps13.jpg) 

图6.16 摄像头添加部分运行结果

用户管理模块中，用户列表显示部分运行结果，如图6.17和6.18，分别为不查询和查询用户列表显示运行结果。该部分的运行流程是点击“用户管理”侧栏项目中用户列表，页面在创建该业务组件时，发送axios的POST请求，获取到本地8090后台端口的cameralist.action的Json数据，再进行页面渲染，从而得到用户列表，也可以根据用户名查询后，发送axios的POST请求，获取到本地8090后台端口的userlist.action的Json数据，再进行页面渲染，从而得到相关用户列表。

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml7416\wps14.jpg) 

图6.17 不查询时用户列表显示部分运行结果

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml7416\wps15.jpg) 

图6.18 查询时用户列表显示部分运行结果

用户编辑部分运行结果，如图6.19。该部分的运行流程是在用户列表中点击编辑，完成编辑后，发送axios的POST请求，获取到本地8090后台端口的updateuser.action的Json数据，并修改成功。

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml7416\wps16.jpg) 

图6.19 用户编辑部分运行结果

用户删除部分运行结果，如图6.20。该部分的运行流程是在用户列表中点击删除，确认删除后，发送axios的POST请求，获取到本地8090后台端口的deleteuser.action的Json数据，并删除成功。

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml7416\wps17.jpg) 

图6.20 用户删除部分运行结果

用户添加部分运行结果，如图6.21。该部分的运行流程是点击“用户管理”侧栏项目中用户添加，编辑添加的用户信息，点击提交后，发送axios的POST请求，获取到本地8090后台端口的adduser.action的Json数据，并添加成功。

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\ksohtml7416\wps18.jpg) 

图6.21 用户添加部分运行结果