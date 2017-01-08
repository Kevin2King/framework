# FUNTL FRAMEWORK

## 简介

Funtl Framework 基于多个优秀开源项目，高度整合封装，提供了互联网项目常用的工具类，如：在线支付、阿里云OSS、消息队列、Redis缓存、短信验证、百度编辑器、微信SDK等

## 模块

### funtl-framework-core

核心模块，主要提供开发所需的常用支持，包括：

* 使用 Hibernate Validate 对 ORM 对象验证
* 全局的配置类，快速获取 properties 属性文件的键值对
* 整合 Swagger 快速生成 API
* 通用的 JSON 数据返回对象
* 实现 Jaxb2.0 XML <-> Java Object 的互相转换
* 封装 Jackson ，实现 Json String <-> Java Object 的互相装换
* 支持 HMAC-SHA1 消息签名 及 DES/AES对称加密的工具类
* 支持 SHA-1/MD5 消息的工具类
* 序列化与反序列化工具类
* 实现 Github Kaptcha 图形验证码
* 提供了基于 Sigar 跨平台的系统信息收集API，由C语言实现。可以收集的信息包括：
    * CPU信息，包括基本信息（vendor、model、mhz、cacheSize）和统计信息（user、sys、idle、nice、wait）
    * 文件系统信息，包括Filesystem、Size、Used、Avail、Use%、Type
    * 事件信息，类似Service Control Manager
    * 内存信息，物理内存和交换内存的总数、使用数、剩余数；RAM的大小
    * 网络信息，包括网络接口信息和网络路由信息
    * 进程信息，包括每个进程的内存、CPU占用数、状态、参数、句柄
    * IO信息，包括IO的状态，读写大小等
    * 服务状态信息
    * 系统信息，包括操作系统版本，系统资源限制情况，系统运行时间以及负载，Java的版本信息等
* 条形码工具类
* 二维码工具类
* 基于 Ehcache 的缓存工具类
* Collections 工具集
* Cookie 工具类
* 日期工具类
* 时间计算工具类
* 封装各种格式的编码解码工具类，包括：
    * Commons-Codec 的 hex/base64 编码
    * 自制的 base62 编码
    * Commons-Lang 的 xml/html escape
    * 封装 JDK 提供的 URLEncoder
* 自定义的异常工具类
* 文件操作工具类，实现文件的创建、删除、复制、压缩、解压以及目录的创建、删除、复制、压缩解压等功能
* FreeMarkers 工具类
* 封装各种生成唯一性ID算法的工具类
* Jedis Cache 工具类
* 对象操作工具类
* Properties文件载入工具类
* 反射工具类，提供调用 getter/setter 方法, 访问私有变量, 调用私有方法, 获取泛型类型Class, 被AOP过的真实类等工具函数
* 常用正则验证工具类
* 提供了静态的 Spring ApplicationContext，可在任何代码任何地方任何时候取出 ApplicaitonContext
* 字符串工具类
* 用户代理字符串识别工具，主要用于识别手机、电脑、平板等不同设备下的不同浏览器
* 通用的 Spring MVC Controller
* 通用的 Servlet