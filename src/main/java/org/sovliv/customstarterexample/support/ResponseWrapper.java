package org.sovliv.customstarterexample.support;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;

/**
 * @author Vladimir Solovyov
 * @project custom-starter-example
 * @date on 03/08/2025
 */

public class ResponseWrapper extends HttpServletResponseWrapper {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final ServletOutputStream servletOutputStream = new DelegatingServletOutputStream(outputStream);

    public ResponseWrapper(HttpServletResponse response) {
        super(response);
    }

    @Override
    public ServletOutputStream getOutputStream() {
        return servletOutputStream;
    }

    public byte[] getBody() {
        return outputStream.toByteArray();
    }

    public String getBodyAsString() {
        return new String(getBody(), StandardCharsets.UTF_8);
    }
}