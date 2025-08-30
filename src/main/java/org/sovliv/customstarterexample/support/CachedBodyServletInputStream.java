package org.sovliv.customstarterexample.support;

import jakarta.servlet.ReadListener;
import jakarta.servlet.ServletInputStream;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * @author Vladimir Solovyov
 * @project custom-starter-example
 * @date on 08/08/2025
 */

public class CachedBodyServletInputStream extends ServletInputStream {

    private final ByteArrayInputStream inputStream;

    public CachedBodyServletInputStream(byte[] cachedBody) {
        this.inputStream = new ByteArrayInputStream(cachedBody);
    }

    @Override
    public boolean isFinished() {
        return inputStream.available() == 0;
    }

    @Override
    public boolean isReady() {
        return true; // для простоты
    }

    @Override
    public void setReadListener(ReadListener listener) {
        // async не поддерживается
    }

    @Override
    public int read() throws IOException {
        return inputStream.read();
    }
}
