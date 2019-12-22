# Käyttöohje
Lataa tiedosto [Paassalaskuharjoitelusovellus.jar](https://github.com/vilsuo/ot-harjoitustyo/releases/download/Loppupalautus/Paassalaskuharjoittelusovellus.jar)

## Ohjelman käynnistäminen
Ohjelma käynnistetään komennolla
```
java -jar paassalaskuharjoittelusovellus.jar
```

## Kirjautuminen
Sovellus käynnistyy kirjautumisnäkymään:

![](https://github.com/vilsuo/ot-harjoitustyo/blob/master/dokumentointi/kuvat/login.png)

Kirjautuminen onnistuu syöttämällä käyttäjätunnus ja salasana niille tarkoitetuille kentille ja painamalla **Login**-nappia.

## Uuden käyttäjän luonti
Uuden käyttäjän luomiseen siirrytään painamalla **Create a new account**-nappia. Tämän jälkeen syötetään haluamansa käyttäjätunnus ja salasana niille tarkoitetuille kentille ja lopulta käyttäjä luodaan painamalla **Create**-nappia.

![](https://github.com/vilsuo/ot-harjoitustyo/blob/master/dokumentointi/kuvat/createUser.png)

## Pelin valitseminen
Kirjauduttuaan sisään käyttäjä voi valita vaikeustason **Select difficulty**-valikosta.

![](https://github.com/vilsuo/ot-harjoitustyo/blob/master/dokumentointi/kuvat/selectDifficulty.png)

ja tämän jälkeen siirtyä peliin painamalla **Play**-nappia.

![](https://github.com/vilsuo/ot-harjoitustyo/blob/master/dokumentointi/kuvat/playSelected.png)

## Pelaaminen
Pelaaja syöttää vastauksensa ylläolevaan laskutoimitukseen vastauskenttään ja painaa **ENTER**-näppäintä antaakseen vastauksensa. Pelaajalla on aikaa vastata laskutoimitukseen kunnes aikaa edustava punainen palkki on kokonaan hävinnut. Vastauksen antamisen tai ajan loppumisen jälkeen annetaan uusi laskutoimitus ja aika alkaa alusta. Pelaajan vastattua vastauskentän alapuolelle ilmestyy teksti kertoen oliko pelaajan vastaus oikein. Oikeasta vastauksesta pelaajalle annetaan pisteitä. Väärästä vastauksesta tai ajan loppumisesta pelaajalta sakotetaan yksi elämä. Kolme elämää menetettyään pelaaja häviää pelin.

![](https://github.com/vilsuo/ot-harjoitustyo/blob/master/dokumentointi/kuvat/playView.png)

## Hiscore
Käyttäjä voi tarkastella pisteitä hiscorelistalta painamalla nappia **Hiscores**.

![](https://github.com/vilsuo/ot-harjoitustyo/blob/master/dokumentointi/kuvat/hiscoreView.png)
