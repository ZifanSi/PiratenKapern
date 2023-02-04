# A1 - Piraten Karpen

  * Author: < Zifan Si (Frank) >
  * Email: < siz@mcmaster.ca >

## Build and Execution

  * To clean your working directory:
    * `mvn clean`
  * To compile the project:
    * `mvn compile`
  * To run the project in development mode:
    * `mvn -q exec:java` (here, `-q` tells maven to be _quiet_)
  * To package the project as a turn-key artefact:
    * `mvn package`
  * To run the packaged delivery:
    * `java -jar target/piraten-karpen-jar-with-dependencies.jar` 

Remark: **We are assuming here you are using a _real_ shell (e.g., anything but PowerShell on Windows)**

## Feature Backlog

 * Status: 
   * Pending (P), Started (S), Blocked (B), Done (D)
 * Definition of Done (DoD):
   * < The definition of done (DoD) is when all conditions, or acceptance criteria, that a software product must satisfy are met and ready to be accepted by a user, customer, team, or consuming system>

### Backlog 

| MVP? | Id  | Feature                                            | Status | Started  | Delivered |
|------|-----|----------------------------------------------------|--------|----------|-----------|
| yes  | F01 | Roll eight dices                                   | D      | 01/10/23 | 01/10/23  |
| yes  | F02 | Score points: DIAMOND, GOLD                        | D      | 01/10/23 | 01/10/23  |
|      | F03 | threeSKULLL strategy: End of game with three SKULL | D      | 01/10/23 | 01/10/23  |
| yes  | F04 | Build simulation                                   | D      | 01/10/23 | 01/10/23  |
|      | F05 | Implement Log4J                                    | D      | 01/29/23 | 01/31/23  |
| yes  | F06 | Random strategy: reroll once                       | D      | 01/29/23 | 01/31/23  |
| yes  | F07 | Combo points (3,4,5,6,7,8 of-a-kind)               | D      | 01/29/23 | 01/31/23  |
| yes  | F08 | Combo strategy: decide hold and drop, then reroll  | D      | 01/29/23 | 01/31/23  |
| yes  | F09 | Select strategy from command line arguments        | D      | 01/29/23 | 01/31/23  |
| yes  | F10 | Build Sea Battle mechanics                         | D      | 02/01/23 | 02/01/23  |
| yes  | F11 | Build card methods                                 | D      | 02/01/23 | 02/01/23  |
| yes  | F12 | Build Monkey Business mechanics                    | D      | 02/01/23 | 02/01/23  |
|      | F13 | Optimize combo strategy                            | D      | 02/01/23 | 02/01/23  |
|      | F14 | optimize Trace Mode                                | D      | 02/01/23 | 02/01/23  |
|      | F15 | optimize Simulation                                | D      | 02/01/23 | 02/01/23  |
    


