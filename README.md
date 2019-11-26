# Päässälaskuharjoittelusovellus
## Dokumentaatio
[Vaatimusmäärittely](https://github.com/vilsuo/ot-harjoitustyo/blob/master/dokumentointi/vaatimusmaarittely.md)

[Työaikakirjanpito](https://github.com/vilsuo/ot-harjoitustyo/blob/master/tyoaikakirjanpito.md)

## Komentorivitoiminnot
### Testaus
Testit suoritetaan komennolla
```
mvn test
```

Testikattavuusraportti luodaan komennolla
```
mvn jacoco:report
```
Kattavuusraporttia voi tarkastella avaamalla selaimella tiedosto *target/site/jacoco/index.html*

### Suoritettavan jarin generointi
Komento
```
mvn package
```
generoi hakemistoon *target* suoritettavan jar-tiedoston *Paassalaskuharjoittelusovellus-1.0-SNAPSHOT.jar*

### Checkstyle
Tiedostoon [checkstyle.xml]() määritelemät tarkistukset suoritetaan komennolla
```
mvn jxr:jxr checkstyle:checkstyle
```
Mahdolliset virheilmoitukset selviävät avaamalla selaimella tiedosto *target/site/checkstyle.html*
