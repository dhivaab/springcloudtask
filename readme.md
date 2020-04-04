create new task with arguments 
---------------------------------
cf run-task springcloudtask ".java-buildpack/open_jdk_jre/bin/java org.springframework.boot.loader.JarLauncher --spring.batch.job.names=job1" --name cognizant1
<br>
cf run-task springcloudtask ".java-buildpack/open_jdk_jre/bin/java org.springframework.boot.loader.JarLauncher --spring.batch.job.names=job2" --name cognizant2

create new job with arguments
--------------------------------
.java-buildpack/open_jdk_jre/bin/java org.springframework.boot.loader.JarLauncher --spring.batch.job.names=job1
<br>
.java-buildpack/open_jdk_jre/bin/java org.springframework.boot.loader.JarLauncher --spring.batch.job.names=job2


create schduler service 
--------------------------

cf create-service scheduler-for-pcf standard mapsschduler
<br>
cf bind-service springcloudtask my-instance

pushing to cloud foundry
--------------------------
cf push springcloudtask --no-start




