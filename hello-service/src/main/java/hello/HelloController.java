package hello;

import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	//注释的两处为一起统计访问次数的
/*	@Autowired
	private CounterService counterService;*/
	
	private final Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private DiscoveryClient client;
	
	
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public String hello() throws Exception{
		//long start = System.currentTimeMillis();
		
		@SuppressWarnings("deprecation")
		ServiceInstance instance = client.getLocalServiceInstance();
		//让线程等待几秒钟
		int sleepTime = new Random().nextInt(3000);
		logger.info("sleepTime:" + sleepTime);
		Thread.sleep(sleepTime);
		
		logger.info("/hello,host:" + instance.getHost() + ",service_id:" + instance.getServiceId());
		return "Hello World!";
	}
/*	public String index() {
//		counterService.increment("didispace.hello.count");
		@SuppressWarnings("deprecation")
		ServiceInstance instance = client.getLocalServiceInstance();
		logger.info("/hello,host:" + instance.getHost() + ",service_id:" + instance.getServiceId());
		return "Hello World!";
	}*/

}
