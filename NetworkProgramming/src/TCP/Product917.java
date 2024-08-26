/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP;

import java.io.Serializable;

/**
 *
 * @author CuongAcQuy
 */
public class Product917 implements Serializable{
    private String id, code, name;
    private int quantity;
    private static final long serialVersionUID = 917;

    public Product917() {
    }

    
    
    public Product917(String id, String code, String name, int quantity) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    @Override
    public String toString() {
        return "Product917{" + "id=" + id + ", code=" + code + ", name=" + name + ", quantity=" + quantity + '}';
    }
}
