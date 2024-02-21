# TP Inversion de Contrôle et Injection des dépendances
 _Ce travail a été réalisé par FARSANE Soufien GLSID2 encadré par  M. Mohamed Youssfi._
 
## Introduction à l'Inversion de Contrôle (IoC) et à l'Injection de Dépendances (DI)
* Ce guide pratique nous ouvre les portes à deux concepts fondamentaux du développement logiciel : l'Inversion de Contrôle (IoC) et l'Injection de Dépendances (DI).L'IoC et la DI nous permettent de créer des logiciels flexibles, évolutifs et d'une grande clarté architecturale.

* En effet, l'Inversion de Contrôle (IoC) représente un changement de perspective par rapport à la manière traditionnelle de concevoir des applications. Plutôt que d'avoir le contrôle direct sur le flux d'exécution, l'IoC délègue ce contrôle à un conteneur ou un framework. Cela permet une meilleure modularité et facilite la gestion des composants logiciels.

* L'Injection de Dépendances (DI) est un sous-ensemble de l'IoC qui se concentre sur la manière dont les composants d'une application obtiennent leurs dépendances. Plutôt que de créer ces dépendances localement, elles sont injectées depuis l'extérieur. Cela favorise la séparation des préoccupations, rendant les composants plus autonomes et réutilisables.

## Objectif du TP : Exploration des Concepts d'IoC et de DI avec Spring

Dans le cadre de ce TP, l'objectif est de se familiariser avec les concepts d'Inversion de Contrôle (IoC) et d'Injection de Dépendances (DI) en mettant en œuvre différentes approches de couplage faible via Spring. on aura l'occasion d'explorer quatre méthodes indépendantes d'injection de dépendances :

1. **Injection de Dépendance par Instanciation Statique**
2. **Injection de Dépendance par Instanciation Dynamique à Partir d'un Fichier TXT**
3. **Injection de Dépendance par Instanciation Dynamique à Partir du Clavier**
4. **Injection de Dépendance par Spring Framework à Partir des Annotations**
5. **Injection de Dépendance par Spring Framework à Partir d'un Fichier XML**



## Code Source et Captures d'Écran
1. **Injection de Dépendance par Instanciation Statique**
```java
package ma.enset.presentation;
import ma.enset.dao.DaoImpl;
import ma.enset.metier.IMetier;
import ma.enset.metier.MetierImpl;
public class pres1 {
    public static void main(String[] args) {
        DaoImpl dao=new DaoImpl();
        MetierImpl metier=new MetierImpl(dao); 
        System.out.println(metier.calcul());
    }
}
```


2. **Injection de Dépendance par Instanciation Dynamique à Partir d'un Fichier TXT**
```java
package ma.enset.presentation;
import ma.enset.dao.*;
import ma.enset.metier.IMetier;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;
import static java.lang.Class.forName;
public class pres2 {
    public static void main(String[] args) throws Exception {
            Scanner scanner = new Scanner(new File("config.txt"));
            String daoClassName = scanner.nextLine();
            Class cDao = Class.forName(daoClassName);
            IDao dao = (IDao) cDao.getConstructor().newInstance();
            
           String metierClassName = scanner.nextLine();
           Class cMetier = Class.forName(metierClassName);
           IMetier metier = (IMetier) cMetier.getConstructor(IDao.class).newInstance(dao);
           
            System.out.println(dao.getData());
    }
}
```
- `Config.txt`
```txt
ma.enset.dao.DaoImplV2
ma.enset.metier.MetierImpl
```


3. **Injection de Dépendance par Instanciation Dynamique à Partir du Clavier**
```java
package ma.enset.presentation;
import ma.enset.dao.IDao;
import ma.enset.metier.IMetier;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

public class pres3 {
    
    
    public static void main(String[] args) throws Exception {
            Scanner scanner = new Scanner(System.in);

            System.out.println("donner le nom de la classe Dao: ");
            String daoClassName = scanner.nextLine();
            Class cDao = Class.forName(daoClassName);
            IDao dao = (IDao) cDao.getConstructor().newInstance();
            

           System.out.println("donner le nom de la classe Metier: ");
           String metierClassName = scanner.nextLine();
           Class cMetier = Class.forName(metierClassName);
           
           IMetier metier = (IMetier) cMetier.getConstructor(IDao.class).newInstance(dao);

            System.out.println(dao.getData());
    }
}
```


4. **Injection de Dépendance par Spring Framework à Partir des Annotations**
```java
package ma.enset.presentation;
import ma.enset.metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PresAvecSpringVersAnnotation {
    
    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext("ma.enset.dao","ma.enset.metier");
        IMetier metier = ctx.getBean(IMetier.class);
        System.out.println(metier.calcul());
    }
}
```
- ###### `Exécution` :


5. **Injection de Dépendance par Spring Framework à Partir d'un Fichier XML**
```java
package ma.enset.presentation;
import ma.enset.metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PresAvecSpringVersXml {
    
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
        IMetier metier = ctx.getBean(IMetier.class);
        System.out.println(metier.calcul());
    }
}
```
- `config.xml`
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="dao" class="ma.enset.dao.DaoImpl"></bean>
    <bean id="metier" class="ma.enset.metier.MetierImpl">
        <constructor-arg ref="dao"></constructor-arg>
    </bean>
</beans>
```



## Conclusion
Ce TP a posé les bases d'une maîtrise solide de l'Inversion de Contrôle (IoC) et de l'Injection de Dépendances (DI) dans le contexte de Spring. En explorant ces concepts fondamentaux, nous avons acquis les compétences nécessaires pour les mettre en pratique dans vos propres projets.







