package AbastractFactory;

import AbstractFactory.Razas.FactoryRaza;





public class FactoryProducer {
    public static AbstractFactory getFactory(String type){
        switch (type){
            case "Raza":
                return new FactoryRaza();
            default:
                return null;
                
        }
    }
}
