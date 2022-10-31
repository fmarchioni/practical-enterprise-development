## Example how to invoke EJBs over SSL which are using a Security Domain (Updated)

### Configure Keystores and Elytron subsystem:

/subsystem=elytron/key-store=tlsTrustStore:import-certificate(alias=client,path=/home/francesco/git/practical-enterprise-development/code/security/ee-ejb-elytron-ssl2/client/tlsClient.cer,credential-reference={clear-text=serverTrustSecret},trust-cacerts=true,validate=false)



keytool -importcert -keystore /home/francesco/git/practical-enterprise-development/code/security/ee-ejb-elytron-ssl2/client/tlsClient.truststore -storepass clientTrustSecret -alias localhost -trustcacerts -file /home/francesco/jboss/wildfly-preview-27.0.0.Beta1/standalone/configuration/tlsServer.cer -noprompt



./elytron-tool.sh credential-store --create --location "tlsCredStore.cs" --password clientStorePassword


./elytron-tool.sh credential-store --location "tlsCredStore.cs" --password clientStorePassword --add example_user --secret examplePwd1!