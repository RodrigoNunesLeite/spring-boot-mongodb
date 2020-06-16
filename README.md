

# API com Spring Boot e banco MongoDB

- O projeto foi desenvolvido através do curso https://www.udemy.com/course/java-curso-completo/
- Se trata de uma api para cadastro de usuários, posts e comentários

## Como Executar:
 - Será necessário ter instalado o mongoDB e o MongoDB Compass
 - Também precisa instalar o Spring Tool Suite, se trata de uma versão do eclipse configurada para a construção de serviços usando o Spring Boot
 - Com o ambiente configurado basta fazer download do projeto e executar no Spring Tool Suite e acessar as rotas através do localhost que provavelmente será o 8080. 

A aplicação conta com uma classe "Instantiation" que cria os registros assim que é dado o start na aplicação.

## Rotas criadas
### GET:
- Busca de todos os usuários:  localhost:8080/users
- Busca de usuário por id:  http://localhost:8080/users/AQUI_VAI_O_ID
- Busca posts por id:  localhost:8080/posts/AQUI_VAI_O_ID_DO_POST
- Busca de posts através do titulo:  localhost:8080/posts/titlesearch?text=CONTEUDO_DO_TITULO_QUE_ESTAMOS_PROCURANDO
- Busca algum texto nos titulos do post e texto dos comentários:  localhost:8080/posts/fullsearch?text=aproveite&maxDate=2018-03-22&minDate=2018-03-21
- Busca posts através do ID do usuário:  http://localhost:8080/users/ID_DO_USUARIO/posts

### POST:
- Cadastro de usuários: localhost:8080/users
  - corpo da requisição: {
 "name": "Jose",
 "email": "jose@gmail.com"
} 

### PUT
- Atualização do usuário: localhost:8080/users/ID_DO_USUARIO
 - corpo da requisição:  {
    "id": "5ee82b4a33b02607edff2674",
    "name": "Maria Brown",
    "email": "maria2@gmail.com"
  }

### DELETE 
- Deleção de usuário: localhost:8080/users/ID_DO_USUARIO


