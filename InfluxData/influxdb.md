1.配置:
InfluxDB的默认配置文件:/etc/influxdb/influxdb.conf
生成一个新的InfluxDB的配置文件:influxd config > influxdb.generated.conf
有两种方式使得启动InfluxDB使用新的配置文件:
* 使用-config选项,指定启动InfluxDB需要使用的配置文件:influxd -config influxdb.generated.conf
* 设置环境变量'INFLUXDB_CONFIG_PATH'为需要指定的InfluxDB的配置文件路径,然后启动再启动InfluxDB.
组合使用config和-config选项,如:influxd config -config /etc/influxdb/influxdb.partial.conf;可以联合默认的配置文件以及-config选项指定的配置文件.配置文件中指定的选项将会覆盖内部生成的默认配置选项.

2.连接
命令influx可以打开influxdb的CLI(命令行接口),默认连接到http://localhost:8086,CLI中命令不区分大小写
在InfluxDB的CLI中:
* exit退出CLI
* CREATE DATABASE <db-name> 创建数据库
数据库名如果只包含ASCII字母、数字或下划线并且没有以数字开头,则可以不加双引号;否则需要加双引号,双引号中可以为任何unicode字符.
* SHOW DATABASES 展示所有的数据库
* USE <db-name> 使用指定的数据库
* INSERT 往数据库中插入数据

3.数据存储
<measurement>[,<tag-key>=<tag-value>...] <field-key>=<field-value>[,<field2-key>=<field2-value>...] [unix-nano-timestamp]
