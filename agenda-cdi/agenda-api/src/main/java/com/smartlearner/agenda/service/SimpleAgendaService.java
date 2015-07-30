/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartlearner.agenda.service;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

import com.smartlearner.agenda.api.Agenda;
import com.smartlearner.agenda.api.AgendaInterface;
import com.smartlearner.agenda.api.AgendaType;
import com.smartlearner.agenda.api.Conference;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author krishnac
 */
@AgendaInterface(AgendaType.LOCAL)
public class SimpleAgendaService implements Agenda {
    private Cluster cluster;
    private Session sessionCassandra;

    private List<Conference> conferences=new CopyOnWriteArrayList<>();

    @Override
    public List<Conference> listConferences() {
        System.out.println("Conference list method invoked");
        return conferences;
    }

    @Override
    public void addConference(Conference conference) {
        conferences.add(conference);
        System.out.println("conference to be added: "+conference.toString());
    }

    /*
    public void start() {
        System.out.println("The bundle has started!!!");
        conferences.add(new Conference("Java One", "SF"));
        conferences.add(new Conference("Devoxx", "Amsterdam"));
        System.out.println("Conferences are added to the list");
    }
    */

    @Override
    public boolean addConferenceDB(Conference conference) {

        try {
            cluster = Cluster.builder().addContactPoint("localhost").build();
            sessionCassandra = cluster.connect();

            String insertConference="insert into conference.table1_copy1(id, location, name) values ("+UUID.randomUUID()+", '"+
                    conference.getLocation()+"', '"+conference.getName()+"');";
            System.out.println(insertConference);
            sessionCassandra.execute(insertConference);
            return true;

        } catch(Exception e) {
            e.printStackTrace(System.out);
            return false;
        }
    }
}
