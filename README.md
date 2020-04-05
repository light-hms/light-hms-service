[![Run in Insomnia}](https://insomnia.rest/images/run.svg)](https://insomnia.rest/run/?label=HMS&uri=https%3A%2F%2Fraw.githubusercontent.com%2Flight-hms%2Flight-hms-service%2Fmaster%2Finsomnia_latest.json)

# Lightweight HMS

## Local database
Run it as below in docker
`docker rm -f postgres_hms ; docker run --rm -d --name postgres_hms -e POSTGRES_DB=hms_local -e POSTGRES_USER=hms -e POSTGRES_PASSWORD=hms -p 5473:5432 postgres:11.6`