
# Precreate logs folder
mkdir -p logs

# Start app as a daemon
nohup java -jar target/spring-boot-2-template-0.0.1-SNAPSHOT.jar  --spring.profiles.active=dev > logs/sb2-template-$(date +%Y%m%d-%H%M%S).log 2>&1 &
