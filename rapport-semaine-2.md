## Choix de conception



## Difficultées rencontrées:

- Au moment de la conception de notre grille, nous avons décidé que les cases vides (donc les cases dont la valeur vaut null) seraient les cases d'eau.
Cela nous a posé quelques problèmes pour la vérification des attaques, car il a falu d'abord vérifié si la case était vide et si elle n'était pas vide vérifier
quelle objet elle contenait pour chaque attaque et chaque type de joueur(humain ou bot).

- Au moment de la conception de notre classe bateau, nous avions pour idée d'utiliser une classe de coordonnées pour connaitre les coordonnées de chaque bateau.
Quand nous avons développé la fonction permettant de placer un bateau, nous nous sommes rendus compte qu'il suffisait de connaître son orientation et les coordonnées de la première case pour le placer. Nous avons donc supprimé la clase coordonnées. Plus tard lorsque que nous avons écrit la fonction pour retirer un bateau lorsqu'il est coulé, nous nous sommes rendus compte qu'il fallait:
	1. connaître son orientation (pas de problèmes elle est stockée dans un attribut de la classe)
	2. écrire un algo pour chaque cas en fonction de la case cochée (horrible)
	
Nous avons donc décidé de réintroduire la classe coordonnées, donner à la classe "Boat" un liste de coordonnées remplie au moment du placement et le problème était réglé.