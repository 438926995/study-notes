##已完成:
1. redis
2. slf4j日志
3. 简单hibernate搭建
4. spring-security 登录验证, oauth2
5. 加入 spring rabbitmq
6. 加入 spring quartz
7. lombok (使用需要下载lombok插件,要不会报错)
8. 简单dubbo搭建

##任务:
1. 使用hibernate(over)
2. 加入spring-security

##dubbo
* 使用dubbo需要下载 zookeeper mac 可用 brew install zookeeper 下载
* 需要运行阿里[dubbo-admin](https://github.com/alibaba/dubbo)
* 自己dubbo消费方实现[dubbo consumer](https://github.com/438926995/dubboConsumer)
* 以上实现具体可参考[Dubbo分布式服务框架入门](http://www.kancloud.cn/digest/javaframe/125576)


##问题:
1. hibernate连接数据库 报<br>
Caused by: java.lang.NoSuchMethodError: javax.persistence.Table.indexes()[Ljavax/persistence/Index;<br>
######原因:
    后来发现是pom中引入<br>

        <dependency>
            <groupId>javax.persistence</groupId>
            <artifactId>persistence-api</artifactId>
            <version>1.0.2</version>
        </dependency>

    和hibernate 中 hibernate-jpa-2.1-api冲突<br>
    (ps: 这个问题tomcat运行没问题, 但是junit有问题)<br>
######解决方法:
    将persistence-api 放在 hibernate-jpa-2.1-api之后 问题解决

2. hibernate Queryb.setParameter(orinId, obj) obj 不能为 long
<br>
######解决方法:
对于特殊类型手动处理

3. redis整合spring问题

        Caused by: java.lang.NoSuchMethodError: org.springframework.core.serializer.support.DeserializingConverter.<init>(Ljava/lang/ClassLoader;)V

    ######原因:
    spring版本和spring-redis版本不兼容,我使用的spring-redis版本高了点,选择将spring-redis降低一个小版本 问题解决
##总结:
1. hibernate中hql不支持原生的insert语句, 要使用executeUpdate()只能是

        insert into Object (id, name) select oo.id, oo.name from OtherObject oo

或者用session.save(Object obj) 方法


