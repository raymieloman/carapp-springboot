Het ophalen van een image:
In de shell of command van Window
docker image pull nginx

Tonen van de images die ik heb
docker image ls

Het runnen van een CONTAINER aan de hand van een IMAGE
docker container run –dit —name nginx-1 –p 80:80 nginx:latest

Het HERstarten van een BESTAAANDE container met
docker container start  <containerName| containerId>

Het starten van een NGINX container:
docker container run -dit --name=nginx-1 -p 81:80 -v /home/rloman/repo/carapp/docker-demo/home:/usr/share/nginx/html nginx:latest
