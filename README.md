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

# Tutorial 3
1. I adhered to the principles of Single Responsibility Principle (SRP) and Dependency Inversion Principle (DIP).

    - SRP dictates that each class should have only one responsibility. Specifically, I separate the CarController and ProductController to ensure each has a distinct responsibility.
    - DIP emphasizes the use of abstractions over concrete implementations. This is another reason I divide CarController and ProductController.

2. In my perspective, adhering to SOLID principles serves to unify programmers' mindsets towards a cleaner approach. Some benefits of implementing SOLID principles include:

    - Emphasizing intuition over code length. The Interface Segregation Principle (ISP) explains that code length isn't an issue; initial intuition upon seeing class/function names should immediately form to understand their functionality. An interface with 4 methods can be divided into 2 methods with more representative names depicting their functions.
    - Well-organized code lengthens expedite debugging, reading, and testing processes. The decomposition of classes such as CarController and ProductController serves as an example.
    - Assigning a single responsibility to each function enables easy understanding just by looking at its name. The decomposition of classes like CarController and ProductController is another example.
    - Adding new features becomes easier without disrupting existing code and tests. Creating a new interface for uniform classes is one such example, enabling future implementation and comparison for new features.
    - Child classes can be considered as parents, necessary because fundamentally, parents represent a general form of children, so all children should also have the properties of their parent. If B inherits from A and we want to compare among A, then we should be able to use B in that comparison.

3. Lengthy functions can decrease developer productivity. Reading a complex, lengthy function can discourage us even before we start reading it.
    - Modifying old code might occur. Modifying old code can trigger test modifications, jeopardizing and removing the assurance of functioning features.
    - Understanding older code takes longer. Due to the length of a function, its name may potentially be unintuitive, demanding developers to read its content.
    - Adding new features becomes difficult. Adding new features may require modifying old code and might involve a lot of code repetition.


## Tutorial 4

1. Based on Percival's self-reflective questions regarding the Test-Driven Development (TDD) process, I find the TDD procedure highly beneficial in my software development endeavors. By creating tests before writing code, I can ensure that the code I produce passes tests and is thus safer. This process also aids in confident refactoring as I have a suite of tests to verify that changes I make do not break existing functionality.
However, I acknowledge that there are aspects to consider to further enhance the testing process. Firstly, I need to consider adding tests that cover interactions between features. For example, I could create tests that encompass creating, updating, and deleting products simultaneously to ensure that these features function correctly in their interactions.

2. Regarding the F.I.R.S.T. principle, I believe that the tests I have created have adhered to this principle. They are focused, independent, repeatable, specific, and timely. Each test examines a single unit of code in isolation and verifies the expected output. However, I will continue striving to improve the quality of my tests by ensuring they cover all possible edge cases and component interactions more thoroughly.