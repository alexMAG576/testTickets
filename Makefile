DEFAULT_GOAL := build-run

setup:
	gradle wrapper --gradle-version 8.3

clean:
	./app/gradlew -p app clean

build:
	./app/gradlew -p app clean build

install:
	./app/gradlew -p app install

run-dist:
	./app/build/install/app/bin/app
