/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartlearner.agenda.api;

import java.util.List;

/**
 *
 * @author krishnac
 */
public interface Agenda {

    List<Conference> listConferences();
    void addConference(Conference conference);
    boolean addConferenceDB(Conference conference);

}