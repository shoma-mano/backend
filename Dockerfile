FROM amazonlinux

RUN yum install -y java-1.8.0-openjdk-devel.x86_64

COPY /build/libs/backend.jar /