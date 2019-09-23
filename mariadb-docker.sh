#!/bin/bash

if [ "$1" == "install" ]; then
        docker run -p3306:3306 --name otp-mariadb -e MYSQL_ROOT_PASSWORD=passwrd -d mariadb:10.3
elif [ "$1" == "start" ]; then
        docker restart otp-mariadb
elif [ "$1" == "stop" ]; then
        docker stop otp-mariadb
elif [ "$1" == "status" ]; then
	echo "Running from:"
	echo "$(docker inspect --format '{{ .NetworkSettings.IPAddress }}' otp-mariadb)"
        docker ps
elif [ "$1" == "login" ]; then
	mysql -h $(docker inspect --format '{{ .NetworkSettings.IPAddress }}' otp-mariadb) -u root -p
else
	echo
	echo "Select from these commands:"
	echo "install"
	echo "start"
	echo "stop"
	echo "status"
	echo "login"
fi
