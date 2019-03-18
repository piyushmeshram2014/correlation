package com.commonsources.correlation.config;

import org.slf4j.MDC;
import org.springframework.core.task.TaskDecorator;
import org.springframework.util.CollectionUtils;

import java.util.Map;

public class MDCTaskDecorator implements TaskDecorator {

    @Override
    public Runnable decorate(Runnable runnable) {
        // Right now: Web thread context !
        // (Grab the current thread MDC data)
        Map<String, String> contextMap = MDC.getCopyOfContextMap();
        return () -> {
            try {
                // Right now: @Async thread context !
                // (Restore the Web thread context's MDC data)
                if (!CollectionUtils.isEmpty(contextMap))
                    MDC.setContextMap(contextMap);
                runnable.run();
            } finally {
                MDC.clear();
            }
        };
    }
}
