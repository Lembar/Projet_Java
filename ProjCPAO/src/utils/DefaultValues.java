package utils;

import dao.factory.DAOFactory;
import dao.factory.Persistance;

public class DefaultValues {

        public static DAOFactory getDefaultFactory() {
                return DAOFactory.getFactory(Persistance.MySQL);
        }
}