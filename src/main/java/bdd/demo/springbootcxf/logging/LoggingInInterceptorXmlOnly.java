package bdd.demo.springbootcxf.logging;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingMessage;

/**
 *
 * @author Bhadresh Desai
 */
public class LoggingInInterceptorXmlOnly extends LoggingInInterceptor {

    @Override
    protected String formatLoggingMessage(LoggingMessage loggingMessage) {
        StringBuilder buffer = new StringBuilder();
        buffer.append("Inbound XML:\n");
        if(loggingMessage.getPayload().length() > 0) {
            buffer.append(loggingMessage.getPayload());
        }
        return buffer.toString();
    }
}
