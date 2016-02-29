package shubhamjha33.codeforceanalyzer.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 *
 * @author shubham
 */
public class HttpClientUtil {
    
    public String getDataFromURL(URI uri){
        try {
            HttpGet httpGet=new HttpGet(uri);
            CloseableHttpClient httpClient=HttpClients.createDefault();
            CloseableHttpResponse httpResponse=httpClient.execute(httpGet);
            HttpEntity httpEntity=httpResponse.getEntity();
            InputStream is=httpEntity.getContent();
            StringBuffer str=new StringBuffer("");
            int b;
            while((b=is.read())!=-1){
                str.append((char)b);
            }
            System.out.println(str.length());
            return str.toString();
        } catch (IOException ex) {
            Logger.getLogger(StartServer.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }
    
}
