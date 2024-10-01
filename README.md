# hackyeah2024

## Running microservices
It is important to keep (at least partially) order off starting:
1. Keycloak
2. Config Server
3. Eureka - discovery server
4. Api Gateway
5. Others ...

> Some of microservices require having created database a head of time. 

## Run docker container

```shell
docker-compose up --build -d
```

To clean up containers with voulumes use
```shell
docker-compose down --volumes
```

## Running protoc

https://repo1.maven.org/maven2/io/grpc/
### Java

Important Note: 
- Binary doesn't work with PATH thus for the sake of potentially wasted time paste binary to folder where using it.
- In case of packages conflicts paste generated 2 files into "domain folder" ( if recommender client folder "recommender")


```shell
protoc -I=resources/proto \
    --java_out=java/recommender/ \
    --grpc-java_out=java/recommender \
    --plugin=protoc-gen-grpc-java=protoc-gen-grpc-java-1.62.2-osx-x86_64.exe \
    resources/proto/recommender.proto
```


### Python 
```shell
pip install grpcio grpcio-tools
```
```shell
python -m grpc_tools.protoc -I. \
    --python_out=. \
    --grpc_python_out=. \
    recommender.proto
```