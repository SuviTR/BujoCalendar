# BujoCalendar
Metropolia AMK scrum project. Ryhmä numero 2.

## Sovelluksen osat
Sovellus jakautuu kahteen suoritettavaan Java-ohjelmaan, jotka kommunikoivat HTTP-protokollan välityksellä:
 * Backend - löytyy paketista MetropoliaAMKgroup02.Backend
 * BujoCalendar - löytyy paketista MetropoliaAMKgroup02.BujoCalendar
 
 **Backend** pystyttää pienen HTTP-palvelimen, vastaanottaa pyyntöjä, ja vastaa niihin tietokannasta Hibernaten avulla haetulla datalla, jolle tehdään JSON-muunnos.
 
 **BujoCalendar** taas näyttää käyttöliittymän, ja osaa lisäksi kommunikoida backendin suuntaan yksinkertaisena HTTP-clienttinä.
 
# Asennusohjeet:
## Vaatimukset
Ohjelma tarvitsee seuraavat palikat:
 * Java 1.8
 * JavaFX
 * Hibernate
 * Maven
 
 ## Asentaminen:
 Asentele kaikki yllä mainitut kikkareet, jotkut ehkä useampaankin kertaan ja nakuttele IDE:stä nappuloita niin kauan, että sattuu asiat toimimaan. Jos tähdet on oikeassa asennossa ja Mavenin henki suosiollinen, saattaa ohjelma käynnistyä!
