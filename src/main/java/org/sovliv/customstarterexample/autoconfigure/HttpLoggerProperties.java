package org.sovliv.customstarterexample.autoconfigure;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vladimir Solovyov
 * @project custom-starter-example
 * @date on 03/08/2025
 */

@Getter
@ConfigurationProperties(prefix = "http.logger")
public class HttpLoggerProperties {
    private final boolean enabled = true;
    private final List<String> excludedPaths = new ArrayList<>();
    private final boolean logBody = false;
}
