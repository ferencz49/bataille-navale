# Manuel d'installation et d'exécution

Ce document explique comment installer, compiler et exécuter le projet **Bataille Navale** en Java.

---

## Prérequis

- Java Development Kit (JDK) 17 ou supérieur installé
- Un IDE Java comme IntelliJ IDEA, Eclipse, ou Visual Studio Code avec l'extension Java
- Git installé pour cloner le dépôt

---

## Étape 1 : Cloner le dépôt

1. Ouvrez un terminal.
2. Exécutez la commande suivante :  
   `git clone https://git.unistra.fr/roudet-barabas/a31-bataille-navale`
3. Accédez au dossier du projet :  
   `cd <a31-bataille-navale>`

---

## Étape 2 : Compiler le projet

Si vous utilisez la ligne de commande :

1. Créez un dossier `bin` pour les classes compilées (si nécessaire)
2. Compilez le projet avec :  
   `javac -d bin -sourcepath src src/bataille_navale/Main.java`

- `src` : dossier contenant le code source
- `bin` : dossier de sortie pour les fichiers compilés
- `Main.java` : point d'entrée du programme

> Astuce : si vous utilisez un IDE, importez simplement le projet et utilisez l'option **Build / Compile**.

---

## Étape 3 : Exécuter le projet

En ligne de commande :

1. Lancer le jeu:  

> Dans un terminal éxecuter le fichier main.
> Dans un IDE, vous pouvez directement exécuter la classe `Main`.

---

## Étape 4 : Jouer au jeu

---

## Remarques

- Assurez-vous que les dossiers `src` et `bin` existent et ont les permissions nécessaires
- Si vous utilisez des bibliothèques externes, ajoutez-les au classpath lors de la compilation et de l’exécution