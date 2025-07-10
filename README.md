# LAB3_LOG430 : readme

## Description : 

## Exécution de l'application
Dans la VM, le dossier racine se trouve dans le fichier projects/LAB3_LOG430. Assurez-vous de faire un git pull pour avoir la dernière version du repo : mdyoucef99/LAB3_LOG430

## Tests unitaires

Les bibliothèques JUnit se trouvent dans le dossier `lib` (`junit-4.13.2.jar` et `hamcrest-core-1.3.jar`). Depuis le dossier racine :

```bash
# Compiler le test
javac -d LABO3/lab/bin -cp "lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar" LABO3/lab/tests/lab/tests/AppTest.java

# Exécuter le test
java -cp "LABO3/lab/bin:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore lab.tests.AppTest
```

## Conteneurisation

Construisez et testez l'image Docker localement :

```bash
docker build -t lab3_api .
docker run --rm -it --network host lab3_api
```

## Orchestration avec Docker Compose

Il existe un `docker-compose.yaml` à la racine, lancez :

```bash
docker-compose build
docker-compose up -d 
docker-compose run --rm api
docker-compose logs -f api
```

**Résultat attendu :** 

Vous devriez maintenant être capable de lancer l'application et avoir accès aux plusieurs endpoints de l'API.

### Lancement de l'application

Pour lancer l'application localement dans le dossier LAB3_LOG430, exécutez : `java -cp "LAB3_LOG430.jar:lib/*" Rest.ApiApplication`. Ceci est le cas si lors du déploiement vous n'arrivez pas à avoir accès au localhost:8080.

Un mot de passe sera généré à chaque fois que vous lancez l'API, assurez-vous de bien lire la console.




