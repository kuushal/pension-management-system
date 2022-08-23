FROM public.ecr.aws/ews-network/amazoncorretto:11-alpine
EXPOSE 8080
ADD target/authorization.jar authorization.jar
ENTRYPOINT ["java", "-jar","authorization.jar"]