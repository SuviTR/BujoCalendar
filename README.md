# BujoCalendar
Metropolia AMK scrum project. Ryhmä numero 2.

## Sovelluksen osat
Sovellus jakautuu kahteen suoritettavaan Java-ohjelmaan, jotka kommunikoivat HTTP-protokollan välityksellä:
 * Backend - löytyy paketista MetropoliaAMKgroup02.Backend
 * BujoCalendar - löytyy paketista MetropoliaAMKgroup02.BujoCalendar
 
 **Backend** pystyttää pienen HTTP-palvelimen, vastaanottaa pyyntöjä, ja vastaa niihin tietokannasta Hibernaten avulla haetulla datalla, jolle tehdään JSON-muunnos.
 
 **BujoCalendar** taas näyttää käyttöliittymän, ja osaa lisäksi kommunikoida backendin suuntaan yksinkertaisena HTTP-clienttinä.
 
