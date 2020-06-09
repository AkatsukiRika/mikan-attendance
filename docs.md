# MikanAttendance API Documents

数据库相关的内容请参照 setup.sql 中的建表语句

目前有 5 张数据表，每个数据表一个 URL，每个 URL 共 4 种方法：Post、Delete、Patch、Get，分别对应增删改查 4 种基本操作。

5 个数据表的 URL 分别如下（省略前缀`http://IP:PORT`）：

- /user/
- /suggestion/
- /salary/
- /productOrder/
- /attendance/

每个数据表共有 4 个方法，对应增删改查 4 个动作，这 4 个方法对应的 URL 全部都一样。
接口的送信格式为 JSON，具体注意事项如下：

1. POST 方法：无需传 id，传其他参数的时候 Key 的格式按照`src/main/java/com.example.mikanattendance/entity`里面的格式，例子如下：

   ```json
   {
   	"realName": "刘嘉豪",
   	"userPass": "123456",
   	"phone": "13812345678",
   	"email": "jiahao@ikemen.cn",
   	"userType": "HR"
   }
   ```

2. DELETE 方法：传对应 id，注意一定是小写的，不需要传别的就可以删除，例子如下：

   ```json
   {
   	"id": 6
   }
   ```

3. PATCH 方法：传对应 id（小写），再传想要更改的字段就可以 UPDATE 数据表了，例子如下：

   ```json
   {
   	"id": 5,
   	"realName": "洲哥"
   }
   ```

4. GET 方法：传任意字段（如 user 中的 realName），就可以获取对应的一条或多条数据了。如果传一个空的 JSON（`{}`），就可以获得全部的数据。例子如下：

   ```json
   {
   	"realName": "洲哥"
   }
   ```

注意：

- user 里面的 userPass 传明文原密码进去，后台会加密成 md5 格式
- 返回的数据中，如果 message 为 Operation succeeded 但是 data 为 0，那么说明未成功更改数据库
- 关于**时间**的操作（重要）：时间需全部转换为以秒为单位的 Unix 时间戳。若是单纯表示日期（比如`2020.06.09`），就把`2020.06.09 00:00:00`这个时间点转换为时间戳（即 1591632000 秒）。若是表示具体时间，可以精确到分或者秒。可以使用[在线工具](https://tool.lu/timestamp/)进行转换，代码中需要转换的话 Java 也有时间日期的包