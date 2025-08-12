package org.sovliv.customstarterexample.support;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.WriteListener;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Vladimir Solovyov
 * @project custom-starter-example
 * @date on 08/08/2025
 */

public class DelegatingServletOutputStream extends ServletOutputStream {

    private final OutputStream targetStream;

    public DelegatingServletOutputStream(OutputStream targetStream) {
        this.targetStream = targetStream;
    }

    @Override
    public void write(int b) throws IOException {
        targetStream.write(b);
    }

    @Override
    public void flush() throws IOException {
        targetStream.flush();
    }

    @Override
    public void close() throws IOException {
        targetStream.close();
    }

    @Override
    public boolean isReady() {
        return true; // для простоты
    }

    @Override
    public void setWriteListener(WriteListener listener) {
        // Ничего не делаем — поддержка async-IO не требуется
    }}
