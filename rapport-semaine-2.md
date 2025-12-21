## Choix de conception

- Gestion des objets de la grille via une classe Object et ObjectType :
Chaque case de la grille peut contenir un objet (bateau, île, piège, eau, etc.) identifié par son type (enum ObjectType). Cela nous a permis de traiter les interactions de manière uniforme et de faciliter l’extension future avec de nouveaux objets ou armes.

- Classe Coordinates pour les bateaux :
Après plusieurs essais, nous avons décidé que chaque bateau possède une liste de coordonnées correspondant à ses cases sur la grille. Cette conception simplifie le calcul des cases touchées, la suppression d’un bateau lorsqu’il est coulé, et l’implémentation de différentes orientations.

- Gestion des actions via ActionType et inventaire :
Les différentes actions (attaque de base, bombe, sonar) sont encapsulées dans un enum ActionType, et chaque joueur possède un inventaire d’objets utilisables. Cela permet d’appliquer facilement les règles de disponibilité et d’éviter la duplication de logique dans le contrôleur.

- Observer pour la mise à jour des vues :
Les classes vues implémentent un pattern Observer pour suivre les changements de la grille. Chaque modification dans la grille déclenche la mise à jour automatique de la/des cellules concernées, garantissant que les vues restent synchronisées avec le modèle.

- Centralisation de la logique de jeu dans la classe Game :
La classe Game gère l’exécution des actions d’un joueur, la vérification des conditions de fin et la coordination des tours. Cela évite de disperser la logique dans le contrôleur (ce qu'on avait fait au début).


## Difficultées rencontrées / :

- Au moment de la conception de notre grille, nous avons décidé que les cases vides (donc les cases dont la valeur vaut null) seraient les cases d'eau.
Cela nous a posé quelques problèmes pour la vérification des attaques, car il a falu d'abord vérifié si la case était vide et si elle n'était pas vide vérifier
quelle objet elle contenait pour chaque attaque et chaque type de joueur(humain ou bot).

- Au moment de la conception de notre classe bateau, nous avions pour idée d'utiliser une classe de coordonnées pour connaitre les coordonnées de chaque bateau.
Quand nous avons développé la fonction permettant de placer un bateau, nous nous sommes rendus compte qu'il suffisait de connaître son orientation et les coordonnées de la première case pour le placer. Nous avons donc supprimé la clase coordonnées. Plus tard lorsque que nous avons écrit la fonction pour retirer un bateau lorsqu'il est coulé, nous nous sommes rendus compte qu'il fallait:
	1. connaître son orientation (pas de problèmes elle est stockée dans un attribut de la classe)
	2. écrire un algo pour chaque cas en fonction de la case cochée (horrible)
	
Nous avons donc décidé de réintroduire la classe coordonnées, donner à la classe "Boat" un liste de coordonnées remplie au moment du placement et le problème était réglé.