WILDFLY_HOME=/home/francesco/jboss/wildfly-preview-27.0.0.Beta1

$WILDFLY_HOME/bin/jboss-cli.sh --connect <<EOF


/subsystem=elytron/key-store=tlsKeyStore:add(path=tlsServer.keystore,relative-to=jboss.server.config.dir,credential-reference={clear-text=serverKeySecret})

/subsystem=elytron/key-store=tlsKeyStore:generate-key-pair(alias=localhost,algorithm=RSA,key-size=2048,validity=365,credential-reference={clear-text=serverKeySecret},distinguished-name="CN=localhost")

/subsystem=elytron/key-store=tlsKeyStore:store()

/subsystem=elytron/key-manager=tlsKM:add(key-store=tlsKeyStore,credential-reference={clear-text=serverKeySecret})

/subsystem=elytron/server-ssl-context=tlsSSC:add(key-manager=tlsKM,protocols=["TLSv1.3","TLSv1.2"],cipher-suite-names=TLS_AES_128_GCM_SHA256)

/subsystem=undertow/server=default-server/https-listener=https:write-attribute(name=ssl-context,value=tlsSSC)

reload

exit

EOF

