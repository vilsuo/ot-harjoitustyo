# Testausdokumentti
Ohjelmaa on testattu automatisoiduin yksikkötestein JUnitilla, sekä manuaalisesti tapahtunein järjestelmätason testein.

## Sovelluslogiikka


## DAO-luokat
DAO-luokat on testattu luomalla testitietokannat, jotka ovat identtisiä käytetävien tietokantojen kanssa.

## Testikattavuus
Käyttöliittymäkerrosta lukuunottamatta sovelluksen testauksen rivikattavuus on 80% ja haarautumiskattavuus 95%.

![](https://github.com/vilsuo/ot-harjoitustyo/blob/master/dokumentointi/kuvat/testikattavuus.png)

Testaamatta jäi mm. javalla piirretyt muodot.

## Järjestelmätestaus
Sovelluksen järjestelmätestaus on suoritettu manuaalisesti.

### Toiminnallisuudet
Kaikki [määrittelydokumentin](https://github.com/vilsuo/ot-harjoitustyo/blob/master/dokumentointi/vaatimusmaarittely.md) ja [käyttöohjeen](https://github.com/vilsuo/ot-harjoitustyo/blob/master/dokumentointi/kayttoohje.md) listaamat toiminallisuudet on käyty läpi. Uutta käyttäjää luodessa on varauduttu virheellisiin arvoihin, kuten tyhjiin tai liian pitkiin merkkijonoihin, sekä jo olemassa oleviin käyttäjänimiin.
