/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serializeable;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author DarkShadowDemon200x
 */
public class PersistentTime implements Serializable {

    static final long serialVersionUID = -3126998878902358585L;
    private Date time;
    private String aNewField;
    private String aNewNewField;

    public PersistentTime() {
        time = Calendar.getInstance().getTime();
    }

    public Date getTime() {
        return time;
    }

}
