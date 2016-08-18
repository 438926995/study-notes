##已完成:
1. redis
2. slf4j日志

##任务:
1. 使用hibernate

##问题
1. hibernate连接数据库 报
Caused by: java.lang.NoSuchMethodError: javax.persistence.Table.indexes()[Ljavax/persistence/Index;
* 原因:后来发现是pom中引入
        <code>`<dependency>
            <groupId>javax.persistence</groupId>
            <artifactId>persistence-api</artifactId>
            <version>1.0.2</version>
        </dependency>`<code>
和hibernate 中 hibernate-jpa-2.1-api冲突
(ps: 这个问题tomcat运行没问题, 但是junit有问题)
* 解决方法: 将persistence-api 房子 hibernate-jpa-2.1-api之后 问题解决


