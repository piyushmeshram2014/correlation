package org.commonsources.correlation.filter;

import org.commonsources.correlation.utils.Correlation;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

import static org.commonsources.correlation.utils.Constants.CO_RELATION_ID_HEADER;


public class CorrelationIdInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        HttpHeaders headers = request.getHeaders();
        headers.add(CO_RELATION_ID_HEADER, Correlation.getCorrelationId());
        return execution.execute(request, body);
    }
}
