package io.github.vaibhav.correlation.utils;

import org.slf4j.MDC;
import org.springframework.util.StringUtils;

import java.util.UUID;

import static io.github.vaibhav.correlation.utils.Constants.REQUEST_MARKER_MDC_KEY;


public class Correlation {

    private Correlation() {
    }

    public static String getCorrelationId() {
        String correlationId = MDC.get(REQUEST_MARKER_MDC_KEY);
        if (StringUtils.isEmpty(correlationId)) {
            setCorrelationId(correlationId);
        }
        return correlationId;

    }

    public static void setCorrelationId(String correlationId) {
        if (StringUtils.isEmpty(correlationId)) {
            correlationId = generateCorrelationId();
        }
        MDC.put(REQUEST_MARKER_MDC_KEY, correlationId);
    }

    private static String generateCorrelationId() {
        return UUID.randomUUID().toString();
    }
}
