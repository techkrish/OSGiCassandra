/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartlearner.agenda.web;

import com.smartlearner.agenda.api.Agenda;
import com.smartlearner.agenda.api.AgendaInterface;
import com.smartlearner.agenda.api.Conference;
import com.smartlearner.hello.world.HelloType;
import com.smartlearner.hello.world.HelloWorld;
import com.smartlearner.hello.world.HelloWorldService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.glassfish.osgicdi.OSGiService;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleReference;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;

/**
 *
 * @author krishnac
 */
@WebServlet(name = "AgendaServlet", urlPatterns = {"/AgendaServlet"})
public class AgendaServlet extends HttpServlet {

    @Inject
    @OSGiService(dynamic = true)
    HelloWorld helloWorld;

    @Inject
    @OSGiService(dynamic = true)
    Agenda agenda;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        out.println(helloWorld.sayHello());
        out.println("<br/><br/><br/>");
        out.println(helloWorld.sayGoodbye());

        agenda.addConference(new Conference("Java One", "Chennai"));
        agenda.addConference(new Conference("Java Two", "Bangalore"));

        out = response.getWriter();
        List<Conference> listConfs = agenda.listConferences();
        for (Conference listConf : listConfs) {
            out.println(listConf.getName());
            out.println(listConf.getLocation());
            out.println("<br/>");
        }

        for (Conference listConf : listConfs) {

            System.out.println(agenda.addConferenceDB(listConf));
        }
    }
}
