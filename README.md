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


