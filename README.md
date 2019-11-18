# Päässälaskuharjoittelusovellus
## Dokumentaatio
[vaatimusmäärittely](https://github.com/vilsuo/ot-harjoitustyo/blob/master/dokumentointi/vaatimusmaarittely.md)

[työaikakirjanpito](https://github.com/vilsuo/ot-harjoitustyo/blob/master/tyoaikakirjanpito.md)
## Tehtävät
### Viikko 1
[gitlog.txt](https://github.com/vilsuo/ot-harjoitustyo/blob/master/laskarit/viikko1/gitlog.txt)

[komentorivi.txt](https://github.com/vilsuo/ot-harjoitustyo/blob/master/laskarit/viikko1/komentorivi.txt)
### Viikko 3
[tehtävät 1-4](https://github.com/vilsuo/ot-harjoitustyo/tree/master/laskarit/viikko3)

## Komentorivitoiminnot
### Testaus
Testit suoritetaan komennolla
¸¸¸
mvn test
¸¸¸

Testikattavuusraportti luodaan komennolla
¸¸¸
mvn jacoco:report
¸¸¸
Kattavuusraporttia voi tarkastella avaamalla selaimella tiedosto *target/site/jacoco/index.html*

## Suoritettavan jarin generointi
Komento
¸¸¸
mvn package
¸¸¸
generoi hakemistoon *target* suoritettavan jar-tiedoston *Paassalaskuharjoittelusovellus-1.0-SNAPSHOT.jar*


