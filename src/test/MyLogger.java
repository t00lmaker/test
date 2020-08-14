package test;


import java.io.StringWriter;

import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.WriterAppender;


public class MyLogger {
    
	Logger logger;
    StringWriter stringWriter; 
    
    MyLogger(){
	    stringWriter = new StringWriter();
	    logger = Logger.getLogger("command");
	    
	    Layout layout = new PatternLayout("%d %5p [%t] %c{1} %X{loginId, requestId} - %m%n");
	    WriterAppender writerAppender = new WriterAppender(layout, stringWriter);
	    logger.addAppender(writerAppender);
    }
    
    public Logger getLogger() {
    	return logger;
    }
    
    @Override
    public String toString() {
    	return stringWriter.toString();
    }

}
