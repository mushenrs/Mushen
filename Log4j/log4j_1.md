org.apache.logging.log4j.LogManager
org.apache.logging.log4j.Logger
org.apache.logging.log4j.spi.LoggerContext
org.apache.logging.log4j.core.config.LoggerConfig
org.apache.logging.log4j.core.Appender
org.apache.logging.log4j.core.LogEvent
org.apache.logging.log4j.core.Logger

org.apache.logging.log4j.core.lookup.StrSubstitutor

1.Logger层次
在Log4j2中日志的层次不再是通过Logger之间的关系,而是通过LoggerConfig之间的关系
Logger和LoggerConfig都是实体对象,Logger的名字是区分大小写的,并且命名具有如下的层次规则:
1.一个LoggerConfig的名字后面加上点(.)是其他LoggerConfig的名字的前缀,则称这个LoggerConfig是这些LoggerConfig的祖先
2.如果一个LoggerConfig是另外一个LoggerConfig的祖先,并且他们之间没有祖先,则称这个LoggerConfig是那个LoggerConfig的父亲.
例如:LoggerConfig对象的名字是me.mushen, 这这个LoggerConfig是名字me.mushen.athena的LoggerConfig的父亲, 并且是名字为me.mushen.athena.log的LoggerConfig的祖先.
根LoggerConfig是LoggerConfig层次结构的顶端,它总是存在并且是任何LoggerConfig层次结构的一部分.直接链接到根LoggerConfig的Logger对象可以通过如下的方式获取到:
Logger ROOTLOGGER = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
或Logger ROOTLOGGER = LogManager.getRootLogger();
Logger对象的获取可以通过LogManager.getLogger()方法获取.

2.LoggerContext
LoggerContext在日志记录系统中充当锚点的作用,一个业务系统根据需求可能有多个可用的LoggerContext.

3.Configuration
每个LoggerContext都一个可用的Configuration,Configuration包括Appender, 上下文范围Filter, LoggerConfig和StrSubstitutor引用.
重新配置过程中会存在两个Configuration对象,一旦所有Logger都重定向新的Configuration对象,旧的Configuration会被停用,并被抛弃.

4.Logger
Logger通过LogManager.getLogger()方法创建,Logger本身不执行任何直接动作,它只是有一个名字并且和一个LoggerConfig相关联.
Logger继承AbstractLogger,当配置改变时,Logger可能与一个不同的LoggerConfig相关联.
调用LogManager.getLogger()方法创建Logger对象,如果名称相同,则返回的是同一个Logger对象的引用.例如:
Logger x = LogManager.getLogger("wombat");
Logger y = LogManager.getLogger("wombat");
System.out.println(x == y); // true
Log4j的环境配置的Configuration对象是在应用程序初始化的时候的进行初始化,首选方法是通过读取配置文件.
Logger的命名通常使用类的完全限定名,并且在每个类中进行实例化Logger,使用LogManager.getLogger(Class<?>)

5.LoggerConfig
LoggerConfig是在Logger在日志配置中声明的时候创建的,包含一个Filter集合,用于过滤发送给Appender的LogEvent;Appender集合,用于处理LogEvent事件.
日志级别
LoggerConfig会被设置一个日志级别,包括TRACE, DEBUG, INFO, WARN, ERROR, FATAL和OFF.Log4j 2支持自定义日志级别.
日志级别继承
如果Logger对象没有直接分配LoggerConfig对象,则会关联到它的父LoggerConfig,使用父LoggerConfig的日志级别.
Filter
除了通过日志级别自动过滤日志,Log4j提供过滤器(Filter)来过滤日志.过滤器可以应用在日志控制到LoggerConfig之前,或者应用在LoggerConfig之后, 在调用附着器(Appender)之前,或者或者应用在LoggerConfig之后,在调用特殊附着器(Appender)之前,或者每个附着器(Appender)上.
每个过滤器可以返回以下三种结果:接受(Accept), 拒绝(Deny)或者中立(Neutral):接受意味着其他的Filter不需要被调用,而且LogEvent将被处理; 拒绝意味着LoggerEvent应该立刻被忽略,并把控制权返回给调用者; 中立意味着LoggerEvent将被转交给其他的Filter, 如果没有其他的Filter,则将直接被处理.
尽管一个事件可能被过滤器接受,但是也有可能不被记录下来.会发生这种情况的可能性是事件被LoggerConfig的预过滤器接受,但是被LoggerConfig的过滤器拒绝或者被所有的附着器(Appender)拒绝.
Appender
Log4j可以让日志输出到多个目的地,启用或禁用日志记录请求
