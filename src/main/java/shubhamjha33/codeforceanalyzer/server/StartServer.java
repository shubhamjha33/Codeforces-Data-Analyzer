package shubhamjha33.codeforceanalyzer.server;

import shubhamjha33.codeforceanalyzer.servlet.Problemset;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
/**
 *
 * @author shubham
 */
public class StartServer {
    
    public static void initializeServer(){
        try{
            Server server=new Server(8082);
            ServletContextHandler context=new ServletContextHandler();
            context.setResourceBase("./src/main/resources/");
            ServletHolder defServletHolder=new ServletHolder(new DefaultServlet());
            context.addServlet(defServletHolder,"/*");
            ServletHolder problemsetServletHolder=new ServletHolder(new Problemset());
            context.addServlet(problemsetServletHolder,"/problemset");
            server.setHandler(context);
            server.start();
            server.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(StartServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(StartServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args){
            initializeServer();
    }
    
}
