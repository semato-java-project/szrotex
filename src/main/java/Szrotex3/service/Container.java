package Szrotex3.service;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Container {

    private static Container instance = null;

    ApplicationContext context = null;
    BeanFactory factory = null;

    private Container() {
        this.context = new ClassPathXmlApplicationContext("META-INF/beans.xml");
        this.factory = this.context;
    }

    public static Container getInstance() {

        if (Container.instance == null) {
            Container.instance = new Container();
        }

        return Container.instance;
    }

    public static ServiceInterface getBean(String name) {
        return (ServiceInterface) Container.getInstance().factory.getBean(name);
    }

}
