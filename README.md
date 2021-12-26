# spring-cloud-experiments
A repo with Spring Cloud Samples

Righ now intented mostly for Spring Cloud Streams

SCS documentation: 
https://docs.spring.io/spring-cloud-stream/docs/current/reference/html/spring-cloud-stream.html#_programming_model

Spring Integration documents:
https://docs.spring.io/spring-integration/docs/current/reference/html/index.html

---

To run the docker-compose with lima + nerdctl:
```shell
lima nerdctl compose up -d
```

---

Spring Security Documentation:
https://docs.spring.io/spring-security/reference/servlet/oauth2/resource-server/index.html

Spring Cloud Gateway articles:
https://refactorfirst.com/spring-cloud-gateway-keycloak-oauth2-openid-connect.html
https://github.com/AndriyKalashnykov/sample-spring-security-microservices

Keycloak test realm:
https://github.com/keycloak/keycloak/blob/main/testsuite/integration-arquillian/tests/base/src/test/resources/testrealm.json
https://github.com/keycloak/keycloak-documentation/blob/main/server_admin/topics/export-import.adoc



Mixed with Api Gateway + Kubernetes sample for now.
Below is instructions to use it.

**K8S scripts are not tested due to problems with Rancher and Local images for now.**

Build BE service 
```shell
cd sample-be-service && ./gradlew clean assemble && lima nerdctl build -n k8s.io  -t sample-be-service . && cd ..
```
Deploy Back-end service
```shell script
kubectl apply -f sample-be-service/deployment.yml
```
--- Nerd CTL documentation: https://itnext.io/rancher-desktop-and-nerdctl-for-local-k8s-dev-d1348629932a

Example of the test endpoint:
http://localhost:8080/test-resource/hello
