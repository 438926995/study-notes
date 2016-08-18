##已完成:
1. redis
2. slf4j日志

##任务:
1. 使用hibernate

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
######解决方法:
对于特殊类型手动处理

##总结:
1. hibernate中hql不支持原生的insert语句, 要使用executeUpdate()只能是

        insert into Object (id, name) select oo.id, oo.name from OtherObject oo

或者用session.save(Object obj) 方法


