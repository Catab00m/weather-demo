# To Start:

### Local Build (using local jdk)

first run ```mvn clean package```<br>
then run ```docker-compose up -d --build```<br>


### Full container build (if you don't have proper jdk)

in the docker file, uncomment second part of the file and comment the first half<br>
then run ```docker-compose up -d --build```<br>
it is done through a multi-build process
_______________________________________

Service listens on port ```9090```<br>
_______________________________________

For the EDITOR role, you need to specify bearer token with a code from application.yaml file (default 0451)