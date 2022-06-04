package Index.Filter;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(filterName="EncodingFilter", urlPatterns={"/*"}, 
			initParams= {@WebInitParam(name="language", value="Java")})

public class EncodingFilter implements Filter {
	private String encoding="utf-8";
	static int count=0;

    public EncodingFilter() {   }

	public void init(FilterConfig filterConfig) throws ServletException {		
        String filterName = filterConfig.getFilterName();
        String initParam1 = filterConfig.getInitParameter("language");
        String initParam2 = filterConfig.getInitParameter("encoding");
        System.out.println("--------Æô¶¯"+filterName+"¹ýÂËÆ÷--------");
        System.out.println("language="+initParam1+", encoding="+initParam2);
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) 
			throws IOException, ServletException {		
		req.setCharacterEncoding(encoding);			
		resp.setCharacterEncoding(encoding);
		resp.setContentType("text/html; charset=utf-8");	
		chain.doFilter(req, resp);		
		
	}
	
	public void destroy() {
		System.out.println("-------------end-----------");
		encoding=null;
	}
}