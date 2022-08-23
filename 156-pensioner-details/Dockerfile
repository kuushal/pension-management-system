FROM public.ecr.aws/ews-network/amazoncorretto:11-alpine
EXPOSE 8083
ADD target/pensioner-detail.jar pensioner-detail.jar
ENTRYPOINT ["java", "-jar","pensioner-detail.jar"]