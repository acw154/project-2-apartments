# RevatureRealocator
Full Stack Application for Revature Employees to locate an apartment based on certain filters

## Technologies
  - Angular
  - Spring ORM, MVC
  - Hibernate
  - Java 8
  - Mockito
  - Common Codec
  - PostgreSQL
  - JUnit
  - Log4j
  - AWS RDS
 
# Features
  ## Login / Register
      Users can register for the application by providing the required fields. Once registered, a user can login and access the various 
      functions of the application.
  ## Profile
      Users can view their personal information as well as any saved preferences or properties. Users can also edit their preferences by
      clicking an edit button that will allow them to input new values for their preference.
  ## User Search
      Any user can search for other users within the application based on the state of interest. The current state value of any user refers       to the state of interest in regards to where they plan on living or where they might currently live. Users can, upon searching, view
      the email addresses of users in that area to coordinate the search for a living space.
  ## Rental Search
      Users can search for rental properties pulled from the Realtor API as well as any user created properties stored within the AWS RDS.
      The rental properties retrieved can further be viewed through the ...
  ## Individual Property Page
      Users can view specific properties to glean more information on that specific property as well as save that property to their profile       for ease of view.
  ## Create Property
      Users can create a property by providing the required fields. Once created, that property can be viewed by other users upon using a 
      search filter that matches that particular property.
  ## Log Out
    Logging out will invalidate the user session.
      
