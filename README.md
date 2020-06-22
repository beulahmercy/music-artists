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
 