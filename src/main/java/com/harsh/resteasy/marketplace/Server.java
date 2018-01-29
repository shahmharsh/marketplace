package com.harsh.resteasy.marketplace;

import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.servlet.Servlets;
import io.undertow.servlet.api.DeploymentInfo;
import io.undertow.servlet.api.DeploymentManager;
import org.jboss.resteasy.plugins.server.servlet.HttpServlet30Dispatcher;
import org.jboss.resteasy.spi.ResteasyDeployment;

import javax.servlet.ServletException;

public class Server {
    public static void main(String[] args) throws Exception {
        Undertow server =  Undertow.builder()
                .addHttpListener(8080, "localhost")
                .setHandler(getRestEasyServlet())
                .build();
        server.start();
    }

    private static HttpHandler getRestEasyServlet() throws ServletException {
        final ResteasyDeployment deployment = new ResteasyDeployment();
        deployment.setApplication(new RestApplication());

        final DeploymentInfo servletBuilder = Servlets.deployment()
                .setClassLoader(Server.class.getClassLoader())
                .setContextPath("/")
                .setDeploymentName("RestEasy")
                .addServlets(
                        Servlets.servlet("RestEasyServlet", HttpServlet30Dispatcher.class)
                                .setAsyncSupported(true)
                                .setLoadOnStartup(1)
                                .addMapping("/")
                )
                .addServletContextAttribute(ResteasyDeployment.class.getName(), deployment);

        final DeploymentManager manager = Servlets.defaultContainer().addDeployment(servletBuilder);
        manager.deploy();
        return manager.start();
    }
}
