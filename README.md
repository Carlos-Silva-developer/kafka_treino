## Intro

Este projeto tem como finalidade fazer produção e consumo de mensagens 
via kafka com java puro.

### Requisitos

O projeto usa java 11 e outros artefatos necessários contidos no pom.xml,

o arquivo de configuração para subir kafka e zookepper via docker-compose 
estão no arquivo zk-single-kafka-single.yml

após o container estar rodando com os serviços ativos executar o comando no terminal:

#### docker exec -it kafka1 kafka-topics --create --bootstrap-server 0.0.0.0:9092 --replication-factor 1 --partitions 1 --topic my-topic

Este comando irá criar o tópico my-topic(que utilizamos no exmplo java) na instancia do kafka.
a partir dai ao executarmos o producer criamos a mensagem desejada e ao executar
o consumer serão exibidas TODAS as mensagens gravadas no tópico(é possivel mudar este comportamento na implantação).