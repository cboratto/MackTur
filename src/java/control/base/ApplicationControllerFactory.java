/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.base;

/**
 *
 * @author caioboratto
 */
public class ApplicationControllerFactory {

    public static final ApplicationController getControllerByClass(Class actionClass) {
        try {
            ApplicationController controller;
            controller = (ApplicationController) actionClass.newInstance();

            return (ApplicationController) actionClass.newInstance();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();

        } catch (IllegalAccessException e) {
            e.printStackTrace();

        } catch (ClassCastException e) {
            e.printStackTrace();

        }
        return null;
    }

    public static final ApplicationController getControllerByFullClassName(String className) {
        try {
            String name = "macktur.control." + className ;
            Class actionClass = Class.forName(name);
            return getControllerByClass(actionClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
