# Päässälaskuharjoittelusovellus
## Dokumentaatio
[Käyttöohje]()

[Vaatimusmäärittely](https://github.com/vilsuo/ot-harjoitustyo/blob/master/dokumentointi/vaatimusmaarittely.md)

[Työaikakirjanpito](https://github.com/vilsuo/ot-harjoitustyo/blob/master/tyoaikakirjanpito.md)

[Arkkitehtuurikuvaus](https://github.com/vilsuo/ot-harjoitustyo/blob/master/dokumentointi/arkkitehtuuri.md)


## Releaset
[Viikko 5](https://github.com/vilsuo/ot-harjoitustyo/releases/tag/viikko5)

[Viikko 6]()

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

### JavaDoc
JavaDoc generoidaan komennolla
```
mvn javadoc:javadoc
```

JavaDocia voi tarkastella avaamalla selaimella tiedosto *targer/site/apidocs/index.html*


### Checkstyle
Tiedostoon [checkstyle.xml](https://github.com/vilsuo/ot-harjoitustyo/blob/master/Paassalaskuharjoittelusovellus/checkstyle.xml) määritelemät tarkistukset suoritetaan komennolla
```
mvn jxr:jxr checkstyle:checkstyle
```
Mahdolliset virheilmoitukset selviävät avaamalla selaimella tiedosto *target/site/checkstyle.html*
