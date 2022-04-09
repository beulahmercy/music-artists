STACK used
Java 8 + Spring Boot 2.X  + JPA

Have created the following RESTful API
* REST API
  * `/artists` endpoint to manage Artist data. Required information: artist name
      * `POST /artists` to save a new artist
      * `PUT /artists/{artistId}` to update an existing artist
      * `GET /artists` lists all artists. Implement:
        * filtering by a part of artist name
        * sorting by artist name (asc/desc)
        * paging (I have separate endpoint /artists/page/{pageNo})
  * `/artists/{artistId}/albums` endpoint to manage Album data. Required information: title, year of release, genres (list of tags).
      * `POST /artists/{artistId}/albums` to add a new album to an existing artist
      * `PUT /artists/{artistId}/albums/{albumId}` to update an existing album
      * `GET /artists/{artistId}/albums` lists all albums by the given artist. Implement:
        * filtering by genre(s)
        * sorting by album name and release year (asc/desc)
        
* Sample JSON output structure
{
    "id": 1,
    "albums": [
        {
            "id": 1,
            "yearOfRelease": 2019,
            "title": "country roads",
            "genres": [
                "rap",
                "pop"
            ]
        }
    ],
    "name": "john"
}

* Data persistence (embedded DB of your choice) 
I have used in memory database H2

* Tests should be an integral part of your solution
Have written some couple of test cases

* No External API integration
I have tried to authenticate the API to get the accessToken, however I was getting Expected Signature base string in the POST call

a) GET https://api.discogs.com/oauth/request_token?oauth_consumer_key=aZsQPrOWNkkWGoLhmydM&oauth_signature_method=PLAINTEXT&oauth_timestamp=1592480416&oauth_nonce=hc5tl5&oauth_version=1.0&oauth_signature=rVoKOntEkGPPyddTRYodsTjKuLRVfWSV%26
RESPONSE oauth_token=cCSdOHwGFTiqeFhODGiUOmrwsMtZQvqRsPQJzGNp&oauth_token_secret=POxYdhJyhgfyHxvfowjmjAdfYCChZKVMurYJADDQ

b)  REDIRECT PAGE https://discogs.com/oauth/authorize?oauth_token=cCSdOHwGFTiqeFhODGiUOmrwsMtZQvqRsPQJzGNp
RESPONSE verify token

c) POST https://api.discogs.com/oauth/access_token
oauth_verifier:TWJFvkgsWL
oauth_consumer_key:aZsQPrOWNkkWGoLhmydM
oauth_token:cCSdOHwGFTiqeFhODGiUOmrwsMtZQvqRsPQJzGNp
oauth_signature_method:PLAINTEXT
oauth_timestamp:1592480633
oauth_nonce:C3VyBU
oauth_version:1.0
oauth_signature:rVoKOntEkGPPyddTRYodsTjKuLRVfWSV&

RESPONSE Expected signature base string: rVoKOntEkGPPyddTRYodsTjKuLRVfWSV&POxYdhJyhgfyHxvfowjmjAdfYCChZKVMurYJADDQ

* Have included spring-boot-starter-actuator dependency which enables the following services to check the analytics
 /metrics, /health
 example URL http://localhost:8084/actuator/metrics/http.server.requests

# Database Cache
* To enable caching add @EnableCaching annotation to spring configuration file.
* Write @Cacheable annotation at method level which returns values. @Cacheable requires value parameter which indicates key of cachable value.
* @CacheEvict annotation used for clean cache value. While add, update or delete the value in the database then we need to clear existing cache to the consistency of result.
### Disable Cache
spring.cache.type=none

# Spring Boot Logging
* spring-boot-starter-web, depends on spring-boot-starter-logging, which already pulls in spring-jcl for us.
* When using starters, Logback is used for logging by default.
* the default logging level of the Logger is preset to INFO, meaning that TRACE and DEBUG messages are not visible.
* To customize logging level
  * logging.level.org.springframework=TRACE
  * logging.level.com.example=TRACE
### Logback Configuration Logging
When a file in the classpath has one of the following names, Spring Boot will automatically load it over the default configuration:
* logback-spring.xml
* logback.xml
* logback-spring.groovy
* logback.groovy

# Custom annotation in Spring Boot
* @Target in the above annotation definition defines where to apply the annotation . In our case it is at the method level , so we give ElementType.METHOD as parameter

* @Retention denotes when to apply this annotation , in our case it is at run time

###To trace the requests and responses to a REST method in Spring Boot.
```
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
 
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Traceable {
}
```

```
@Aspect
@Component
public class TraceableAspect {

    Logger logger = LoggerFactory.getLogger(TraceableAspect.class);
 
    @Around("@annotation(Traceable)")
    public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {
 
        logger.info("Input : {}", joinPoint.getArgs()[0]);
 
        Object result = joinPoint.proceed();

        // Creating Object of ObjectMapper define in Jakson Api
        ObjectMapper Obj = new ObjectMapper();

        try {

            // get Organisation object as a json string
            String jsonStr = Obj.writeValueAsString(result);

            // Displaying JSON String
            logger.info("result {}", jsonStr);
        }

        catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
 
}
```
# Java Collections Reference
https://en.proft.me/2013/11/3/java-collection-framework-cheat-sheet/

# Data Structures & Algorithms

###Working example for data structures and algorithms
https://www.cs.usfca.edu/~galles/visualization/Algorithms.html
https://towardsdatascience.com/8-common-data-structures-every-programmer-must-know-171acf6a1a42

###Common Data Structures Operations
* Array
* Stack
* Queue
* Singly Linked List
* Doubly Linked List
* Hash Table
* Binary Search Tree
* AVL Tree
  
###Sorting and Searching

* Selection Sort
  * https://i0.wp.com/www.algolist.net/img/sorts/selection-sort-1.png?zoom=2

* Insertion Sort
  
* Bubble Sort

* Merge Sort

* Quick Sort

* Heap Sort

* Sequential / Linear Search (unordered list)

* Binary Search (in a sorted array)

* Binary Search Tree (unbalanced)

* Hash Table (separate chaining) & (linear probing)