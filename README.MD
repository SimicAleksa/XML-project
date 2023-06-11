## README.md - XML Project

### Studenti
- Nevena Radešić SW 12/2019
- Aleksa Simić SW 13/2019
- Strahinja Popović SW 51/2019

### Pokretanje frontenda
```
npm install
npm start
```

### Pokretanje backenda
- Pokrećemo zajednički backend
- Pokrećemo patent backend
- Pokrećemo zig backend
- Pokrećemo autorska prava backend

### Pokretanje baza
1. Otvaramo Docker
2. U command promptu unosimo sledeće naredbe:

#### Prvi set naredbi je za eXist baze podataka za zahteve i korisnike
```
docker run -d -p 8042:8080 -p 8441:8441 --name existPat existdb/existdb
docker run -d -p 8032:8080 -p 8444:8444 --name existTrademark existdb/existdb
docker run -d -p 8022:8080 -p 8442:8442 --name existCopyR existdb/existdb
docker run -d -p 8081:8080 -p 8443:8443 --name existBack existdb/existdb
```

#### Drugi set naredbi je za Fuseki baze podataka za metapodatke
```
docker run --init -d -p 3042:3030 -e ADMIN_PASSWORD=pw123 --name fusekiPat stain/jena-fuseki
docker run --init -d -p 3032:3030 -e ADMIN_PASSWORD=pw123 --name fusekiTrademark stain/jena-fuseki
docker run --init -d -p 3022:3030 -e ADMIN_PASSWORD=pw123 --name fusekiCopyR stain/jena-fuseki
```

*Napomena: Prilikom kreiranja Fuseki baza, u svaku se mora ulogovati korisnik sa kredencijalima "admin" za username i "pw123" za šifru. Zatim treba kreirati odgovarajući dataset za odgovarajuće baze patentMD / trademarkMD  /authorRightsMD.*