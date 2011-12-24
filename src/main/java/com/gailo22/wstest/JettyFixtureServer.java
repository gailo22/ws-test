/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gailo22.wstest;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.bio.SocketConnector;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 *
 * @author User
 */
public class JettyFixtureServer {

    public static void main(String[] args) throws Exception {
        Server jettyServer = null;
        try {
            jettyServer = new Server();

            SocketConnector conn = new SocketConnector();
            conn.setPort(9999);
            jettyServer.setConnectors(new Connector[]{conn});

            WebAppContext wah = new WebAppContext();
            wah.setContextPath("/ws-test");
            wah.setWar("src/main/webapp");
            jettyServer.setHandler(wah);

            jettyServer.start();
        } catch (Exception e) {
            System.out.println("Could not start the Jetty server: " + e);
            if (jettyServer != null) {
                try {
                    jettyServer.stop();
                } catch (Exception e1) {
                    System.out.println("Unable to stop the jetty server: " + e1);
                }
            }
        }
    }
}
