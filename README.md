curl -X POST http://localhost:8090/api/callme/call -d "{\"id\":1,\"message\":\"Rajesh\"}" -H "Content-Type: application/json"

curl -X POST http://localhost:8090/api/caller/send/Rajesh
 
curl -X GET http://localhost:8090/api/caller/conversations 

curl http://localhost:8080/caller-me/default -H "X-Config-Token: s.kK6pN0zMfBT9fxqCRfiFtHy2"