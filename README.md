# Travel Vaccine Report Builder

## A tool for pharmacists that creates a personalized report containing travel vaccines  for a patient's trip to their indicated destination

**What this project will do:**
- Users will input patient information (name and age)
- Users will input the patient destination(s)
- The user will then add the recommended vaccines
-  A report will be made containing patient information, destinations and recommended vaccines

**Who will use this project:**
- This project is to be used by pharmacists (and other travel health experts)

**Why this project is of interest:**
- Previoulsy I worked as a travel medicine consultant conducting pre-travel appointments and providing patients with a report of what vaccines they need based on where they are going. I am hoping this tool will be able to create reports that patients can reference and expidites the process for the consultant in generating the report.

**User Stories**
- As a user I want to be able to generate a report of vaccine recommendations for a given person's destination(s)
- As a user I want to be able to add the generated reports in a reports library
- As a user I want to be able to see a list of reports made 
- As a user I want to be able to select reports and view them in detail
- As a user I want to be able to save the Report Library (containing reports)
- As a user I want the option to load my Report Library from file

# Instructions for Grader
- You can generate the first required action related to adding Xs to a Y by clicking the "Create Report" button
    - This will prompt the user to fill in information and will add the report to the library
- You can generate the second required action related to adding Xs to a Y by clicking the "View Library" button
  - This will take open a new screen to all the current reports in the library
- You can retrieve a specific report from the report library by clicking the "View Report" button
  - This will prompt the user to enter a name and from that open that patient's report (if it exists) on a new screen
- You can locate the visual component on the main splash screen
- You can save the state of my application by clicking the "Save" button
- You can reload the state of my application by clicking the "Load" button


## Phase 4: Task 2
- Implementing event logging for:
  - Adding a Report to a Report Library
  - Veiwing a specific Report
  - Veiwing all Reports in Report Library
- Sample Event logging print out to console:
Tue Apr 11 14:06:52 PDT 2023
Event log cleared.

Tue Apr 11 14:07:03 PDT 2023
Added Report for Aman J to: Set 1

Tue Apr 11 14:07:07 PDT 2023
Displaying all reports in: Set 1

Tue Apr 11 14:07:21 PDT 2023
Added Report for Eugene W to: Set 1

Tue Apr 11 14:07:25 PDT 2023
Displaying all reports in: Set 1

Tue Apr 11 14:07:30 PDT 2023
Displaying Report for: Aman J

## Phase 4: Task 3

Reflecting on my UML diagram and the process of creating it I noted that lots of my project 
relied on very large classes and/or very large methods, most notably the GUI class. Within
the GUI class there are two methods which supress the "methodLength" warning, and many other methods 
defined in the class, most of which alter the behaviour of the program. This evidently
does not follow the single responsibility principle (each class should be centered around
one concept or responsibility). Extracting methods, like button initialization, or creating a separate
class for the "create a report" button would decrease coupling make the code simpler.

Futhermore, it is clear that the HashMap of vaccine info has no associations, while there are
dependencies in certain classes, perhaps there could be improvement by declaring the map as a private 
field within the report class, since the user does not add or remove from the map, the map does not get edited
by the user. The use is for simple look-up so it essentially acts as a Constant.
