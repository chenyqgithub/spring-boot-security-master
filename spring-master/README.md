#spring-master
    两个独立模块 spring-security spring-web
    均可正常运行
    当spring-web引用spring-security模块时spring-web就带有权限模块了
    
    spring-web启动类上
    添加注解@ComponentScan(basePackages ="com.master.spring.*")
    任何访问均通过权限验证后处理结果
    