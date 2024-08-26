/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tcpsocket.testthuchanh;

import java.io.Serializable;

/**
 *
 * @author DarkShadowDemon200x
 */
public class TCPStudent implements Serializable{
    private int id;
    private String code;
    private float gpa;
    private String gpaLetter;
    private static final long serialVersionUID = 20151107;

    public TCPStudent(int id, String code, float gpa, String gpaLetter) {
        this.id = id;
        this.code = code;
        this.gpa = gpa;
        this.gpaLetter = gpaLetter;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public void setGpaLetter(String gpaLetter) {
        this.gpaLetter = gpaLetter;
    }

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public float getGpa() {
        return gpa;
    }

    public String getGpaLetter() {
        return gpaLetter;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "TCPStudent{" + "id=" + id + ", code=" + code + ", gpa=" + gpa + ", gpaLetter=" + gpaLetter + '}';
    }
    
}
