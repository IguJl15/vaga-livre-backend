#!/bin/bash

export DB_URL="jdbc:postgresql://host.supabase.com:5432/postgres"
export DB_USERNAME=postgres
export DB_PASSWORD=pass



mvn spring-boot:build-image-no-fork -Dname=vagalivre/backend-0.0.1 -DskipTests \
	-Dflyway.url=$DB_URL \
	-Dflyway.user=$DB_USERNAME \
	-Dflyway.password=$DB_PASSWORD

unset DB_URL
unset DB_USERNAME
unset DB_PASSWORD
