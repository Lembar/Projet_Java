package dao.factory;

import dao.CotisationDAO;
import dao.EmployeDAO;
import dao.RegleDAO;
import dao.VariableDAO;

public abstract class DAOFactory {

        public abstract CotisationDAO getCotisationDAO();
        public abstract EmployeDAO getEmployeDAO();
        public abstract RegleDAO getRegleDAO();
        public abstract VariableDAO getVariableDAO();
        
        public static DAOFactory getFactory(Persistance type){
                DAOFactory daof = null;
                switch(type){
                case MySQL: 
                        daof = new MySQLDAOFactory();
                        break;
                case ArrayList:
                        daof = new ArrayListDAOFactory();
                        break;
                }
                
                return daof;
        }     
}
