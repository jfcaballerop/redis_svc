# Run Redis Standalone
docker run --name myredis -p 6379:6379  -d redis

*Dockerfile*:

    spring.redis.port=6379
    spring.redis.password=
    spring.redis.host=localhost



# Docker Compose
docker-compose build

docker-compose run [-d]

*docker-compose.yml*:

    version: '3'
    services:
    web:
        build: .
        ports:
        - "16379:16379"
        links:
        - "redis:localhost"
    redis:
        image: redis

Hacer el cambio para el Dockerfile

*Dockerfile*:

    spring.redis.port=6379
    spring.redis.password=
    spring.redis.host=redis