package hello;

import org.springframework.cloud.netflix.zuul.filters.post.SendErrorFilter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;


public class ErrorExtFilter extends SendErrorFilter{

	@Override
	public boolean shouldFilter() {
		// TODO 判断：仅处理来自post过滤器引起的异常
		RequestContext ctx = RequestContext.getCurrentContext();
		ZuulFilter failedFilter = (ZuulFilter) ctx.get("failed.filter");
		if(failedFilter != null && failedFilter.filterType().equals("post")) {
			return true;
		}
		return false;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 30;   //大于ErrorFilter的值
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "error";
	}
	
}
