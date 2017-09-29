### smi-service-dell-server-inventory

Connects via the IDRAC on a Dell server and collects a comprehensive inventory.

Copyright © 2017 Dell Inc. or its subsidiaries.  All Rights Reserved. 

### Purpose
The dell-server-inventory container is a stateless spring-boot microservice that exposes a REST API for the purpose of returning a comprehensive JSON formatted inventory of a Dell 11th generation and newer server.

The service can be called without a callback URL in order to run synchronously.  If a callback URL is provided in the payload, the service will return immediately and post to the callback URL when the results are available.

---

### How to Use

#### Startup
Standalone, with no configuration settings provided:
```
docker run --name service-server-inventory -p 0.0.0.0:46011:46011 -d rackhd/dell-server-inventory:latest
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

### Licensing
Licensed under the Apache License, Version 2.0 (the “License”); you may not use this file except in compliance with the License. You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an “AS IS” BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.

Source code for this microservice is available in repositories at https://github.com/RackHD.  

The microservice makes use of dependent Jar libraries that may be covered by other licenses. In order to comply with the requirements of applicable licenses, the source for dependent libraries used by this microservice is available for download at:  https://bintray.com/rackhd/binary/download_file?file_path=smi-service-dell-server-inventory-dependency-sources-devel.zip

Additionally the binary and source jars for all dependent libraries are available for download on Maven Central.

RackHD is a Trademark of Dell EMC

---

### Support
Slack Channel: codecommunity.slack.com
