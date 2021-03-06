# Päässälaskuharjoittelusovellus
Sovelluksella käyttäjä voi harjoitella paassalaskutaitojaan. Sovelluksessa on valittavissa kolme eri vaikeustasoa. Käyttäjä voi pistelistalta tarkastella myös muiden käyttäjien saamia pisteitä.

## Dokumentaatio
[Käyttöohje](https://github.com/vilsuo/ot-harjoitustyo/blob/master/dokumentointi/kayttoohje.md)

[Vaatimusmäärittely](https://github.com/vilsuo/ot-harjoitustyo/blob/master/dokumentointi/vaatimusmaarittely.md)

[Työaikakirjanpito](https://github.com/vilsuo/ot-harjoitustyo/blob/master/dokumentointi/tyoaikakirjanpito.md)

[Arkkitehtuurikuvaus](https://github.com/vilsuo/ot-harjoitustyo/blob/master/dokumentointi/arkkitehtuuri.md)

[Testausdokumentti](https://github.com/vilsuo/ot-harjoitustyo/blob/master/dokumentointi/testaus.md)

## Releaset
[Viikko 5](https://github.com/vilsuo/ot-harjoitustyo/releases/tag/viikko5)

[Viikko 6](https://github.com/vilsuo/ot-harjoitustyo/releases/tag/Viikko6)

[Loppupalautus](https://github.com/vilsuo/ot-harjoitustyo/releases/tag/Loppupalautus)

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
