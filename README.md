<h1 align="left" style="color:red;"> Testinium Promote Project </h1>

Greetings,

You can find information about the project below.

#### Technologies Used:
- Selenium 4.13
- Junit Jupiter 5.1
- Gauge 0.9.1
- log4j 1.7.30
- extentreports 5.0.9

#### Environment Description:

<ul>
  <li style="color:red;">If you want to examine the scenarios on excel, you can click the <code>CatchyLabs_Scenarios.xlsx</code> file in project. </li>
  <li style="color:red;">In the BaseTest class, specify the browser you want to run the test with the “BROWSER” parameter (If you give the safari parameter on a windows machine, it will get an error because the OS is automatically pulled from the system).</li>
  <li style="color:red;">You can go to the Elements class to examine the elements.</li>
  <li style="color:red;">If you go to <code>specs/caseconcepts</code> directory, you can view the scenario-based flows of the tests.</li>
  <li style="color:red;">If you go to <code>specs/testrunners</code> directory, you will access the <code>.spec</code> files of the tests that can be run in batch and scenario based.</li>
  <li style="color:red;">If you go to <code>pom.xml</code>, you can access the dependencies of the project.</li>
  <li style="color:red;">Extent reports is used as a reporting tool. Reports are available in the <code>reports</code> directory.</li>
</ul>

#### Usage:

<ul>
  <li style="color:red;">Run <code>mvn clean install</code> command from terminal to install the dependencies in <code>pom.xml</code>.</li>
  <li style="color:red;">**Run via spec:** If you enter a random <code>.spec</code> file in the <code>specs/testrunners</code> directory and press run, the test will start on the browser you specified in the BaseTest class.</li>
  <li style="color:red;">**Run by Command:** Start tests with the <code>mvn gauge:execute</code> command or you can run a specific scenario with the <code>gauge run --scenario="exampleScenarioName"</code> command.</li>
</ul>

Thank you,  
Kamil Safsoylu
