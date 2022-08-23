FROM public.ecr.aws/ews-network/amazoncorretto:11-alpine
EXPOSE 8085
ADD target/process-pension.jar process-pension.jar
ENTRYPOINT ["java", "-jar","process-pension.jar"]