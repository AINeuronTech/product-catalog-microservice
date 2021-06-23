FROM openjdk:8
ADD target/product-catalog-services-0.0.1-SNAPSHOT.jar product-catalog-services-0.0.1-SNAPSHOT.jar
EXPOSE 8083
ENTRYPOINT ["java","-jar", "product-catalog-services-0.0.1-SNAPSHOT.jar"]
