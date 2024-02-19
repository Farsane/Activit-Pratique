# Activit-Pratique
Inversion de contrôle et injection des dépendances

# Création des packages 
1- Création du package Dao contenant : 
    L'interface IDao qui contient la fonction getData.
    La classe DaoImpl qui represente l'implementation de l'interface IDao Pour se connecter à la base de donnée 
    La class DaoImplV2 qui represente l'implementation de l'interface IDao pour se connecter via le Web Service

2- Création du package Metier contenant : 
    L'interface IMetier qui contient la fonction de calcul
    La classe MetierImpl qui implemente l'interface IMetier et utilise un couplage faible avec l'interface IDao

3- Création du package Presentation :