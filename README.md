````# Desafio Sicredi - API Pauta 

Objetivo 

No cooperativismo, cada associado possui um voto e as decisões são tomadas em assembleias, por votação. 
A partir disso, você precisa criar uma solução back-end para gerenciar essas sessões de votação. 
Essa solução deve ser executada na nuvem e promover as seguintes funcionalidades através de uma API 
REST: 

● Cadastrar uma nova pauta; 
● Abrir uma sessão de votação em uma pauta (a sessão de votação deve ficar aberta por um tempo 
determinado na chamada de abertura ou 1 minuto por default); 
● Receber votos dos associados em pautas (os votos são apenas 'Sim'/'Não'. Cada associado é 
identificado por um id único e pode votar apenas uma vez por pauta); 
● Contabilizar os votos e dar o resultado da votação na pauta. 

Para fins de exercício, a segurança das interfaces pode ser abstraída e qualquer chamada para as interfaces 
pode ser considerada como autorizada. A escolha da linguagem, frameworks e bibliotecas é livre (desde que 
não infrinja direitos de uso). 
É importante que as pautas e os votos sejam persistidos e que não sejam perdidos com o restart da aplicação.

## 🚩 ATENÇÃO

!!! Ponto importante para quem chega até o dia de hoje(02/07/21), a API não está ainda concluída !!! Está em desenvolvimento, mas deixo a disposição para acompaharem a sua criação.


 
### 📋 Pré-requisitos

Para rodar este projeto você terá que ter instalado as seguintes tecnologias:

- [Java](https://www.oracle.com/br/java/technologies/javase/javase-jdk8-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)


### 🔧 Instalação

Você pode rodar a IDE de sua preferência, deixo aqui algumas como sugestão de ótima performance:

- [Eclipse](https://www.eclipse.org/downloads/)
- [IntelliJ IDEA](https://www.jetbrains.com/pt-br/idea/)


## 🛠️ Construído com

- [Spring Boot](https://spring.io/projects/spring-boot) - O Spring é um framework open source para a plataforma Java.
- JPA - Java Persistence API é uma API padrão da linguagem Java que descreve uma interface comum para frameworks de persistência de dados.
- Lombok - O Lombok é uma biblioteca Java focada em produtividade e redução de código
- [Maven](https://maven.apache.org/) - Gerente de Dependência
- PostgreeSQL
- Docker



