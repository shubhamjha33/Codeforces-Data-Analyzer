package shubhamjha33.codeforceanalyzer.servlet;

import shubhamjha33.codeforceanalyzer.util.HttpClientUtil;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.http.client.utils.URIBuilder;

/**
 *
 * @author shubham
 */
public class Problemset extends HttpServlet{
    
    @Override
    public void doGet(HttpServletRequest request,HttpServletResponse response){
        try {
            String tag=request.getParameter("tag");
            String[] tagList=tag.split(",");
            StringBuffer sb=new StringBuffer("");
            for(int i=0;i<tagList.length;i++)
            {
                sb.append(tagList[i]);
                if(i!=tagList.length-1)
                    sb.append(";");
            }
            System.out.println(sb);
            tag=sb.toString();
            URI uri;
            if(tag.equals(""))
                uri=new URIBuilder().setScheme("http").setHost("codeforces.com").setPath("/api/problemset.problems").build();
            else
                uri=new URIBuilder().setScheme("http").setHost("codeforces.com").setPath("/api/problemset.problems").setParameter("tags",tag).build();
            String problemsetJSON=new HttpClientUtil().getDataFromURL(uri);
            response.setContentType("application/json");
            response.getWriter().println(problemsetJSON);
        } catch (URISyntaxException ex) {
            Logger.getLogger(Problemset.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Problemset.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
}
