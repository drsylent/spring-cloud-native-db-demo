set -e

./mvnw clean package

podman manifest rm quay.io/drsylent/cloud-native-db-demo:springboot4
podman build --platform linux/amd64,linux/arm64 --pull --manifest quay.io/drsylent/cloud-native-db-demo:springboot4 .

