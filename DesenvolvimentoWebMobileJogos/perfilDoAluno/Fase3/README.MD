## FASE 03

Nesta fase iremos adicionar novos elementos de nosso aprendizado no projeto Perfil do Aluno. Deverão ser desenvolvidas as seguintes novas características ao projeto:

### Requisitos:

- Deverá ser criada uma maneira de inserir novas UCs na lista de UCs já existentes.  
  Não é necessário salvar os novos elementos em banco de dados, apenas mostrar na tela.  
  Pode ser feito utilizando a função `prompt`.

- Deverá permitir a ordenação manual das UCs, ou seja, clicando em uma seta para cima ou para baixo, a UC selecionada deve mudar de ordem na tabela que está sendo mostrada.  
  Pode-se utilizar a abordagem de arrastar a célula também.

- Deverá ser incluído o campo **CPF** no formulário e, depois de digitar o valor, ao sair do mesmo, o sistema deve validar se o valor do CPF digitado obedece à máscara padrão de CPF (`ddd.ddd.ddd-dd`).

- Ao digitar o **e-mail** e sair do campo, deve-se validar a máscara base do e-mail.

- Crie a possibilidade da inserção de **novas informações relacionadas à sua descrição de perfil pessoal**.  
  Para este item, não utilize `prompt`; utilize a entrada direta no HTML e DOM.
