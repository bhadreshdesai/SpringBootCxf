package bdd.demo.springbootcxf.logging;

import org.apache.cxf.interceptor.LoggingMessage;
import org.apache.cxf.interceptor.LoggingOutInterceptor;

/**
 *
 * @author Bhadresh Desai
 */
public class LoggingOutInterceptorXmlOnly extends LoggingOutInterceptor {

    @Override
    protected String formatLoggingMessage(LoggingMessage loggingMessage) {
        StringBuilder buffer = new StringBuilder();
        buffer.append("Outbound XML:\n");
        if(loggingMessage.getPayload().length() > 0) {
            buffer.append(loggingMessage.getPayload());
        }
        return buffer.toString();
    }
    
}
