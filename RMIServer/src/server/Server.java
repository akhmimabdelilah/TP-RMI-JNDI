/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import dao.IDao;
import entities.Machine;
import entities.Salle;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.MachineService;
import service.SalleService;

/**
 *
 * @author akhmim
 */
public class Server {

    public static void main(String[] args) {
        try {
            IDao<Machine> dao = new MachineService();

            //    Demarer le registre avec le port par défaut 
            LocateRegistry.createRegistry(1099);

            //    Mettre dans l'annuaire hibernate naming 
            Naming.bind("rmi://localhost:1099/dao", dao);

            IDao<Salle> idao = new SalleService();
            Naming.bind("rmi://localhost:1099/idao", idao);

            System.out.println("Waiting for Customers");

        } catch (RemoteException | AlreadyBoundException | MalformedURLException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
