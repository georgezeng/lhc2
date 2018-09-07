!/usr/bin/env bash
rm -r /root/app/apollo-ui/*

# build the image based on the Dockerfile and name it `nvm`
docker build -t nvm .

# enter container terminal
docker run --name nvm nvm
docker cp nvm:/usr/src/apollo-ui /root/app/
docker rm nvm
