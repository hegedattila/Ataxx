# Ataxx

## Áttekintés

Az alkalmazás egy "Ataxx" nevű táblajáték. 
Ez egy két személyes területfoglalós játék, 
amelyet egy 7-szer 7-es táblán játszanak, 
kezdetben a négy sarokban két-két területtel. 
A bal felső és jobb alsó sarokban piros, 
bal alsó és jobb felső sarokban kék. A piros kezd.
Minden körben egy vagy két hellyel mozoghatnak vízszintes, 
függőleges vagy átlós irányban egy szabad területre. 
Ha egy hellyel mozdul el a játékos, akkor megmarad a régi terület
és létrejön egy új is a kiválasztott helyen.
Ha két hellyel, akkor az eredeti terület "átkerül" a kiválasztott helyre,
tehát ott létrejön egy új, a régi pedig törlődik. 
Ha a kiválasztott terület mellett voltak az ellenfélnek területei,
akkor azok az aktuális játékos területei lesznek.
A játékosok bármelyik körben passzolhatnak.
Két esetben lehet vége a játéknak: ha elfogynak a szabad helyek,
vagy ha az egyik játékosnak nem marad területe.
Az nyer akinek a játék végén több területe van.
Döntetlen ebben a fajta játékban nincs, mivel páratlan a mezők száma.

## Telepítés

Az alkalmazás egy <b>Apace Maven 3</b> alkalmazás, így a telepítéshez szükséges
az apache <b>maven plugin 3.0.5</b>-ös verziója, valamint a <b>JDK 1.8</b>-as verziója.

Ezek után a projekt főkönyvtárában használjuk az <i>mvn clean install</i> parancsot.

## Licensz

A projekt az Apache License v2.0 alatt készült.
