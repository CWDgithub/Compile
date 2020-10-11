FROM ubuntu:20.04 
 FROM openjdk:8 
   RUN javac -version 
  WORKDIR / 
 COPY ./* ./ 
 RUN javac Main.java Judge.java