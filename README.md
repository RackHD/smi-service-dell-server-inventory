### smi-service-dell-server-inventory

Connects via the IDRAC on a Dell server and collects a comprehensive inventory.

### Purpose
The dell-server-inventory container is a stateless spring-boot microservice that exposes a REST API for the purpose of returning a comprehensive JSON formatted inventory of a Dell 11th generation and newer server.

The service can be called without a callback URL in order to run synchronously.  If a callback URL is provided in the payload, the service will return immediately and post to the callback URL when the results are available.

---

### How to Use

Under Construction. Docker container not yet published on DockerHub..... 

#### Startup
Standalone, with no configuration settings provided:
```
docker run --name service-server-inventory -p 0.0.0.0:46011:460011 -d rackhd/dell-server-inventory:latest
```
The service can also start up to bootstrap its configuration from consul.  More information about registration with and using advanced configuration settings provided by a Consul K/V store can be found in the online help.

#### API Definitions

A swagger UI is provided by the microservice at http://<<ip>>:46011/swagger-ui.html

##### Syncronous API's
- http://<<ip>>:46011/api/1.0/server/inventory/hardware
- http://<<ip>>:46011/api/1.0/server/inventory/software
- http://<<ip>>:46011/api/1.0/server/inventory/nics
- http://<<ip>>:46011/api/1.0/server/inventory/summary
- http://<<ip>>:46011/api/1.0/server/inventory/boot
- http://<<ip>>:46011/api/1.0/server/inventory/bios
- http://<<ip>>:46011/api/1.0/server/inventory/logs/get/SEL
- http://<<ip>>:46011/api/1.0/server/inventory/logs/get/LC

##### Example Post (Without Callback)
~~~
http://<<ip>>:46011/api/1.0/server/inventory/hardware
{
  "address": "<<Target IDRAC IP>>",
  "password": "calvin",
  "userName": "root"
}
~~~

##### Asyncronous API's
- http://<<ip>>:46011/api/1.0/server/inventory/callback

##### Example Post (With Callback)
~~~
http://<<ip>>:46011/api/1.0/server/inventory/callback
{
  "credential": {
    "address": "<<Target IDRAC IP>>",
    "password": "calvin",
    "userName": "root"
  },
  "callbackUri": "http://<<ip>>:<<port>>/your/callback/path",
  "type": "hardware"
}
~~~
- ###### _supported callback types are {hardware, software, nics, summary, boot and bios}_
---

### Support
Slack Channel: codecommunity.slack.com