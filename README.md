# SpringCloudLearning
微服务学习

#eureka-server
服务注册中心，使用1111端口；也可以通过指定peer1和peer2配置文件模拟eureka集群。
eureka-server-ha为集群形式

#config-server-eureka
配置中心，使用7001端口，从http://git.oschina.net/didispace/SpringCloud-Learning/Chapter1-1-8/config-repo读取配置文件。

#config-client-eureka
读取配置文件的客户端，使用7002端口，从config-server-eureka里读取配置文件。结合了rabbitmq，使用5672连接。

#zipkin-server
系统性能中心，使用9411端口，可以跟踪服务的调用时间、调用关系等等。

#api-gateway
三个都为网关服务，使用5555等端口，请求方式http://localhost:5555/api-a/hello?accessToken=token等。

#hystrix
熔断服务，使用9441等端口。

#trace-1
服务调用者，使用9101/trace-1访问

#trace-2
服务提供者，使用9102/trace-2访问
