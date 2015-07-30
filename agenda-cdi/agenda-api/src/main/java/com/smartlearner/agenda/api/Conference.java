/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartlearner.agenda.api;

/**
 *
 * @author krishnac
 */
public class Conference {

    public Conference() {

    }

    public Conference(String name, String location) {
        this.name = name;
        this.location = location;
    }

    private String name;
    private String location;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Conference[" + "name=" + name + ", location=" + location + ']';
    }

}
