![ImersaoJava](https://user-images.githubusercontent.com/41304141/180502973-63a87ed9-fb0b-4e77-a70b-b7543e41025a.jpg)

<h1 align="center">Imersão Java - Alura</h1>
<h2 align="center">Gerador de Stickers</h2>

<h3> Descrição do projeto </h3>

O projeto consiste em consumir APIs e exrtrair os dados relevantes para a criação de imagens ou figurinhas</br>

-🔨 `Funcionalidade 1`: Consumir e tratar dados de API's;</br>
-🔨 `Funcionalidade 2`: Gerar Stickers(.png) para compartilhar em aplicativos de mensagem;</br>


<h3> ✔️ Técnicas e tecnologias utilizadas </h3>
 
- ``Java 17``
- ``InteliJ IDEA``
- ``Paradigma de orientação a objetos``

## 📁 Repositório API-Linguagens

https://github.com/gabrielmelim/imersao-java-alura-2022/tree/deploy


## Aula 01

-Na primeira aula acessei os dados da API da IMDb (Top 250 Movies)</br>
-Extrai os dados que são relevantes.</br>
-Exibi e manipulei os dados para que eles aparecessem no terminal de forma organizada e estilizada.</br>

![Resultado da Aula 01](https://raw.githubusercontent.com/gabrielmelim/imgs/main/imersao-alura-2022/aula1.png)


## Aula 02

-Comecei a trabalhar na leitura das imagens de cada filme</br>

-Consumindo os dados que vieram da API, utilizei lógica para conseguir extrair imagens dos links recebidos. </br>

-Com as imagens em um tamanho grande, precisei padronizar os tamanhos. Utilizando um resize.</br>

-Adicionei um texto que mostra a nota que o filme recebeu.</br>

![Resultado da Aula 02](https://raw.githubusercontent.com/gabrielmelim/imgs/main/imersao-alura-2022/giff-aula2.gif)

## Aula 03

-Começei um processo de refatoração do código para facilitar o recebimento novas APIs</br>

-Criei a classe ClienteHttp para separa a gestão das urls das APIs.</br>

-Criei o extrator de conteúdos para receber o JSON das APIs e fazer o tratamento específico para extrair os dados.</br>

-Comecei a mudar o projeto um pouco, pois foram encontrados alguns erros ao fazer consumo da api como a bibliteca de regex utilizada só conseguia extrair strings do arquivo json, logo mudamos para uma bibliteca regex que conseguia extrair int,double,string.

-Ao filtrar a lista json da imdb com 250 filmes, tivemos alguns problemas, pois alguns filmes da lista json tinha imagem quebrada, então utilizamos a tratativa try catch para ignorar os filmes da lista cujo a imagem estivesse com formato errado ou indisponível, assim conseguimos rodar a lista com os 250 filmes e retornar 249 pois algum filme da lista estava com a imagem quebrada.

![Aula03jpg](https://raw.githubusercontent.com/gabrielmelim/imgs/main/imersao-alura-2022/aula3-imdb-horz.jpg)
<<<<<<< HEAD


</div>

## Aula 04 

- Criei a minha própria API (https://github.com/gabrielmelim/imersao-java-alura-2022/tree/deploy)</br>

<h3>Detalhes sobre essa API:</h3>

-Projeto Spring utilizando o MongoDB para guardar uma lista de linguagens de programação.

-Fiz um CRUD completo desta API.

![CRUD](https://raw.githubusercontent.com/gabrielmelim/imgs/main/imersao-alura-2022/crud.png)

-Retorna um JSON para ser consumido no Gerador de Stickers(imagem abaixo).

![jsonAPIlinguagensjpg](https://raw.githubusercontent.com/gabrielmelim/imgs/main/imersao-alura-2022/Json.png)


<h2 align="center">Exemplo dos sticker no Whatsapp</h2>

<div align="center">

![StickersExample](https://raw.githubusercontent.com/gabrielmelim/imgs/main/imersao-alura-2022/exemplo.png)

 </div>
 
## Aula 05
- Testando todos os endpoints da API-Linguagens. </br>
- Preparei o projeto para deploy.</br>
- Deploy realizado com sucesso (https://alura-linguagens-api-melim.herokuapp.com/linguagens).</br>

## Bônus

- Implementação futura: Implementar segurança a nossa api utilizando spring security.

<h1 align="center">🌎 Onde você me encontra? 🌍</h1>

## Demonstração da Aplicação 

[![Everything Is AWESOME](https://raw.githubusercontent.com/gabrielmelim/imgs/main/imersao-alura-2022/stickers.png)](https://www.youtube.com/watch?v=OcETjb_gLXM&feature=youtu.be "Imersão Alura 2022 Stickers")

                                    
<div align="center" > 
  <a href="https://www.linkedin.com/in/gabrielmelim/" target="_blank"><img src="https://img.shields.io/badge/-LinkedIn-%230077B5?style=for-the-badge&logo=linkedin&logoColor=white" target="_blank"></a> 
</div

