# lembrete

- findAll

http://localhost:8081/pessoas

- create pessoa

http://localhost:8081/pessoas/create

body:

  {

    "nome": "JESUS" 
  }

- buscarporNome

http://localhost:8081/pessoas/nome/jesus


+++++++++++++++++++

-create lembrete

http://localhost:8081/lembretes/jesus

body:

  {
    "texto": "louco por ti corinthians" 
  }

-delete

http://localhost:8081/lembretes/{id}

-put

http://localhost:8081/lembretes/{id}

body:

 {
    "texto": "louco por ti corinthians" 
  }

