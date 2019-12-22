# Testausdokumentti
Ohjelmaa on testattu automatisoiduin yksikkö- ja integraatiotestein JUnitilla, sekä manuaalisesti tapahtunein järjestelmätason testein.

## Yksikkö- ja integraatiotestaus

### Sovelluslogiikka
Automatisoitujen testien ytimen moudostavat sovelluslogiikkaa, eli pakkauksen [paassalaskuharjoittelusovellus.logic](https://github.com/vilsuo/ot-harjoitustyo/tree/master/Paassalaskuharjoittelusovellus/src/main/java/paassalaskuharjoittelusovellus/logic) luokkia testaava integraatiotesti [GameTest](https://github.com/vilsuo/ot-harjoitustyo/blob/master/Paassalaskuharjoittelusovellus/src/test/java/paassalaskuharjoittelusovellus/logicTest/GameTest.java).

### DAO-luokat
DAO-luokat on testattu luomalla testitietokannat, jotka ovat identtisiä käytetävien tietokantojen kanssa.

### Testikattavuus
Käyttöliittymäkerrosta lukuunottamatta sovelluksen testauksen rivikattavuus on 80% ja haarautumiskattavuus 95%.

![](https://github.com/vilsuo/ot-harjoitustyo/blob/master/dokumentointi/kuvat/testikattavuus.png)

Testaamatta jäi mm. javalla piirretyt muodot.

## Järjestelmätestaus
Sovelluksen järjestelmätestaus on suoritettu manuaalisesti.

### Toiminnallisuudet
Kaikki [määrittelydokumentin](https://github.com/vilsuo/ot-harjoitustyo/blob/master/dokumentointi/vaatimusmaarittely.md) ja [käyttöohjeen](https://github.com/vilsuo/ot-harjoitustyo/blob/master/dokumentointi/kayttoohje.md) listaamat toiminallisuudet on käyty läpi. Uutta käyttäjää luodessa on varauduttu virheellisiin arvoihin, kuten tyhjiin tai liian pitkiin merkkijonoihin, sekä jo olemassa oleviin käyttäjänimiin.
