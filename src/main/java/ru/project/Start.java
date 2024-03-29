package ru.project;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Comparator;

public class Start {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("ru.project");
        ctx.close(); // полное уничтожение всех бинов в контейнере, перед полным уничтожением контейнера
    }
}

@Configuration
class Config {

    //@Bean
    @Bean(initMethod = "toString")
    Logic logic2() {
        return new Logic();
    }

    @Bean
    //Comparator<Integer> comparator() { return (x, y) -> x-y; }
    //Comparator<Integer> comparator(Logic logic3) {
    //Comparator<Integer> comparator(@Autowired(required = false) Start logic3) {
        //System.out.println(logic3);
    Comparator<Integer> comparator(Logic logic) {
        System.out.println(logic);
        return (x, y) -> x - y;
    }
}

@Component
class Logic {
    void init() {
        System.out.println("finishing initialization " + this);
    }
}

//lookup
@Component
class ProjectComponent {


    //@Autowired
    //ApplicationContext ctx;

    @Autowired
    private Logic logic;

    //List<Logic> lst;
    Comparator<Integer> comparator;

    @Autowired
    private ProjectComponent() {
        System.out.println("Creating empty");
    }

    public ProjectComponent(Logic logic) {
        System.out.println("Creating with logic only");
        //this.logic = logic;
    }

    //принудительное внедрение зависимости, по-умолчанию создаётся через конструктор
    //@Autowired
    public ProjectComponent(Logic logic, Comparator<Integer> comparator) {
        System.out.println("Creating with both parameters");
        //this.logic = logic;
        this.comparator = comparator;
    }

    public Comparator<Integer> getComparator() {
        return comparator;
    }

/*
    @PostConstruct
    void init() {
        if (logic == null) {
            ctx.getBean()
        }
    }
*/

/*
    @Autowired
    public void setLogic(Logic logic) {
        System.out.println(this.logic);
        this.logic = logic;
    }
*/
    @Autowired
    public void setComparator(Comparator<Integer> comparator) {
        this.comparator = comparator;
    }
/*
    @PostConstruct
    public void init() {
        logic.register(comparator);
    }
 */
    @PreDestroy
    public void dest() {
        System.out.println("destroy");
    }
}