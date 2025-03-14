# remote-jvm
## Descrizione
remote-jvm è stata sviluppata per avere un'applicazione sulla quale monitorare, via JMX, il valore di heap memory utilizzato. Al fine di facilitare il processo di monitoraggio, remote-jvm espone l'MBean **HeapManager** con l'ObjectName **it.tabaqui:type=Memory,name=HeapManager**.
## HeapManager
HeapManager espone alcune operazioni che consentono di modificare a runtime la memoria heap utilizzata dall'applicazione e che potranno essere facilmente invocate via **jconsole** mentre remote-jvm e l'applicazione client sono in esecuzione. Le operazioni consentite sono le seguenti:
### free()
Libera la memoria allocata. NB: Il garbage collector non viene invocato: bisognerà attendere il prossimo ciclo oppure chiamarlo manualmente tramite l'MBean **java.lang:type=Memory**.
### push(int count)
Aggiunge alla memoria heap utilizzata circa **count** MB.
### push()
Aggiunge alla memoria heap utilizzata circa 1 MB.
## Requisiti
* Java 21
## Esecuzione
Per esporre correttamente l'applicazione via JMX potrebbe esser necessario eseguirla aggiungendo alcuni parametri. I test in locale sono stati effettuati con i seguenti valori (inseriti tra doppi apici se si utilizza powershell o cmd):
* -Dcom.sun.management.jmxremote.port=9999 (o altra porta)
* -Dcom.sun.management.jmxremote.authenticate=false
* -Dcom.sun.management.jmxremote.ssl=false
Es:
```
java "-Dcom.sun.management.jmxremote.port=9999" "-Dcom.sun.management.jmxremote.authenticate=false" "-Dcom.sun.management.jmxremote.ssl=false" -jar ./remote-jvm.jar
```
