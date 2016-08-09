### 安装
CentOS
默认安装的配置文件:/etc/telegraf/telegraf.conf
启动服务:service telegraf start

### 配置
1.配置文件
创建一个默认配置文件:telegraf -sample-config > telegraf.conf
创建一个包含指定输入和输出的配置文件:telegraf -sample-config -input-filter <pluginname>[:<pluginname>] -output-filter <outputname>[:<outputname>] > telegraf.conf
telegraf -sample-config -input-filter cpu:mem:net:swap -output-filter influxdb:kafka > telegraf.conf
2.系统环境变量
在配置文件中使用环境变量,需要加上前缀'$':
* 字符串环境变量,需要加双引号: "$STR_VAR"
* 数字或布尔类型的环境变量,直接使用: $NUM_VAR, $BOOL_VAR
3.全局标签([global_tags])配置
格式:key="value"
全局标签定义在[global_tags]区域中,所有在当前Host上收集的指标数据,都会带有在该区域中指定的标签.
4.代理([agent])配置
* interval:所有输入的默认收集数据的间隔,如: "10s"
* round_interval:以interval轮询收集数据,可选值为true或false,如: interval的值为"10s",则会在:00, :10, :20等收集数据
* metric_batch_size:批量发送数据的最大数量,如: 1000
* metric_buffer_limit:为每个输出缓存数据的数量,并且刷新数据到写中,是metric_batch_size配置的至少两倍大小,如:10000
* collection_jitter:每个插件会在收集数据之前随机sleep在该数据范围内的一段时间,如:"0s";可以避免许多插件在同一时间查询文件系统的数据,对系统可以有显著的性能提升
* flush_interval:所有输出的默认数据刷新间隔,不可以比interval设置的数据小,如:"10s";最大值:flush_interval+flush_jitter
* flush_jitter:随机抖动刷新间隔,当用户运行大量的telegraf时,避免大量的写峰值,如:"0s",当flush_jitter为5s,flush_interval为10s时,每隔10~15s就会刷新一次数据
* debug:是否以debug模式运行telegraf,可选值为true或false
* quiet:是否以quiet模式运行telegraf,可选值为true或false
* hostname:覆盖默认的hostname,如果为"", 则使用os.Hostname()
* omit_hostname:在telegraf的代理中是否忽略host标签,可选值为true或false,如果是true,将忽略
5.度量过滤
可以为每个输入输出配置过滤器:
* namepass: 用于筛选当前输入的度量集,值是一个字符串数组;数组中的每个字符串用于匹配度量值,如果匹配上,则会被发出.
* namedrop: 与namepass相反,如果匹配上,则不会被发出.
* fieldpass:字符串数组,用于匹配当前输入的字段名称,匹配上,则会被发出,对输出不起作用.
* fielddrop:与fieldpass想法,匹配上则不会被发出,对输出不起作用.
* tagpass:匹配tag名称
* tagdrop:与tagpass相反
* tagexclude:排除度量值中的一个标签,tagexclude与tagdrop不同的是,它只是简单的从度量值中去掉给定的标签,可以在输入和输出中使用.不过建议在输入的时候就进行排除到没用的标签
* taginclude:它只会在最后测量值中包含指定的标签
6.输入配置



