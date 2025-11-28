# Feladvány

## A readme tartalma: 
- [Frontend]("#frontend")
- [Backend]("#backend")

## Backend:
> A backend elinditásához vagy az 'mvn spring-boot:run'/'mvn spring-boot:run' paranccsal inditható el. Parancs nélkül, az aktuálisan IDE-vel is inditható a projekt.
A projekt backend ügyileg Java Spring bootos és H2 (in-memory) adatbázist használ. 
- Az **API szerződés** ezen a [linken]("http://localhost:8080/swagger-ui/index.html#/") érhető el. **A szerződéshez, szükséges, hogy fusson a backend projekt.**


## Frontend:
> A frontend elindításához szükséges az 'npm install' parancs használata. A használata nélkül nem fog elindulni a projekt frontend része. A parancs után az angular projekt indítható az ng-serve/npm start paranccsal.

Az projekt frontend ügyileg Bootstrap és Angular keretrendszereket és Material Design-t 
használ.
Az angular projekt a következő **componentekre** osztódik fel: 
- **homePage:** Ez a component fogadja a usert az oldal betöltésekor, itt jelenik meg a keresőbár és a termékek listája. 
- **notFound:** Ha a user nem létező útvonalat ír be a böngésző keresőfelületébe akkor ez fogadja. 
- **productCard:** Az adott termékeknek az információit jeleníti meg. 
- **searchBar:** A keresőmezőt és a filtereket tartalmazza. 

**A projektben jelen lévő service: ProductService**

