-- Instruções de uso

- Executar o arquivo Lombok.jar na pasta Utils. Ele localizará automaticamente a pasta raiz de instalação do eclipse/netbeans e fará a instalação do plugin.
- Alterar a porta no arquivo application.properties. Utilizei a porta 8081 como default para desenv.
- Para tornar a persistência do banco H2 em arquivo (reiniciar a aplicação reseta o banco de dados caso o H2 esteja configurado para utilizar a memória do computador) basta descomentar a linha 17 do arquivo application.properties e comentar a linha 16.
- Rodar o projeto na IDE desejada.
- Para testar a aplicação, utilize o swagger-ui (localhost:porta/swagger-ui.html) ou a aplicação web que disponibilizei no repositório.

-- Rodando a aplicação web para testes
- Utilizar o browser-sync ou rodar o comando python -m SimpleHTTPServer porta na pasta CLIENTE-BROWSER.

-- Tecnologias utilizadas

- Lombok: é um utilitário para classes Java que permite o uso de annotations para criação automática de getters/setters e construtores. 
- H2: É um banco de dados embbed que pode ser utilizado em memória. Muito útil para desenvolvimento sem depender de um SGBD;
- Swagger: É a UI de testes das requests. Muito útil para testar as requests sem precisar desenvolver uma página web;
- Spring Boot: É o coração da aplicação, em conjunto com Hibernate/JPA é um kit muito completo para desenvolver APIs em Java.
- Maven: gerenciador de dependências