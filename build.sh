set -e

./mvnw clean package

podman build --platform linux/amd64,linux/arm64 --pull --manifest quay.io/drsylent/cloud-native-db-demo:springboot4 .

