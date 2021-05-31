#!/bin/bash


export AWS_DEFAULT_OUTPUT="yaml"
export AWS_CLI_FILE_ENCODING=UTF-8
export AWS_ACCESS_KEY_ID=AKIATTZHX7JXH5MWUJFQ
export AWS_SECRET_ACCESS_KEY=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
export AWS_DEFAULT_REGION=ap-northeast-1
aws sts get-caller-identity --no-paginate --no-cli-pager

#yum install -y java-1.8.0-openjdk-devel.x86_64
export JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk-1.8.0.282.b08-1.amzn2.0.1.x86_64
/project/gradlew build

aws ecr get-login-password --region ap-northeast-1 | docker login --username AWS --password-stdin 248654592622.dkr.ecr.ap-northeast-1.amazonaws.com

docker build -t portforio_backend .

docker tag portforio_backend:latest 248654592622.dkr.ecr.ap-northeast-1.amazonaws.com/portforio_backend:latest

docker push 248654592622.dkr.ecr.ap-northeast-1.amazonaws.com/portforio_backend:latest