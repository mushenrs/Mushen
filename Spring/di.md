Spring IOC容器负责创建应用程序中的Bean并协调这些Bean之间的关系,提供了三种主要的装配机制:
* 在XML中进行显式配置;
* 在Java中进行显示配置;
* 隐式的Bean发现机制和自动装配.

1.自动化装配Bean
Spring从两个角度实现自动化装配:
* 组件扫描(component scanning):IOC容器会自动发现应用上下文中所创建的Bean;
* 自动装配(autowiring):IOC自动满足Bean之间的依赖.
1.1 注解
* @Component: 表明该类会作为组件类,并且告知Spring IoC容器需要为这个类创建Bean.
@Component
public class CompactDisc {
}
* @Configuration
* @ComponentScan 组件扫描默认是不启动,需要显示配置,该注解会启用组件扫描,默认会扫描与配置类相同的包.可以给注解设置属性basePackages的值, 为需要进行扫描的包.
@Configuration
@ComponentScan(basePackages = {"me.mushen.athena.di"})
public class JavaConfig {
}
也可以在XML配置文件中进行如下的配置:
<context:component-scan base-package="me.mushen.athena.di.bean" />
