dubbo 的依赖注入

调用的接口的目标方法上有个注解 @Adaptive
有个value值，这个value就是url里面的对应的key的value
value就是spi文件里面的对应的"="左边的值。