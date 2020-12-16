docker run -d --name vault --cap-add=IPC_LOCK -e 'VAULT_DEV_ROOT_TOKEN_ID={secret}' -p 8200:8200 vault

vault write secret/caller-service property1='Vault Secret Property 1' property2='Vault Secret Property 2'

curl -X POST http://localhost:8090/api/callme/call -d "{\"id\":1,\"message\":\"Rajesh\"}" -H "Content-Type: application/json"

curl -X POST http://localhost:8090/api/caller/send/Rajesh
 
curl -X GET http://localhost:8090/api/caller/conversations 

curl http://localhost:8080/caller-me/default -H "X-Config-Token: rajeshvaulttoken"