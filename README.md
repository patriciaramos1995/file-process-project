# FileProcessProject

#### Esse projeto visa realizar leitura e processamento de arquivos .dat separando os clientes, vendedores, vendas e itens vendidos, de forma que seja retornado um relatório com os seguintes dados:

<ul>
<li>Quantidade de clientes no arquivo de entrada</li>
<li>Quantidade de vendedor no arquivo de entrada</li>
<li>ID da venda mais cara</li>
<li>O pior vendedor</li>
</ul>

<u>Requisito</u>: <b>docker instalado</b>, <b>possuir o java 11 e gradle configurado</b>.

#### Para executar o projeto siga os seguintes passos abaixo:

<ol>
<li> Clone o projeto</li>
<p> Na <code>{home_usuario_local}/data/in/</code> adicione os arquivos à serem processados. 
Pode ser utilizada a pasta que está no projeto com o arquivo de teste Arquivo_Exemplo.dat que está na 
<code>{pasta_projeto_clonado}/data/in</code></p>
<li> Estando dentro da pasta do projeto, realize os seguintes comandos:</li>
<br>
Para subir o banco mysql utilize o seguinte comando docker:
<br>
<code> docker-compose up mysql-files </code>
<br><br>
Para rodar a aplicação dê o seguinte comando gradle:
<br>
<code>./gradlew bootRun</code>
<br><br>
<li> Será gerado o arquivo processado na pasta <code>{home_usuario_local}/data/out/</code> com o nome de <b>process-result.done.dat</b></li>

<br>
</ol>

