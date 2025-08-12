package org.sovliv.customstarterexample.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.sovliv.customstarterexample.autoconfigure.HttpLoggerProperties;

import java.io.IOException;

/**
 * @author Vladimir Solovyov
 * @project custom-starter-example
 * @date on 03/08/2025
 */

public class HttpLoggingFilter implements Filter {

    private final HttpLoggerProperties props;

    public HttpLoggingFilter(HttpLoggerProperties props) {
        this.props = props;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;

        if (!props.isEnabled() || props.getExcludedPaths().contains(req.getRequestURI())) {
            chain.doFilter(request, response);
            return;
        }

        System.out.println("Incoming: " + req.getMethod() + " " + req.getRequestURI());

        chain.doFilter(request, response);
    }
}
