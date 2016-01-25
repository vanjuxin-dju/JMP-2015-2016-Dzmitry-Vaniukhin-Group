#task 8

##Serial Collector

    mvn exec:java -Dcl.args="-Xms6m -Xmx18m -XX:MaxNewSize=2m -XX:PermSize=20m -XX:MaxPermSize=30m -XX:+UseSerialGC"

##Parallel Collector

    mvn exec:java -Dcl.args="-Xms3m -Xmx12m -XX:MaxNewSize=1m -XX:PermSize=20m -XX:MaxPermSize=20m -XX:+UseParallelGC"

##Parallel Old Collector

    mvn exec:java -Dcl.args="-Xms9m -Xmx18m -XX:MaxNewSize=3m -XX:PermSize=40m -XX:MaxPermSize=40m -XX:+UseParallelOldGC"

##CMS with 2 threads

    mvn exec:java -Dcl.args="-Xms6m -Xmx18m -XX:MaxNewSize=2m -XX:PermSize=20m -XX:MaxPermSize=30m -XX:+UseConcMarkSweepGC -XX:ConcGCThreads=2"

##G1 Collector

    mvn exec:java -Dcl.args="-Xms4m -Xmx16m -XX:MaxNewSize=2m -XX:PermSize=12m -XX:MaxPermSize=18m -XX:+UseG1GC"