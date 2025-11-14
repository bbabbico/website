package project7.website.login;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public class URLFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        
        //get 파라미터 방식으로 리다이렉트 구현
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestURI = httpRequest.getRequestURI();
        httpRequest.setAttribute("url", requestURI);

        chain.doFilter(request, response);

    }
}
