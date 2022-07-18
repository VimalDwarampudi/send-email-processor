# send-email-processor

#Put Mirror config in maven settings.xml if compilation failed ( it couldn't pull the dependencies from confluent) so open the raw file of readme to get the xml tags for mirror

#<mirror>
#<id>confluent</id>
#<mirrorOf>confluent</mirrorOf>
#<name>Nexus public mirror</name>
#<url>http://packages.confluent.io/maven/</url> 
#</mirror>

#first build avro-schema module
#cd avro-schema
#mvn clean install

#next build the main project (send-email-processor)
#cd ..
#mvn clean install
