/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointment;

/**
 *
 * @author ACER
 */
public class Appointment 
{
    private String appNo;
    private String date;
    private String time;
    private String typeVacc;
    private String username;
    private String name;

    public String getAppNo() {
        return appNo;
    }

    public void setAppNo(String appNo) {
        this.appNo = appNo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTypeVacc() {
        return typeVacc;
    }

    public void setTypeVacc(String typeVacc) {
        this.typeVacc = typeVacc;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }
}

   