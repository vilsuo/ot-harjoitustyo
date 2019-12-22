# Arkkitehtuurikuvaus
## Rakenne
![](https://github.com/vilsuo/ot-harjoitustyo/blob/master/dokumentointi/kuvat/kaavio.jpg)

## Käyttöliittymä

## Sovelluslogiikka

## Tietojen pysyväistalletus
Pakkauksen *paassalaskuharjoittelusovellus.dao* luokat *HiscoreDao* ja *UserDao* huolehtivat tietojen tallettamisesta tietokantoihin.

Käyttäjien tiedot talletataan tietokantaan *userDB.mv.db* ja pisteet tietokantaan *hiscoreDB.mv.db*.

## Päätoiminnallisuudet

## Ohjelman rakenteeseen jääneet heikkoudet
### Käyttöliittymä
- Ohjelman käyttöliittymän rakentavissa luokissa on copy-pastea
### DAO-luokat
- käyttäjän salasana tallennetaan tietokantaan selkokielisenä
