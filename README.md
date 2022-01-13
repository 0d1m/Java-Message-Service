# Java-Message-Service
Java (Maven) project that implements JMS API to send messages between 2 applications (Consumer that receives the message sent by the Producer) using embeded ActiveMQ Client as broker (an external broker can also be used)

## Running the project
To run the project we have to run the ActiveMQBroker class first then we run Producer followed by the Consumer.
Alternatively we can run ActiveMQ Client as an external application by downloading it from : https://activemq.apache.org/components/classic/download/
then unzip it and run it with the command : "activemq start" from inside the "bin" folder.
