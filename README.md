# checkpeople - Simple Rest API

The checkpeople is an example of simple Rest API. The project use Spark Framework to become easy implementation.

Note: the url of application deployed ```https://calm-sands-37831.herokuapp.com/api```

## Prerequisites

* [JDK 1.8](https://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html) 
* [Maven](https://maven.apache.org/download.cgi) 
* [Postman](https://www.getpostman.com/downloads/) - to test api

## Instalation

1. Run the command below on the terminal.

```
https://github.com/jpbaterabsb/checkpeople.git
```

2. Enter the project root folder by terminal.

```
mvn clean install 
```

3. Enter the <b>/target</b> folder by terminal, then execute the following command.

```
java -jar rest-api-0.0.1-SNAPSHOT.jar
```
4. The application is already running.

## How to use

Navigate to:```http://localhost:4567```

![alt text](https://user-images.githubusercontent.com/31267814/51361782-44145a80-1ab8-11e9-94a5-fb6665691563.png)

| Path           | Method    | Description                                               |
| :---:              | :-:       | :-:                                                   |
| /api/start     | GET       | Add 3 static developers into in-memory database           |
| /api/developer     | GET       | Show all developers                                   | 
| /api/developer/add | POST       | Add a new developer                                  | 
| /api/developer/:id/update | PUT       | Update a existing developer                    | 
| /api/developer/:id/remove | DELETE       | Remove a developer                          | 
| /api/developer/:id/show | GET       | Find developer by id                             | 

Note: replace the word: id with the identifier number.

## Example

Following the developer JSON Object.
```
{  
   "id":1,
   "name":"Jack Black",
   "age":26,
   "language":"PHP",
   "position":"Developer"
}
```
### 1. api/start

![alt text](https://user-images.githubusercontent.com/31267814/51363108-b50a4100-1abd-11e9-8319-d3182cfd368c.png)

### 2. api/developer/add

![alt text](https://user-images.githubusercontent.com/31267814/51363040-6d83b500-1abd-11e9-997c-e96b0c0752e8.png)

### 3. api/developer/:id/update

![alt text](https://user-images.githubusercontent.com/31267814/51363067-88eec000-1abd-11e9-8e97-bfb3c66485e6.png)

### 4. api/developer/:id/remove

![alt text](https://user-images.githubusercontent.com/31267814/51363092-a459cb00-1abd-11e9-9cf5-f4331f76bb40.png)

### 5. api/developer/:id/show

![alt text](https://user-images.githubusercontent.com/31267814/51363060-80968500-1abd-11e9-8638-774a0c62e6c2.png)

### 6. api/developer

![alt text](https://user-images.githubusercontent.com/31267814/51363047-78d6e080-1abd-11e9-83dc-f7a4397fbee4.png)
