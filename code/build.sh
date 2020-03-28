find . -name "pom.xml" -exec ~/apache/apache-maven-3.6.0/bin/mvn clean install -DskipTests=true -f '{}' \;
