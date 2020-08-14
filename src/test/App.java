package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

public class App {

	public static void main(String[] args) throws IOException, InterruptedException {
		MyLogger mLogger = new MyLogger();
		Logger logger = mLogger.getLogger();
	    logger.info("#1");
	    logger.error("#2");
	    logger.debug("#3");
	    logger.fatal("#4");
	    
	    ProcessBuilder processBuilder = new ProcessBuilder();
	    
	    processBuilder.command("bash", "-c", "ls /home/luan/");
	    
	    // processBuilder.command("cmd.exe", "/c", "dir C:\\Users\\mkyong");
	    
	    Process process = processBuilder.start();
	    
	    //logger.info(new String(IOUtils.toByteArray(process.getOutputStream())));
	    
	    logger.info(process.waitFor());

	    logger.info(output(process.getInputStream()));
	    
	    System.out.println(mLogger);
	}
	
    private static String output(InputStream inputStream) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(inputStream));
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line + System.getProperty("line.separator"));
            }
        } finally {
            br.close();
        }
        return sb.toString();
    }
}
