set ProjectPath=C:\Automation\AutoDEVLAB
cd %ProjectPath%
set classpath=%ProjectPath%\bin;%ProjectPath%\lib\*
java org.testng.TestNG %ProjectPath%\testng.xml
pause