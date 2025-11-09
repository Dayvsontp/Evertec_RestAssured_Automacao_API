![poster](https://github.com/Dayvsontp/newman_serverest/blob/master/Postman/restAssured.png)

## 🤘 Sobre

Repositório do projeto de testes automatizados de API site dog Api "https://dog.ceo/dog-api/documentation", construído com RestAssured + Junit5! O RestAssured é uma ferramenta de código aberto que realiza requisições do protocolo HTTP, a automação de testes em componentes api, oferecendo uma abordagem eficaz e altamente confiável.

## 💻 Tecnologias e Requisitos
- InteliJ Idea
- Maven
- JDK 21
- RestAssured
- Junit 5
- Github Actions
- Tesults

## 🤖 Como executar

1. Clonar o repositório ou fork.
```
biuldar as dependencias do arquivo pom.xml
```

2. Executar testes em Headless no Github Actions
```
Existe um gatilho "workflow_dispatch:" que podemos disparar o job a qualquer momento no projeto
```

3. Executar o relatório dos testes
```
Foi gerado um token na plataforma Tesults que foi utilizado neste desafio, o Tesults é uma plataforma paga, mas podemos usar a versão free por um periodo de tempo, então, foi parametrizado no codigo no arquivo pom.xml e no arquivo TestRest.yml e no secret do github Actions para ser enviado os testes para plataforma

```

<hr>
