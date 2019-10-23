# BujoCalendar
Metropolia AMK scrum project. Ryhmä numero 2.

## Sovelluksen osat
Sovellus jakautuu kahteen suoritettavaan Java-ohjelmaan, jotka kommunikoivat HTTP-protokollan välityksellä:
 * Backend - löytyy paketista MetropoliaAMKgroup02.Backend
 * BujoCalendar - löytyy paketista MetropoliaAMKgroup02.BujoCalendar
  
 **Backend** pystyttää pienen HTTP-palvelimen, vastaanottaa pyyntöjä, ja vastaa niihin tietokannasta Hibernaten avulla haetulla datalla, jolle tehdään JSON-muunnos.
 
 **BujoCalendar** taas näyttää käyttöliittymän, ja osaa lisäksi kommunikoida backendin suuntaan yksinkertaisena HTTP-clienttinä.

Lisäksi molempien osien käyttämiä luokkia on sijoitettu pakettiin **MetropoliaAMKgroup02.Common**. Sieltä löytyvät mm. backendin ja frontendin käyttämät Model-luokat, joiden avulla varsinainen kalenteridatan käsittely sujuu.

 
# Asennusohjeet:
## Vaatimukset
Ohjelma tarvitsee seuraavat palikat:
 * Oraclen Java 1.8, sisältäen JavaFX
 * Hibernate
 * Maven
 * Jackson
 
 ## Asentaminen:
 Kloonaa koodi omalle koneellesi. Tee sitten siitä projekti omaan IDE:hesi. Tämän koodivarannon mukana *ei* toimiteta valmiita projektitiedostoja. Työryhmän käyttämät kehitysympäristöt ovat Eclipse, IntelliJ Idea ja Netbeans.
 Näytä IDE:llesi, missä Oraclen Java 1.8 sijaitsee, ja käske sitä käyttämään tämän projektin yhteydessä aina kyseistä Java Runtimea.
 
 Projektissa mukana on Mavenin tarvitsema pom.xml-tiedosto.
 Kun teet Maven-buildin, pitäisi Mavenin asennella automaattisesti kaikki projektin vaatimat riippuvuudet. Toivotaan parasta! Jos näin ei käy, tarkista, että sinulla on IDE:n asetukset oikein, ja että IDE buildin tehdessään todella ajaa Mavenia eikä tee jotain muuta.
 
 Projekti ei kuitenkaan vielä käynnisty, koska tietokanta-asetukset ovat väärin.
 
### Tietokanta-asetukset Educloudiin:
 Backend tarvitsee toimiakseen tietokantapalvelimen. Sen asetukset ovat tiedostossa /src/main/resources/hibernate.cfg.xml. Oletuksena tiedostoon on konfiguroitu Educloud-palvelimemme tiedot. Tämä vaatii, että Sinulla on Metropolian VPN päällä, kun ajat ohjelmaa. Jos näin on, hyppää kohtaan "Ohjelman ajaminen".
 
### Tietokanta-asetukset Dockeriin
Jos et halua käyttää Educloudia, on projektissa myös alkeellinen tuki projektin ajamiseksi Dockerin päällä.
Aluksi sinun on asennettava Docker käyttöjärjestelmääsi. Ohjeet löytyvät: https://www.docker.com/
Kun Docker on asennettu, Dockerin käynnistämiseen ja konttien pystyttämiseen on olemassa pieni apuskripti projektin juuressa, nimeltä `mariadb-docker.sh`. Sitä ajetaan Linuxissa näin:
 ```
 ./mariadb-docker.sh install
 ./mariadb-docker.sh start
 ./mariadb-docker.sh status
 ./mariadb-docker.sh stop
```
Skripti lataa Mariadb-kontainerin, asentaa ja käynnistää sen, yhdellä komennolla! Tämän jälkeen voit käyttää eriytettyä Unix-ympäristöä, ikäänkuin olisi paikallisesti oma Mariadb-palvelin. Mukavaa elää täällä tulevaisuudessa.
 
/src/main/resources/hibernate.cfg.xml -tiedostossa on kommentoituna myös Dockerin Linuxissa käyttämä oletus-ip. Voit ottaa tämän vaihtoehdon käyttöön muokkaamalla tiedostoa. Mac- ja Windows-järjestelmissä ip-osoitteen paikalle kannattanee laittaa `host.docker.internal`

Tämän jälkeen pitää vielä tehdä tietokanta-asetukset käsin, koska ei olla vielä viitsitty laittaa docker-konfiguraatiotiedostoon näitä automaattisiksi. Kirjaudu siis MariaDB:hen sisään:
```
./mariadb-docker.sh login
# järjestelmä kysyy salasanaa, se on 'passwrd'
```
Tämän jälkeen aja seuraavat komennot:
```
CREATE DATABASE bujocalendar;
GRANT ALL PRIVILEGES ON bujocalendar.* TO appuser@'%' IDENTIFIED BY 'sera43';
```
Nyt sinulla pitäisi olla Docker-kontin sisällä luotuna `bujocalendar`-tietokanta, ja sille käyttäjä nimeltä `appuser`.

## Ohjelman ajaminen
Ensin pitää käynnistää Backend. Onnistuessaan se tulostaa:
   Server started. Listening http://localhost:8000
Kun Backend ilmoittaa näin, voit käynnistää frontendin. Se ottaa yhteyttä Backendiin toivottavasti automaattisesti. Tällä hetkellä fronttiin on kovakoodattu osoitteeksi http://localhost:8000.
