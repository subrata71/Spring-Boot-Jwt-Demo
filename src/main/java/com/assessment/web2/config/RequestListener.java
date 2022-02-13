package com.assessment.web2.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import java.util.UUID;

@WebListener
public class RequestListener implements ServletRequestListener {
    private static final Logger log = LoggerFactory.getLogger(RequestListener.class);

    public void requestInitialized(ServletRequestEvent arg0) {
        String requestId = UUID.randomUUID().toString();
        log.debug("Request initialized with request Id: {}", requestId);
        MDC.put("RequestId", requestId);
    }

    public void requestDestroyed(ServletRequestEvent arg0) {
        log.debug("Request destroyed");
        MDC.clear();
    }
}
