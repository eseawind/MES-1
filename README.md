MES
===

上海海隆复合钢管制造有限公司MES系统


    公司主要业务为通过将不同型号的基管和不同型号的内衬管进行装配并经过多道工序加工成复合管。
    
    系统主要实现的功能为从订单下达后基管和衬管入场检测到合成复合管经过多道工序检测加工到最后包装发货整个生产过程的监控和管理。


系统框架 jquery easyui+springmvc+springframework+hibernate

系统基于maven构建

java包结构：

    com.hilonggroupmes.controller.* 控制器
    
    com.hilonggroupmes.dao.* dao层
    
    com.hilonggroupmes.domain.* 实体层
    
    com.hilonggroupmes.service.* 服务层
    
    com.hilonggroupmes.utils.* 工具层

web目录结构

    js -------所引用的库及手写的编写的js
    
    |---------lib  引用js库文件
    
    |---------xxx  手写js模块及文件
    
    page -----所用到的jsp页面文件夹
    
    WEB-INF --java web 相关的配置文件及编译好的java文件和引用lib
    
    index.jsp web系统登录页面
