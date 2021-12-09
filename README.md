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

Mixed with Api Gateway + Kubernetes sample for now.
Below is instructions to use it.

Build BE service 
```shell
cd sample-be-service && ./gradlew clean assemble && lima nerdctl build -n k8s.io  -t sample-be-service . && cd ..
```
Deploy Back-end service
```shell script
kubectl apply -f sample-be-service/deployment.yml
```

**K8S scripts are not tested due to problems with Rancher and Local images for now.**

--- Nerd CTL documentation: https://itnext.io/rancher-desktop-and-nerdctl-for-local-k8s-dev-d1348629932a
