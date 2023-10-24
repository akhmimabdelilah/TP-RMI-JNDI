/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiclient;

import dao.IDao;
import entities.Machine;
import java.rmi.Naming;

/**
 *
 * @author akhmim
 */
public class RMIClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            IDao<Machine> dao = (IDao<Machine>) Naming.lookup("rmi:localhost:1099/dao");
//            dao.create(new Machine("ER44", "HP", 1000));
//            dao.create(new Machine("ER46", "LENOVO", 3000));
//            dao.create(new Machine("ER48", "ASUS", 5000));

            for (Machine m : dao.findAll()) {
                System.out.println(m);
            }
        } catch (Exception e) {
        }
    }

}
