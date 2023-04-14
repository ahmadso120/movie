# Movie

## --- Requirement ---
You should add base url and api key to gradle.properties before build app.

## BDD Specs

### Title: Upcoming Movies List Feature

### Narrative #1

```
As an online user
I want to be able to view a list of upcoming movies
So that I can plan which movies to watch in the future
```

#### Scenarios (Acceptance criteria)

```
Given that a user is connected to the internet
When the user navigates to the "Upcoming Movies" page
Then the user should be able to see a list of movies that are coming soon
```

### Narrative #2

```
As an offline user
I want to receive a message indicating that I cannot access the list of upcoming movies
So that I can understand the cause of the issue and take appropriate action
```

#### Scenarios (Acceptance criteria)

```
Given that an offline user attempts to access the list of upcoming movies on the movie listing app
When the user navigates to the upcoming movies page
Then the user should be notified with a message indicating that the list of upcoming movies is not accessible without an internet connection
```

## Flowchart
![](https://github.com/ahmadso120/movie/blob/master/screenshot/upcoming_movies_flowchart.png?raw=true)