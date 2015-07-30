package com.smartlearner.agenda.service;

import com.smartlearner.agenda.api.Agenda;
import com.smartlearner.agenda.api.Conference;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class Activator implements BundleActivator {

    @Override
    public void start(BundleContext context) {
        try {

            System.out.println(context.toString());
            context.registerService(Agenda.class.getName(), new SimpleAgendaService(), null);
            System.out.println("Service registered: "+Agenda.class.getName());
            /*
            ServiceReference txRef =context.getServiceReference(Agenda.class.getName());
            Agenda agenda=(Agenda) context.getService(txRef);
            System.out.println(agenda.toString());
            agenda.addConference(new Conference("test", "test"));
            System.out.println(agenda.listConferences().get(0).toString());
            */
        } catch(Exception e) {
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        // TODO add deactivation code here
    }

}
