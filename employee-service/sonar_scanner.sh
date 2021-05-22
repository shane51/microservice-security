docker run \
    --rm \
    --network=host\
    -e SONAR_HOST_URL="http://localhost:9000" \
    -e SONAR_LOGIN="your_sonar_token" \
    -v "$(pwd):/usr/src" \
    sonarsource/sonar-scanner-cli