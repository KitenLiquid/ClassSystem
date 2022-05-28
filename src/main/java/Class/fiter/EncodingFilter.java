package Class.fiter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class EncodingFilter
 */
@WebFilter(filterName = "EncodingFilter",urlPatterns = {"/*"},
            initParams = {@WebInitParam(name="language",value="java")})
public class EncodingFilter extends HttpFilter implements Filter {
	private String encoding="utf-8";
    static int count=0;
    public EncodingFilter() { }
    public void destroy() {
    	System.out.println("-------------end-----------");
    	encoding=null;
    	    }
	public void doFilter(ServletRequest req,ServletResponse resp,FilterChain chain) throws IOException, ServletException{

			//����������������������ı��뷽ʽ
			req.setCharacterEncoding(encoding);

			//������Ӧ��������������Ӧ�ı��뷽ʽ
			resp.setCharacterEncoding(encoding);
			resp.setContentType("text/html; charset=utf-8");

			//���������Ӧ���ݵ���һ��filter
			chain.doFilter(req, resp);
			System.out.println("--------��"+ (++count) +"�ι���---------");
	}
			
	
	public void init(FilterConfig filterConfig) throws ServletException {
        // �õ�������������
        String filterName = filterConfig.getFilterName();

        // �õ���web.xml�ļ������õĳ�ʼ������
        String initParam1 = filterConfig.getInitParameter("language");
        String initParam2 = filterConfig.getInitParameter("encoding");
        
        System.out.println("--------����"+filterName+"������--------");
        System.out.println("language="+initParam1+", encoding="+initParam2);
    }

}
