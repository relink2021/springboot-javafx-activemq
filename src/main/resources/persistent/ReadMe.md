### 消息持久化
Activemq持久化方式：当发送的消息**未被消费时**暂存在数据库或日志中

### JDBC配置方式
- 第一步：将同目录下的两个jar包(mysql-connector-java-8.0.27.jar和druid-1.2.9.jar)放在**activemq的lib文件夹**中
- 第二步：更改**conf/activemq.xml**配置
```
<!-- 配置消息持久化方式 -->
<persistenceAdapter>
    <!-- <kahaDB directory="${activemq.data}/kahadb"/> -->
    <jdbcPersistenceAdapter dataSource="#mysql-ds"/>
</persistenceAdapter>

<!-- 配置数据库连接池 -->
<bean name="mysql-ds" class="com.alibaba.druid.pool.DruidDataSource" destroy-method="close">
    <property name="driverClassName" value="com.mysql.cj.jdbc.Driver" />
    <!-- 地址改为本机IP地址 -->
    <property name="url" value="jdbc:mysql://localhost:3306/db_activemq"/>
    <!-- 数据库账号 -->
    <property name="username" value="root" />
    <!-- 数据库密码 -->
    <property name="password" value="123456"/>
</bean>
```
- 第三步：在数据库中新建名为db_activemq的数据库(与上面配置数据库的名称向对应)
- 第四步：重启activemq

### 使用方式
- 改为点对点模式(Activemq5 似乎不支持持久化topic)
- 由于我们采用的是收发一体的架构，使用同一个topic收发消息，消息已经发送就被自己消费了，想查看持久化的效果需要把接受的JmsListener注释掉
- 发送一条信息
- 到数据库db_activemq的activemq_msgs表中查看是否有一条消息，如果有表示消息持久化配置成功
