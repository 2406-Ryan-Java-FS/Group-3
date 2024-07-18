

#
#application.properties is the default spring profile
#application-rsc.properties is our own custom made profile
#application-server.properties is another
#
#We can set the current profile to use here
#this will be similar to how it's done on an aws server
#

echo "Shell script: Running the jar"
java -jar target/project1-0.0.1-SNAPSHOT.jar --spring.profiles.active=default