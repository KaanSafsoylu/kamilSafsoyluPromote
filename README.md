<h1 align=“left”> Testinium Promote Project </h1>

Greetings,

You can find information about the project below.

#### Technologies Used:
- Selenium 4.13
- Junit Jupiter 5.1
- Gauge 0.9.1
- log4j 1.7.30
- extentreports 5.0.9

#### Environment Description:

**1.** In the BaseTest class, specify the browser you want to run the test with the “BROWSER” parameter (If you give the mac parameter on a windows machine, it will get an error because the OS is automatically pulled from the system).

**2.** You can go to the Elements class to examine the elements.

**3.** If you go to specs/caseconcepts directory, you can view the scenario-based flows of the tests.

**4.** If you go to specs/testrunners directory, you will access the .spec files of the tests that can be run in batch and scenario based.

**5.** If you go to pom.xml, you can access the dependencies of the project

**6.** Extent reports is used as a reporting tool. Reports are available in the reports directory.

#### Usage:

**1.** Run `mvn clean install` command from terminal to install the dependencies in pom.xml.

**2.** **Run via spec:** If you enter a random .spec file in the specs/testrunners directory and press run, the test will start on the browser you specified in the BaseTest class.

**3.** **Run by Command:** Start tests with the `mvn gauge:execute` command or you can run a specific scenario with the `gauge run --scenario=“exampleScenarioName”` command

Thank you,
Kamil Safsoylu