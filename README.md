# Guilded Rose Refactoring Kata

Bienvenue dans le dépôt du Kata "Guilded Rose".

La boutique Guilded Rose vend divers articles. Chaque jour, la qualité et le nombre de jours restants avant la péremption (`sellIn`) de ces articles sont mis à jour. Cependant, certains articles ont des règles spéciales :

* Tous les articles voient leur `sellIn` diminuer de 1 chaque jour.
* La `qualité` diminue de 1 chaque jour.
* Une fois que la date de péremption est passée (`sellIn` < 0), la `qualité` diminue deux fois plus vite.
* La `qualité` d'un article ne peut jamais être négative.
* La `qualité` d'un article ne peut jamais dépasser 50.

## Exceptions à ces règles :

* "Aged Brie" : Augmente sa `qualité` avec l'âge. Plus il vieillit, plus sa `qualité` augmente.
* "Sulfuras, Hand of Ragnaros" : Est un article légendaire, il n'a pas de date de péremption (`sellIn`) et sa `qualité` ne diminue jamais (elle reste toujours à 80).
* "Backstage passes to a TAFKAL80ETC concert" : Augmente sa `qualité` à mesure que sa date de péremption approche.
    * La `qualité` augmente de 2 quand il reste 10 jours ou moins.
    * La `qualité` augmente de 3 quand il reste 5 jours ou moins.
    * La `qualité` tombe à 0 après le concert (quand `sellIn` est négatif).

Bonne chance et amusez-vous bien !