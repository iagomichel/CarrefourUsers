# Carrefour - Listagem de usuários

<em>Aplicativo para mostrar os usuários do Carrefour.</em>

Aplicativo escrito em Kotlin com arquitetura MVVM, que mostra uma listagem de usuários. App escrito levando em consideração o Clean Code e principios do SOLID. Implementado 100% de cobertura de testes unitários para os ViewModels e Repositories, assim como implementado os testes instrmentados para a tela de listagem de usuário.
</br> 
</br>


# Carrefour usa as seguintes tecnologias para funcionar:

<ul>
  <li><b>Linguagem de programação</b>: O aplicativo é desenvolvido principalmente em Kotlin, uma linguagem moderna e concisa que roda na Máquina Virtual Java (JVM).</li>
  <li><b>Arquitetur</b>a: O aplicativo segue a arquitetura Model-View-ViewModel (MVVM), utilizando o Jetpack ViewModel para gerenciar os dados da interface do usuário. Veja mais abaixo</li>
  <li><b>Bibliotecas do Jetpack</b>: O aplicativo utiliza várias bibliotecas do Android Jetpack, incluindo:
    <ul>
      <li><b>Core KTX</b>: Fornece extensões Kotlin para APIs principais do Android.</li>
      <li><b>AppCompat</b>: Permite o uso de recursos recentes em versões mais antigas do Android.</li>
      <li><b>Material</b>: Implementa o Material Design, oferecendo componentes de interface de usuário modernos.</li>
      <li><b>ConstraintLayout</b>: Biblioteca para criação de layouts flexíveis e responsivos.</li>
      <li><b>Lifecycle</b>: Oferece classes e métodos para criar aplicativos com melhor suporte a ciclo de vida.</li>
      <li><b>Fragment Testing</b>: Fornece suporte para testes de fragmentos.</li>
      <li><b>Test e Espresso</b>: Bibliotecas de teste para testes de unidade e instrumentados.</li>
    </ul>
  </li>
  <li><b>Retrofit</b>: É utilizada a biblioteca Retrofit para realizar requisições HTTP e consumir APIs RESTful. O Retrofit é uma biblioteca de cliente HTTP de código aberto amplamente utilizada para Android.</li>
  <li><b>Moshi</b>: É utilizada a biblioteca Moshi para fazer a serialização e desserialização de objetos JSON. O Moshi é uma biblioteca moderna e eficiente para manipulação de JSON em Kotlin.</li>
  <li><b>Koin</b>: É utilizada a biblioteca Koin como um injetor de dependência leve e simples. O Koin facilita a configuração e a resolução de dependências em aplicativos Kotlin.</li>
  <li><b>Coroutines</b>: O aplicativo utiliza coroutines do Kotlin para lidar com operações assíncronas e concorrência de forma simplificada. As coroutines são uma maneira eficiente de lidar com tarefas assíncronas sem bloquear a thread principal.</li>
  <li><b>Picasso</b>: É utilizada a biblioteca Picasso para carregar e exibir imagens de forma fácil e eficiente.</li>
</ul>

# Arquitetura Model View View Model (MVVM).

![image](https://github.com/iagomichel/CarrefourUsers/assets/50705624/b08656e2-66ba-4103-8c75-13173b53706b)

</br> 

# Como rodar os testes unitários?
Para rodar os testes unitários, no terminal digitar: <b>./gradlew test</b>
![image](https://github.com/iagomichel/CarrefourUsers/assets/50705624/546810ba-9e6d-494e-b730-cdcf023f16c4)
</br> 
# Como rodar os testes instrumentados?
Para rodar os testes instrumentados, conectar Emulador Android ou Dispositivo fisico e no terminal digitar: <b>./gradlew connectedAndroidTest</b>
![image](https://github.com/iagomichel/CarrefourUsers/assets/50705624/70ab2125-3b08-4dc7-92a2-a63400fae039)

</br> 

# O projeto não tem comentários no código, devido ao Clean Code - Comments are a code smell?
Esse princípio é baseado na ideia de que um código bem escrito deve ser autoexplicativo e fácil de entender sem a necessidade de comentários explicativos. Em vez de adicionar comentários para explicar o que o código faz, é preferível escrever um código claro e de fácil compreensão, utilizando nomes significativos para variáveis, funções e classes.

</br> 

# Existem PULL REQUESTS para todas as features do APP.
Para cada funcionalidade do APP, foi aberto um Pull Request, assim para mostrar dominio no GIT, e para que ficasse melhor registrado o histórico e etapas do desenvolvimento.

Esses PULL Requests podem ser analisados aqui -> 
https://github.com/iagomichel/CarrefourUsers/pulls?q=is%3Apr+is%3Aclosed

![image](https://github.com/iagomichel/CarrefourUsers/assets/50705624/0c030d99-6d9c-4d22-859c-576140cfac18)

# Planejamento do projeto
As alterações propostas ainda não foram concluídas devido à adoção de uma metodologia ágil para o desenvolvimento do projeto. Utilizei o planejamento em sprints, o que permitiu quebrar o trabalho em etapas gerenciáveis. Na primeira sprint, foquei na criação da tela de usuários, definição da arquitetura do projeto e implementação inicial do aplicativo. Seguindo essa abordagem, busco garantir um desenvolvimento estruturado e de qualidade, permitindo a entrega de uma solução sólida e atendendo às necessidades dos usuários. O trabalho continuará nas sprints subsequentes, avançando com novas funcionalidades e melhorias conforme o planejamento estabelecido.

# Link para baixar o Build APK para instalar o aplicativo:
https://drive.google.com/file/d/1Pt58K6bHGV-g8cUAye6nPt5XM927EOKU/view?usp=sharing

<a href="mailto:iago.michelazevedo@gmail.com" target="_blank" >
  <img src="https://ssl.gstatic.com/ui/v1/icons/mail/rfr/logo_gmail_lockup_default_1x.png" alt="E-mail" witdh="44" height="44" hspace="10">
</a>

<a href="http://linkedin.com/in/iago-michel-azevedo-b05150122" target="_blank" >
  <img src="https://upload.wikimedia.org/wikipedia/commons/c/c9/Linkedin.svg" alt="E-mail" witdh="44" height="44" hspace="10">
</a>


