set ProjectPath=%~dp0
cd %ProjectPath%
echo %ProjectPath%
set p=%PATH%
java -javaagent:"%ProjectPath%\libAllure\aspectjweaver-1.9.21.jar" -classpath "%ProjectPath%;%ProjectPath%libAllure\*;%ProjectPath%libLog4Jver2\*;%ProjectPath%libReportNG\*;%ProjectPath%libraries\*;" org.testng.TestNG "%ProjectPath%resources\RunNopCommerceUI.xml"
 allure serve .\allure-json\
pause