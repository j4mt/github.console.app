- Sample Get https://api.github.com/search/repositories?q=testNG&sort=stars&order=desc&per_page=1

- to run application

    - mvn clean package
    - java - jar .\target\github.search-0.0.1-SNAPSHOT.jar {args}

        - java - jar .\target\github.search-0.0.1-SNAPSHOT.jar --searchRepo TestNg
        - java - jar .\target\github.search-0.0.1-SNAPSHOT.jar --searchRepo TestNG --perPage 1 (get only one repo)

- adding jacoco report

    - github.search\target\site\jacoco        
        
        
