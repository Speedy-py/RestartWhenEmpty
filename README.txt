BUILD (needs JDK 25 + Maven):
  mvn package
  -> target/RestartWhenEmpty-1.0.0.jar  -> put in your server's plugins/ folder

REQUIRED so the server actually comes back after a restart:
1) In spigot.yml set:   settings:  restart-script: ./start.sh   (or start.bat on Windows)
2) Start the server ONLY through a looping script:

start.sh (Linux):
  #!/bin/sh
  while true; do
    java -Xmx4G -jar purpur.jar nogui
    echo "Restarting in 5s (Ctrl+C to stop)"; sleep 5
  done

start.bat (Windows):
  @echo off
  :loop
  java -Xmx4G -jar purpur.jar nogui
  timeout /t 5
  goto loop

Permission for /restart: restartwhenempty.restart (op by default).
