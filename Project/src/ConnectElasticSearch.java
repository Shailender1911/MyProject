

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;


public class ConnectElasticSearch {
	
	 public static int readLogs(Logs log) throws ClientProtocolException, IOException {
		 	String payload = "{" +
            "\"time_stamp\": \"" + log.getTime_stamp() + "\", " +
            "\"module_name\": \"" + log.getModule_name() + "\", " +
            "\"host\": \"" + log.getHost_name() + "\", " +
            "\"file\": \"" + log.getFile_name() + "\", " +
            "\"function\": \"" + log.getFunction_name() + "\", "+
            "\"line\": \"" + log.getLine_no() + "\", " +
            "\"thread\": \"" + log.getThread_no() + "\", " +
            "\"msg\": \"" + log.getMsg() + "\"" +
            "}";
		 	
	 
	   StringEntity entity = new StringEntity(payload,ContentType.APPLICATION_JSON);

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost request = new HttpPost("http://172.25.25.44:9200/testing/test");
        request.setEntity(entity);

        HttpResponse response = httpClient.execute(request);
        System.out.println(response.getStatusLine().getStatusCode());
        return response.getStatusLine().getStatusCode();
		
	 }

	

}
