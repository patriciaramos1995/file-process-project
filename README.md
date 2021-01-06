# FileProcessProject

#### Esse projeto visa realizar leitura e processamento de arquivos .dat separando os clientes, vendedores, vendas e itens vendidos, de forma que seja retornado um relatório com os seguintes dados:

<ul>
<li>Quantidade de clientes no arquivo de entrada</li>
<li>Quantidade de vendedor no arquivo de entrada</li>
<li>ID da venda mais cara</li>
<li>O pior vendedor</li>
</ul>

<u>Requisito</u>: <b>docker instalado</b> ou caso execute o projeto sem subir o container, <b>possuir o java 11
configurado</b>.

#### Para executar o projeto siga os seguintes passos abaixo:

<ol>
<li> Clone o projeto</li>
<br>
<li> Estando dentro da pasta do projeto, realize os seguintes comandos:</li>
<br>
<code> docker-compose build </code>
<br>
<code> docker-compose up mysql-files </code>
<br>
<code> docker-compose up file-process-project </code>
<br><br>
<li>
Dentro do projeto, já existe uma pasta na home do container docker seguido do diretório <b>/data/in/</b>. Essa pasta já 
possui um arquivo para testes. No passo 2, a aplicação irá executar e será criada a pasta <b>{home_docker}/data/out/</b> 
e dentro dela será gerado o arquivo <b>process-result.done.dat</b> com os resultados</li>
<br>
</ol>

