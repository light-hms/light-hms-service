# Lightweight HMS

## Local database
Run it as below in docker
`docker rm -f postgres_hms ; docker run --rm -d --name postgres_hms -e POSTGRES_DB=hms_local -e POSTGRES_USER=hms -e POSTGRES_PASSWORD=hms -p 5473:5432 postgres:11.6`