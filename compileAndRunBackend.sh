
set -e
clear
echo "DB_NAME $DB_NAME"

echo "Shell script: Compiling into jar using maven"
cd project1-backend
mvn package

sh runBackend.sh