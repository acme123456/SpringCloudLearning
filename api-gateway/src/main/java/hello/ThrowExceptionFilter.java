package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;

@Component
public class ThrowExceptionFilter extends ZuulFilter{
	private static Logger log = LoggerFactory.getLogger(ThrowExceptionFilter.class);

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}
	
	@Override
	public Object run() {
		log.info("This is a pre filter, it will throw a RuntimeException");
		doSomething();
		return null;
	}
	
	private void doSomething() {
		throw new RuntimeException("Exist some errors……");
	}
	
}
