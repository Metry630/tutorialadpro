Link deployment:
https://tutorialadprojojo-hoho.koyeb.app/

# Tutorial 1
## Exercise 1
The clean code principles that I've applied in this module:
* Clear and self-explanatory variable names
* Clear and self-explanatory function names
* The lack of necessity for comments as the code is already clear enough
* No null returned
* Production is executed using branch workflow and with no trunking

This is not so much a mistake as it is a lack of feature, but there needs to be an authentication and authorization system in order to regulate who can manipulate and delete products

## Exercise 2
1. 
* I still feel somewhat uncomfortable writing tests. It does make me feel that my code is more stable though
* I feel that the number of unit tests necessary should depend on the functionality of the program. The more features there are, the more tests necessary.
* No, if you have 100% code coverage, your code can still have bugs or errors. It simply means that all functionality in the code has already had tests written for it.
2. I think the code efficiency would get worse due to repetition. Both functions also do more than one thing, which isn't ideal. We should ideally separate each feature, so that each function only does one thing.

# Tutorial 2
1. I fixed a few naming issues. The naming convention is CamelCase, but I had underscores which are not allowed. I also had incorrect capitalization. To fix these issue, I simply renamed the variables according the convention. 
2. Yes, I think that the current implementation already includes both continuous integration and deployment. Continuous Integration refers to the Code and Test phases. I implement this using the ci.yml workflow which automatically tests processes with any updates to my repository. Continuous Deployment consists of the Review and Operational phases. I implement this using Koyeb, which will automatically run the deployment process every time there is an update to my repository.


